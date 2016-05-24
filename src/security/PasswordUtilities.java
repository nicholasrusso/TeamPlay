package security;

import security.AppSettings;
import java.util.Properties;

import javax.xml.bind.DatatypeConverter;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;


public class PasswordUtilities {

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
			System.out.println(saltbytes);
			passbytes = password.getBytes("UTF-8");
			saltypassbytes = new byte[saltbytes.length + passbytes.length];
			System.arraycopy(passbytes, 0, saltypassbytes, 0, passbytes.length);
			System.arraycopy(saltbytes, 0, saltypassbytes, passbytes.length, saltbytes.length);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		if (saltypassbytes != null) {
			md.update(saltypassbytes);
		}
		digest = DatatypeConverter.printHexBinary(md.digest());
		System.out.println(digest);
		return digest;		
	}

}
