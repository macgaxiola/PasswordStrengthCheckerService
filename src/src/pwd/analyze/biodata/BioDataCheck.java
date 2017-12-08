package src.pwd.analyze.biodata;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Stopwatch;

import src.pwd.analyze.hadler.Handler;
import src.pwd.analyze.result.BioDataResult;
import src.pwd.entity.BioData;
import src.pwd.entity.Password;
import src.pwd.utils.StringHelper;
import src.pwd.utils.TimeUtils;

/**
 * Check if the bio data contains the given password
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class BioDataCheck extends Handler {
	
	private boolean containsFullWord;
	private boolean containsPartialWord;
	
	@Override
	public void check(Password password) {
		// Initialization
		containsFullWord = containsPartialWord = false;
		StringHelper.logMsg(StringHelper.getString("Flow.msg.biocheck"));
		BioData bio = password.getBiodata();
		if(((Map<String,String>)bio.getData()).size() > 0){
			Stopwatch timer = Stopwatch.createUnstarted();
			timer.start();
			boolean containsPassword = containsPassword(password);
			timer.stop();
			if(containsPassword){
				BioDataResult result = new BioDataResult(TimeUtils.getMillisecondsFromTimer(timer));
				result.setGuessed(containsPassword);
				result.setContainsPartialWord(containsPartialWord);
				result.setContainsFullWord(containsFullWord);
				password.setBioDataResult(result);			
				password.setGuessed(containsPassword);
			}
		}
		handler.check(password);
	}
	
	/**
	 * Manage the logic to check if the Bio fields contains the password
	 * @param password
	 * @return true if the password is included on the fields
	 */
	private boolean containsPassword(Password password){
		BioData bio = password.getBiodata();
		Map<String, String> map = bio.getData();
		String pass = password.toString().toLowerCase();
	    for (Map.Entry<String, String> entry : map.entrySet()) {
	        //String key= entry.getKey();
	        String value = (entry.getValue()).toLowerCase();
	        if(!StringUtils.isEmpty(value)){        
		        containsFullWord =  containsFullWord(value, pass);
		        containsPartialWord =  containsPartialWord(value, pass);
		        
		        if(containsFullWord||containsPartialWord){
					return true;	
		        }
	        }
	    }
	    return false;
	}
	
	/**
	 * Check if the full value contains the password.
	 * @param value
	 * @param pass
	 * @return true if the password is included on the fields
	 */
	private boolean containsFullWord(String value, String pass){
		if(StringUtils.equals(value, pass)){
			return true;	
        }
		return false;
	}
	
	/**
	 * Check if the value partially contains the password.
	 * @param value
	 * @param pass
	 * @return true if the password is included on the fields
	 */
	private boolean containsPartialWord(String value, String pass){
		if(StringUtils.contains(pass, value)){
			return true;	
        }
		return false;
 	}
}
