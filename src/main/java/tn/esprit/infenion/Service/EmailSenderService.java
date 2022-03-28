package tn.esprit.infenion.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.internet.MimeMessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;



import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;


@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail, String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("dynaskills123@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Send");
    }

    public void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException, javax.mail.MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("spring.email.from@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystem = new FileSystemResource(new File(attachment));

        mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);

        mailSender.send(mimeMessage);
        System.out.println("Mail Send");

    }
    
    public void pdfCreation() throws IOException
	{
		String filepath="C:\\Users\\khale\\Documents\\GitHub\\reservation.pdf";
		
		try {
			PdfWriter writer=new PdfWriter(filepath);
			writer.write(1);
			PdfDocument pdfdoc=new PdfDocument(writer);
			
			pdfdoc.addNewPage();
			
			Document document=new Document(pdfdoc);
			document.close();
			
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
    
}