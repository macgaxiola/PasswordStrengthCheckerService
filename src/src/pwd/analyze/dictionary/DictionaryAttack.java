/**
 * 
 */
package src.pwd.analyze.dictionary;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Stopwatch;

import src.pwd.analyze.hadler.Handler;
import src.pwd.analyze.result.DictionaryResult;
import src.pwd.entity.Password;
import src.pwd.utils.FileUtils;
import src.pwd.utils.StringConstants;
import src.pwd.utils.StringHelper;
import src.pwd.utils.TimeUtils;


/**
 * Perform the Dictionary attack analysis.
 * 
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class DictionaryAttack extends Handler {

	private int wordCount;
	private String processedWord;
	private String wordWithoutNumber;
	private int passwordModifications;

	// Approximate time that takes to iterate over all the dictionary
	private static final int APROX_MILLISECONDS_TIME = 8021;
	private static final int LETTERS =26;
	
	/**
	 * Perform several variations to the words found on the dictionaries and compare them with the given password 
	 * total words: 3192154
	 * @param password
	 * @return true if words contained on the dictionary and their variations are equals to the given password
	 */
	private boolean findOnDictionaries(String password, String passwordProcessed){
		ArrayList<String> dictionary = FileUtils.getDictionaryInfo(StringConstants.DICCIONARYATTACK_FILE_WORDS);
		// find the entry equals to the dictionary
		String wordwithoutAccent;
		String passwordLower = password.toLowerCase();
		for(String word: dictionary){
			wordCount++;
			wordwithoutAccent = StringUtils.stripAccents(word);
			if(
					// Equals raw input in dictionary
					word.equals(passwordLower)||
					//without accents compare with plain password
					wordwithoutAccent.equals(passwordLower)||
					// without accents and compare With number at the end
					wordwithoutAccent.equals(wordWithoutNumber)||
					// processedPassword
					word.equals(passwordProcessed)||
					// With number at the end
					word.equals(wordWithoutNumber)
					){
				return true;
			}
		}
		return false;
	}

	/**
	 * Calculate the time of the attack
	 * @param password
	 * @return
	 */
	private BigDecimal calculateTime(Password password){
		int numbers = StringConstants.NUMBERS.length;
		int specialCharacters = StringConstants.SPECIAL_CHARACTERS.length;
		int internationalCharacters = StringConstants.INTERNATIONAL_CHARACTERS.length;
		
		int betweenCharacters = password.getLength()-1;
		
		int calculation = 0;
		int tempCalculation = 0;
		
		if(password.containsInternationalCharacters()){
			tempCalculation += internationalCharacters;
		}
		
		if(password.containsUpperCase()){
			tempCalculation += LETTERS;
		}
		
		if(password.containsLowerCase()){
			tempCalculation += LETTERS;
		}
		
		if(password.containsNumbers()){
			tempCalculation += numbers;
		}
		
		if(password.containsSymbols()){
			tempCalculation += specialCharacters;
		}
		
		calculation = betweenCharacters * (tempCalculation); 
		
		int time = (calculation * APROX_MILLISECONDS_TIME)/1000;
		int totalTime = time*passwordModifications;
		
		return new BigDecimal(totalTime); // seconds
	}


	/* (non-Javadoc)
	 * @see src.pwd.analyze.hadler.Handler#check(src.pwd.entity.Password)
	 */
	@Override
	public void check(Password password) {
		StringHelper.logMsg(StringHelper.getString("Flow.msg.dictionarycheck"));
		if(!password.isGuessed()){
			// initialization
			wordCount = passwordModifications = 0;
			wordWithoutNumber = null;
			Stopwatch timer = Stopwatch.createUnstarted();	
			processedWord = password.getProcessedPassword();
			String pass= password.getPassword();
			// Case if we have numbers at the end
			if(StringUtils.endsWithAny(pass, StringConstants.NUMBERS)){
				wordWithoutNumber = StringUtils.stripAccents(pass).toLowerCase();
				wordWithoutNumber = wordWithoutNumber.replaceAll("\\d*$", "");
			}
			// starting timer and process
			timer.start();
			boolean findOnDiccionary = findOnDictionaries(pass, processedWord);
			timer.stop();
			BigDecimal timerResult = null;
			if(findOnDiccionary){
				passwordModifications = StringUtils.getLevenshteinDistance(processedWord, pass);
				boolean modifiedWord = false;
				if(passwordModifications > 0){
					timerResult = calculateTime(password);
					modifiedWord = true;
				}else{
					timerResult = TimeUtils.getMillisecondsFromTimer(timer);
				}
				DictionaryResult result = new DictionaryResult(timerResult);
				result.setGuessed(true);
				result.setIndex(wordCount);
				result.setModifiedWord(modifiedWord);
				password.setDictionaryResult(result);
				password.setGuessed(true);
			}
		}
		handler.check(password);
	}
	
	
}
