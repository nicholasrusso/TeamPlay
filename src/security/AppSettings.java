package security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class AppSettings {
	
	private static final Logger log = Logger.getLogger("AppSettings");
	private static Properties props;

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
			FileInputStream in = null;
			
			try {
				in = new FileInputStream("resources/TeamPlay.properties");
			} catch (FileNotFoundException e) {
				log.severe(e.getStackTrace().toString());
			}
			
			try {
				props.load(in);
				if (in != null) {
					in.close();			
				}
			} catch (IOException e) {
				log.severe(e.getStackTrace().toString());
			}
		}
		return props;
		
	}
	

}
