package security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Logger;

public class AppSettings {
	
	private static final Logger log = Logger.getLogger("AppSettings");
	private static Properties props;
	private static FileInputStream in;

	private AppSettings() {
		// Singleton class, use getInstance
	}
	
	/*
	 * Singleton class so as not to keep reading java.properties
	 * file.
	 */
	public static Properties getInstance() {
		if (props == null) {
			props = new Properties();
			in = null;
			
			try {
				in = new FileInputStream("resources/TeamPlay.properties");
			} catch (FileNotFoundException e) {
				log.severe(Arrays.toString(e.getStackTrace()));
				try {
					if (in != null) {
						in.close();
					}
				} catch (IOException e1) {
					log.severe(Arrays.toString(e.getStackTrace()));
				}
			}
			
			try {
				props.load(in);
			} catch (IOException e) {
				log.severe(Arrays.toString(e.getStackTrace()));		
			}
			
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				log.severe(Arrays.toString(e.getStackTrace()));		
			}		
		}
		return props;
		
	}
	

}
