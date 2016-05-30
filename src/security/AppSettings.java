package security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppSettings {
    
    private static Properties props;

    public AppSettings() {
    }
    
    /*
     * Singleton class so as not to keep reading java.properties
     * files.
     */
    public static Properties getInstance() {
        if (props == null) {
            props = new Properties();
            FileInputStream in = null;
            
            try {
                in = new FileInputStream("resources/TeamPlay.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            
            try {
                props.load(in);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return props;
        
    }
    

}
