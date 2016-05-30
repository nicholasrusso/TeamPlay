package test;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
import security.AppSettings;
import email.EmailUtilities;

public class TestEmailUtilities {

    @Test
    public void test() {
        Properties props = AppSettings.getInstance();
        String toAddresses = props.getProperty("mail.test.address");
        String subject = props.getProperty("mail.test.subject");
        String content = props.getProperty("mail.test.content");
        
        boolean success = EmailUtilities.sendEmail(toAddresses, subject, content);
        Assert.assertTrue(success);
    }

}
