package tn.esprit.infenion.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import tn.esprit.infenion.Entities.Voyage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class VoyageValidatore implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Voyage.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    Voyage voyage = (Voyage) o;
        Date datede = voyage.getDateDeparture();
        Date datearr = voyage.getArrivalDate();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDatede = dateFormat.format(datede);
        String strDatearr = dateFormat.format(datearr);

        if(datearr.before(datede)){
            errors.rejectValue("dateArr","date","vérifier votre date");

        }

    }
}
