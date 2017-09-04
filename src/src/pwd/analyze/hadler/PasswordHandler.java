package src.pwd.analyze.hadler;

import src.pwd.analyze.basiccheck.BasicCheck;
import src.pwd.analyze.biodata.BioDataCheck;
import src.pwd.analyze.bruteforce.BruteForceCheck;
import src.pwd.analyze.commonwords.MostCommonWordsCheck;
import src.pwd.analyze.dictionary.DictionaryAttack;
import src.pwd.analyze.info.Suggestions;
import src.pwd.entity.Password;

/**
 * Handle the Chain of responsability sequence
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class PasswordHandler {
	
	public Password analyzePassword(Password password){		
		Handler basicCheck = new BasicCheck();
		Handler bioData = new BioDataCheck();
		Handler mostcommonwords = new MostCommonWordsCheck();
		
		Handler dictionary = new DictionaryAttack();
		Handler bruteForce = new BruteForceCheck();
		
		Handler information = new Suggestions();
		
		basicCheck.nextHandler(bioData);
		bioData.nextHandler(mostcommonwords);
		mostcommonwords.nextHandler(dictionary);
		dictionary.nextHandler(bruteForce);
		bruteForce.nextHandler(information);
		
		// Start
		basicCheck.check(password);
		
		return password;
	}

}
