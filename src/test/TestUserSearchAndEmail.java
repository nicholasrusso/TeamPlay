package test;

/*
 * Test Type: Integration Test
 * Author: Michael Haskell
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

import user.User;
import user.UserSearch;
import security.AppSettings;
import email.EmailUtilities;


public class TestUserSearchAndEmail {


    /*
     * Integration test of UserSearch class and EmailUtilites.
     * Find a user and send an email.
     */
    @Test
    public void test() {
        Properties props = AppSettings.getInstance();

        UserSearch searcher = new UserSearch("mhaskell");
        ArrayList<User> users = searcher.getUsers();

        
        boolean success = false;
        System.out.println(users.size());
        
        if (users.size() == 1) {
            String toAddresses = users.get(0).getEmail().toString();
            System.out.println(toAddresses);
            String subject = props.getProperty("mail.test.subject");
            String content = props.getProperty("mail.test.content");
            success = EmailUtilities.sendEmail(toAddresses, subject, content);
        }
        
        Assert.assertTrue(success);     
    }


}
