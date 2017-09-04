package src.pwd.analyze.basiccheck;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Stopwatch;

import src.pwd.analyze.hadler.Handler;
import src.pwd.analyze.result.BasicCheckResult;
import src.pwd.entity.Password;
import src.pwd.utils.StringConstants;
import src.pwd.utils.StringHelper;
import src.pwd.utils.TimeUtils;

/**
 * Performs the basic check for the password,
 * if it contains the following parameters:
 * 1- At least 8 characters long.
 * 2- At least one number.
 * 3- At least one upper case.
 * 4- At least one symbol.
 * 
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class BasicCheck extends Handler {
	
	private static final int MINIMUM_SIZE = 8;
	private static final String NUMBER_REGEX = 		".*[\\d]+.*";
	private static final String UPPER_REGEX =  		".*[A-Z]+.*";
	private static final String LOWER_REGEX =  		".*[a-z]+.*";

	@Override
	public void check(Password password) {
		StringHelper.logMsg(StringHelper.getString("Flow.msg.basiccheck"));
		Stopwatch timer = Stopwatch.createUnstarted();
		String pass = password.getPassword();
		timer.start();
		// size
		password.setContainsMinLenght(checkLength(password));
		// has numbers
		password.setContainsNumbers(containsNumbers(pass));
		// has lowerCase
		password.setContainsLowerCase(containsLowerCase(pass));
		// has upperCase
		password.setContainsUpperCase(containsUpperCase(pass));
		// contains simbols
		password.setContainsSymbols(containsSymbols(pass));
		// contains international characters
		password.setContainsInternationalCharacters(containsInternationalCharacters(pass));
		// Striped word
		password.setProcessedPassword(processWord(pass));
		// word pattern
		password.setPasswordPattern(processPassword(pass));
		
		timer.stop();
		BigDecimal timerD = TimeUtils.getMillisecondsFromTimer(timer);
		BasicCheckResult result = new BasicCheckResult(timerD);
		password.setBasicCheckResult(result);
		
		
		handler.check(password);	
	}
	
	

	/**
	 * Generate word pattern
	 * @param pass
	 * @return word pattern
	 */
	private String processPassword(String pass) {
		char[] array = pass.toCharArray();
		StringBuilder builder = new StringBuilder();
		for(char c: array){
			String letter = String.valueOf(c);
			if(StringUtils.isNumeric(letter)){
				builder.append("#");
			}else if(StringUtils.isAlpha(letter)){
				if(containsInternationalCharacters(letter)){
					builder.append("\u00DF");
				}else if(containsUpperCase(letter)){
					builder.append("M");
				}else{
					builder.append("m");
				}
			}else if(containsSymbols(letter)){
				builder.append("%");
			}else{
				builder.append("*");
			}
		}
		return builder.toString();
	}
	
	/**
	 * Strips the password trying to let password the cleanest as possible
	 * @param pass
	 * @return
	 */
	private String processWord(String pass) {
		char[] array = pass.toCharArray();
		String lowerCase = null;
		StringBuilder builder = new StringBuilder();
		for(char c: array){
			String letter = String.valueOf(c);
			if(StringUtils.isAlpha(letter)){
				letter = StringUtils.stripAccents(letter);//
				if(containsInternationalCharacters(letter)){
//					letter = Normalizer.normalize(letter, Normalizer.Form.NFD)
//						    .replaceAll("[^\\p{ASCII}]", "");
					if(StringConstants.INTERNATIONAL_CHARACTERS_TABLE.containsKey(c)){
						letter = String.valueOf(StringConstants.INTERNATIONAL_CHARACTERS_TABLE.get(c));
					}
				}
				builder.append(letter);
			}else{
				if(StringUtils.isNumeric(letter)){
					if(StringConstants.L33T_TABLE.containsKey(c)){
						letter = String.valueOf(StringConstants.L33T_TABLE.get(c));
						builder.append(letter);
					}
				}
			}
			lowerCase = StringUtils.lowerCase(builder.toString());
		}
		return lowerCase;
	}
	
	/**
	 * Checks for length
	 * @param pwd
	 * @return true if contains the minimum length
	 */
	private boolean checkLength(Password pwd){
		if(pwd.getLength() >= MINIMUM_SIZE){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Checks if the password contains any number
	 * @param pwd
	 * @return true if contains at least one number
	 */
	private boolean containsNumbers(String pwd){
		if(pwd.matches(NUMBER_REGEX)){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Checks if contains any upper case character
	 * @param pwd
	 * @return true if contains any upper case character
	 */
	private boolean containsUpperCase(String pwd){
		if(pwd.matches(UPPER_REGEX)){
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if contains any upper case character
	 * @param pwd
	 * @return true if contains any upper case character
	 */
	private boolean containsLowerCase(String pwd){
		if(pwd.matches(LOWER_REGEX)){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Checks if contains any symbol
	 * @param letter
	 * @return true if contains any symbol
	 */
	private boolean containsSymbols(String letter){
		if(StringUtils.indexOfAny(letter, StringConstants.SPECIAL_CHARACTERS) != -1){
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if contains international character
	 * @param pwd
	 * @return true if contains any international character
	 */
	private boolean containsInternationalCharacters(String pwd){
		if(StringUtils.indexOfAny(pwd, StringConstants.INTERNATIONAL_CHARACTERS) != -1){
			return true;
		}
		return false;
	}

}
