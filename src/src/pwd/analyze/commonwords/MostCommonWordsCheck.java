package src.pwd.analyze.commonwords;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.google.common.base.Stopwatch;

import src.pwd.analyze.hadler.Handler;
import src.pwd.analyze.result.CommonWordResult;
import src.pwd.entity.Password;
import src.pwd.utils.FileUtils;
import src.pwd.utils.StringConstants;
import src.pwd.utils.StringHelper;
import src.pwd.utils.TimeUtils;

/**
 * Perform the analysis of the 10k most used password
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class MostCommonWordsCheck extends Handler{
	
	private int wordCount;
	/**
	 * Check if the password is on the most common password list.
	 * @param password
	 * @return true if the password is found
	 */
	private boolean findOnMostCommonWords(Password password){
		// initialization
		wordCount = 0;
		String pass = Pattern.quote(password.getPassword().toLowerCase());	
		Pattern pattern = Pattern.compile(pass);	
		ArrayList<String> dictionary = FileUtils.getDictionaryInfo(StringConstants.MOSTCOMMONWORDS_FILE);
		for(String word: dictionary){
			wordCount++;
		    if (pattern.matcher(word).matches()) {
		          return true;
		     }
		}
		return false;
	}

	@Override
	public void check(Password password) {
		StringHelper.logMsg(StringHelper.getString("Flow.msg.commonwordscheck"));
		if(!password.isGuessed()){
			Stopwatch timer = Stopwatch.createUnstarted();
			timer.start();
			boolean foundOnCommonWords = findOnMostCommonWords(password);
			timer.stop();
			if(foundOnCommonWords){
				CommonWordResult result = new CommonWordResult(TimeUtils.getMillisecondsFromTimer(timer));
				result.setGuessed(foundOnCommonWords);
				result.setIndex(wordCount);
				password.setCommonWordResult(result);
				password.setGuessed(foundOnCommonWords);
			}
		}
		handler.check(password);
	}
}
