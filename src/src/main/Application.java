package src.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import src.pwd.utils.FileUtils;
import src.pwd.utils.StringHelper;


/**
 * @author Mac - mac.gaxiola@gmail.com

 */
@SpringBootApplication
public class Application{

    
	/**
	 * This class starts the web service using SpringBoot
	 * @param args
	 */
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    	StringHelper.logMsg(StringHelper.getString("Main.msg.startingwebservices"));
    	StringHelper.logMsg(StringHelper.createCliBannerMsg());
    	// Loading files in Memory
    	FileUtils.loadDictionary();
    	FileUtils.loadPwdSuggestions();
    }

}
