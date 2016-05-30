package test;

/*
 * Test Type: Integration Test
 * Author: Michael Haskell
 */

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
import security.AppSettings;
import email.EmailUtilities;

public class TestEmailUtilities {

	/* 
	 * Integration test of AppSettings.getInstance and EmailUtilities.sendEmail
	 */
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
