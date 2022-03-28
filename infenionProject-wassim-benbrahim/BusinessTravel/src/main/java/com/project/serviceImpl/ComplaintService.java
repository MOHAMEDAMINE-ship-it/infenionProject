package com.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//import lombok.extern.slf4j.Slf4j;
import com.project.entities.*;
import com.project.services.ISendEmailService;
import com.project.dao.ComplaintRepository;
import com.project.dao.TripRepository;
import com.project.dao.UserRepo;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
//@Slf4j
@Service
public class ComplaintService {

    @Autowired
    UserRepo ur;

    @Autowired
    ComplaintRepository cr;
    @Autowired
    TripRepository tr;
    @Autowired
    ISendEmailService sendemailservice;


    public Complaint add_complaint(Complaint c , Long Id_sender,Long Id_reciver, Long id_trip){
        User u = ur.findById(Id_sender).get();
        User ucr = ur.findById(Id_reciver).get();
        Trip trip = tr.findById(id_trip).get();
        List<User> users = new ArrayList<User>();
        users.add(u);
        users.add(ucr);
        //if(trip.getUsers().containsAll(users)){
        c.setComplainer(u);
        c.setComplainedAbout(ucr);
        c.setDateComplaint(new Date());;
        
      sendemailservice.sendSimpleEmail(ucr.getEmail(),   c.getMessage(),"reclamation");
        return cr.save(c);//}
        //else return null;
    }

    public Optional<Complaint> retrieveReclamation(Long id) {
       return cr.findById(id);
    }
  
	

    public List<Complaint> retrieveAllReclamations() {
        return  (List<Complaint>) cr.findAll();
    }


    public void Delete_complaint(Long Id_Complaint){
        cr.deleteById(Id_Complaint);
    }

    public List<Complaint> FilterByTopic(Topic topic){
        List<Complaint> complaintsBytopic = cr.findAll()
                .stream().filter(c->c.getTopic().equals(topic))
                .collect(Collectors.toList());
//           log.info(complaintsBytopic.toString());
        return complaintsBytopic;

    }

    public Topic most_topic_complained(){
        AtomicInteger nbsecurity= new AtomicInteger();
        AtomicInteger nbservice= new AtomicInteger();
        AtomicInteger nbquality= new AtomicInteger();
        cr.findAll().forEach(c->{
            if(c.getTopic().equals(Topic.Service))
                nbservice.addAndGet(1);
            else if (c.getTopic().equals(Topic.Quality))
                nbquality.addAndGet(1);
            else 
                nbsecurity.addAndGet(1);
        });
        if((nbquality.intValue()>nbsecurity.intValue()) && (nbquality.intValue()>nbservice.intValue()))
            return Topic.Quality;

        else if((nbservice.intValue()>nbsecurity.intValue()) && (nbservice.intValue()>nbquality.intValue()))
            return Topic.Service;
        else
        {
//        	log.info(nbservice +"//nb  sec"+nbsecurity+"//nbql"+nbquality);
            return Topic.Security;}
           


    }



    @Scheduled(cron = "@Weekly")
    public Map<Long, Long> triByUser(){
          Map<Long, Long> m  = new HashMap<Long,Long>();
          ur.findAll().forEach(u-> {
              m.put(u.getId(),nbr_complaints_recieved_each_week(u.getId()));
          });
       return m.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }


    public Long nbr_complaints_recieved_each_week(Long id_user){
        User u = ur.findById(id_user).get();
//        log.info("user"+u);

        if (cr.existsComplaintByComplainer(u) )

        return  u.getComplaints().stream().filter(e->e.getDateComplaint().before(new Date())).filter(e->e.getDateComplaint().
                after(addDays(new Date(), -7))).count();
        else
            return  Long.valueOf(0);
    }
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

@Scheduled(cron = "@Weekly")
    public void attribute_employee_type(){
        int nb=triByUser().size();
        int index=0;
        for (Map.Entry entry : triByUser().entrySet()) {
            if   ((int)((index*100))/nb<=10){
                ur.findById((Long) entry.getKey()).get().setEmployeeType(EmployeeType.Badtravellor);
                index++;
                ur.save( ur.findById((Long) entry.getKey()).get());
            }

            else if  (((int)((index*100))/nb>10)&&((int)((index*100))/nb<70)){
                ur.findById((Long) entry.getKey()).get().setEmployeeType(EmployeeType.GoodTravellor);
                index++;
                ur.save( ur.findById((Long) entry.getKey()).get());
            }
            else {
                ur.findById((Long) entry.getKey()).get().setEmployeeType(EmployeeType.ExcellentTravellor);
                ur.save( ur.findById((Long) entry.getKey()).get());
            }

        }
    }


    @Scheduled(cron = "@Monthly")
    public int Taux_complaints_each_month(){
         List<User> u = (List<User>) ur.findAll();
         AtomicInteger somme= new AtomicInteger();

          u.forEach(us->{
              Calendar cal = Calendar.getInstance();
              cal.setTime(new Date());
              int monthnow = cal.get(Calendar.MONTH);
              if (cr.existsComplaintByComplainer(us) ){

              us.getComplaints().forEach(c-> {
                  Calendar call = Calendar.getInstance();
              cal.setTime(c.getDateComplaint());
              int month = cal.get(Calendar.MONTH);
              if(month==monthnow)
              somme.addAndGet(1);
              });}
          });
          System.out.println("Rate of complaints this month : "+somme.intValue()*100/(cr.findAll().size())+"%");
          return (somme.intValue()*100/cr.findAll().size());
    }



    }
