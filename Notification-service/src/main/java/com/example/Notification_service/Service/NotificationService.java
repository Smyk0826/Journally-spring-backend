package com.example.Notification_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class NotificationService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private JavaMailSender greetSender;

    @Value("${spring.mail.username}")
    private String from;

    public String reminder(List<String> emails){

        String res = "Mail send successfully";
        String emailBody = "Dear User,\n\n" +
        "We noticed you haven’t penned your thoughts today.\n\n" +
        "Even a few quiet lines can make a big difference — for your clarity, for your growth, and for that peaceful moment just for yourself. ✨\n\n" +
        "Your journal is waiting. The typewriter's warm, the cat is napping, and your story is still unfolding.\n\n" +
        "Take a moment, breathe in, and write it out —\n" +
        "We’ll keep the page warm for you. 📝\n\n" +
        "With warmth,\n" +
        "The Journally Team\n\n" +
        "Open My Journal: https://your-app-link.com";
        for(String email : emails){
            try{
                SimpleMailMessage message=  new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(email);
            message.setSubject("A Gentle Nudge from Journally 🌿");
            message.setText(emailBody);
            mailSender.send(message);
            }
            catch (Exception e) {
                System.out.println("email exception : "+ e.getMessage());
                res +=  "Error sending email to : "+email+"\n " ;
            }
        }
        return res;
           
    }

    public String notify(String email, String userName){
        String body = "Hey! "+userName+" very glad to have you on Journally.\n Record your days, your life and your memories with us";
        try{
            SimpleMailMessage message=  new SimpleMailMessage();
           message.setFrom(from);
           message.setTo(email);
           message.setSubject("Journally - Happily Registered");
           message.setText(body);
           greetSender.send(message);
           return "Mail sent successfully";
        }
        catch (Exception e) {
            return "Error sending email: " + e.getMessage();
        }
           
    }

}
