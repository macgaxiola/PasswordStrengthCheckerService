package src.main.controller;


import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import src.pwd.analyze.dictionary.DictionaryAttack;
import src.pwd.analyze.hadler.PasswordHandler;
import src.pwd.entity.BioData;
import src.pwd.entity.Feedback;
import src.pwd.entity.Password;
import src.pwd.utils.StringHelper;

/**
 *
 * Controller in charge of the incoming request
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
@CrossOrigin(origins = "*")
@RestController
public class PasswordServiceController {

	private static final String PASSWORD_ATTRIBUTE = "password";
	
    /**
     * Based on the given information it execute the password analysis returning the created feedback
     * @param json containing the password and the bio data
     * @return feedback analysis
     */
    @RequestMapping(value ="/passwordMetter", method = RequestMethod.POST ,  produces = {"application/json"})
    public Feedback passwordBio( @RequestBody String json ){
		
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		Map<String, String> map = gson.fromJson(json, Map.class);

		Feedback feed = null;
		String pass = getPasswordFromMap(map);
		
		if(!pass.isEmpty()){
	    	PasswordHandler handler = createPasswordHandler();
	    	Password passwordObj = createPasswordObject(pass);
			map.remove(PASSWORD_ATTRIBUTE);
	    	
	    	BioData biodata = passwordObj.getBiodata();
	    	biodata.setData(map);
	    	
	    	Password processedPassword = handler.analyzePassword(passwordObj);
	    	feed = processedPassword.getFeedback();
		}else{
			feed = new Feedback();
			feed.addSuggestions(StringHelper.getString("Error.password.empty"));
		}
		
    	return feed;
    }
    
    private String getPasswordFromMap(Map<String, String> map){
    	String pass = StringUtils.EMPTY;
    	if(!map.isEmpty()){
    		pass = map.get(PASSWORD_ATTRIBUTE);
    	}
    	return pass;
    }
    
    private Password createPasswordObject(String password){
    	return new Password(password);
    }
    
    private PasswordHandler createPasswordHandler(){
    	return new PasswordHandler();
    }
    
}