package email;

import security.AppSettings;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

public class EmailUtilities {

    public static boolean sendEmail(String toEmails, String subject, String content) {
        Properties props = AppSettings.getInstance();
        Properties emailProps = new Properties();

        String emailHost = props.getProperty("mail.smtp.host");
        String emailUsername = props.getProperty("mail.smtp.username");
        String emailPassword = props.getProperty("mail.smtp.password");
        
        emailProps.put("mail.smtp.ssl.trust", props.getProperty("mail.smtp.host"));
        emailProps.put("mail.smtp.port", props.getProperty("mail.smtp.port"));
        emailProps.put("mail.smtp.auth", props.getProperty("mail.smtp.auth"));
        emailProps.put("mail.smtp.starttls.enable", props.getProperty("mail.smtp.starttls.enable"));
        
        try {
            InternetAddress fromAddress = new InternetAddress(props.getProperty("mail.smtp.from"));
            InternetAddress[] toAddress = InternetAddress.parse(toEmails);
            
            Session session = Session.getDefaultInstance(emailProps, null);     
        
            Message message = new MimeMessage(session);
            message.setFrom(fromAddress);
            message.setRecipients(Message.RecipientType.TO, toAddress);
            message.setSubject(subject);
            message.setText(content);
            
            Transport transport = session.getTransport("smtp");
            
            transport.connect(emailHost, emailUsername, emailPassword);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            
        } catch (MessagingException e) {
            System.out.println("Unable to send email to " + toEmails + ".");
            System.out.print(e.getMessage());
            return false;
        }
        return true;
    }

}

