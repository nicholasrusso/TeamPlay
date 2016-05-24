package security;

import security.AppSettings;

import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;


public class PasswordUtilities {
	private static final Logger log = Logger.getLogger("PasswordUtilities");

	private PasswordUtilities() {
		// Static class
	}
	public static String getPasswordHash(String password) {
		Properties props = AppSettings.getInstance();
		String salt = props.getProperty("salt");
		MessageDigest md = null;
		String digest; 
		
		byte[] saltbytes;
		byte[] passbytes;
		byte[] saltypassbytes = null;
		try {
			saltbytes = salt.getBytes("UTF-8");
			passbytes = password.getBytes("UTF-8");
			saltypassbytes = new byte[saltbytes.length + passbytes.length];
			System.arraycopy(passbytes, 0, saltypassbytes, 0, passbytes.length);
			System.arraycopy(saltbytes, 0, saltypassbytes, passbytes.length, saltbytes.length);
		} catch (UnsupportedEncodingException e1) {
			log.severe(Arrays.toString(e1.getStackTrace()));
			e1.printStackTrace();
		}
		
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			log.severe(Arrays.toString(e.getStackTrace()));
		}
		
		if (saltypassbytes != null) {
			md.update(saltypassbytes);
		}
		digest = DatatypeConverter.printHexBinary(md.digest());
		log.fine(digest);
		
		return digest;		
	}

}
