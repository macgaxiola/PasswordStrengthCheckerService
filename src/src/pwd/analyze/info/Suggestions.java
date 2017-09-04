/**
 * 
 */
package src.pwd.analyze.info;

import src.pwd.analyze.hadler.Handler;
import src.pwd.analyze.result.BioDataResult;
import src.pwd.analyze.result.BruteForceResult;
import src.pwd.analyze.result.CommonWordResult;
import src.pwd.analyze.result.DictionaryResult;
import src.pwd.entity.Feedback;
import src.pwd.entity.Password;
import src.pwd.utils.FileUtils;
import src.pwd.utils.StringConstants;
import src.pwd.utils.StringHelper;

/**
 * 
 * Build the suggestions added to the password feedback
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class Suggestions extends Handler {
	
	@Override
	public void check(Password password) {	
		basicCheckSuggestions(password);
		bioCheckSuggestions(password);
		commonWordSuggetions(password);
		dictionarySuggestions(password);
		bruteForceSuggestions(password);
		strongerPasswordSuggestion(password);	
	}
	
	/**
	 * Add a suggestion of a stronger password.
	 * @param password
	 */
	private void strongerPasswordSuggestion(Password password) {
		Feedback feed =  password.getFeedback();
		StringBuilder builder = new StringBuilder();
		builder.append(StringHelper.getString("Suggestions.password.strongPassword"));
		builder.append(StringConstants.H_1);
		builder.append(FileUtils.getRandomPws());
		builder.append(StringConstants.H_2);
		builder.append(StringHelper.getString("Suggestions.password.strongPassword_end"));
		feed.addSuggestions(builder.toString());
	}

	private void bruteForceSuggestions(Password password) {
		BruteForceResult result = (BruteForceResult) password.getBruteForceResult();
		if(result.isGuessed()){
	    	Feedback feed =  password.getFeedback();
	    	StringBuilder builder = StringConstants.getFirstFormattedFeedback(password);
	    	builder.append(StringHelper.getString("BruteForce.suggestion.found_in_bruteforce"));
	    	builder = StringConstants.getSecondFormatterFeedback(result, builder);
	    	builder.append(StringHelper.getString("BruteForce.suggestion.bruteforce"));
	    	builder.append(StringConstants.P_2);
	    	feed.addSuggestions(builder.toString());
		}	
	}

	private void dictionarySuggestions(Password password) {
		DictionaryResult result = (DictionaryResult) password.getDictionaryResult();
		if(result.isGuessed()){
	    	Feedback feed =  password.getFeedback();
	    	StringBuilder builder = StringConstants.getFirstFormattedFeedback(password);
	    	builder.append(StringHelper.getString("DictionaryAttack.suggestion.found_in_dictionary"));
	    	builder = StringConstants.getSecondFormatterFeedback(result, builder);
	    	builder.append(StringHelper.getString("DictionaryAttack.suggestion.dictionary"));
	    	if(result.isModifiedWord()){
	    		builder.append(StringHelper.getString("DictionaryAttack.suggestion.modifiedWord_explanation"));
	    	}
	    	builder.append(StringConstants.NEWLINE);
	    	builder.append(StringHelper.getString("DictionaryAttack.suggestion.dictionary_list"));
	    	builder = StringConstants.getWordList(result.getIndex(), builder, StringConstants.DICCIONARYATTACK_FILE_WORDS);
	    	builder.append(StringConstants.P_2);
	    	feed.addSuggestions(builder.toString());
		}
	}

	private void commonWordSuggetions(Password password) {
		CommonWordResult result = (CommonWordResult) password.getCommonWordResult();
	    if(result.isGuessed()){
	    	Feedback feed =  password.getFeedback();
	    	StringBuilder builder = StringConstants.getFirstFormattedFeedback(password);
	    	builder.append(StringHelper.getString("MostCommonWordsCheck.suggestion.found_10k"));
	    	builder = StringConstants.getSecondFormatterFeedback(result, builder);
	    	builder.append(StringHelper.getString("MostCommonWordsCheck.suggestion.10k"));
	    	builder.append(StringHelper.getString("MostCommonWordsCheck.suggestion.10k_list"));
	    	builder = StringConstants.getWordList(result.getIndex(), builder ,StringConstants.MOSTCOMMONWORDS_FILE);
	    	builder.append(StringConstants.P_2);
	    	feed.addSuggestions(builder.toString());
		}		
	}

	private void basicCheckSuggestions(Password password){
		Feedback feed =  password.getFeedback();
		StringBuilder builder = new StringBuilder();
		// Basic Check Suggestion
		 builder.append(StringHelper.getString("Suggestions.basic.header"));
		
		 // HTML
		builder.append(StringHelper.getString("BasicCheck.suggestion.list.open"));
		if(!password.containsMinLenght()){
			 // HTML
			builder.append(StringHelper.getString("BasicCheck.suggestion.list.item.open"));
			
			builder.append(StringHelper.getString("BasicCheck.suggestion.shouldBeLonger"));
			
			 // HTML
			builder.append(StringHelper.getString("BasicCheck.suggestion.list.item.close"));
		}
		if(!password.containsNumbers()){
			 // HTML
			builder.append(StringHelper.getString("BasicCheck.suggestion.list.item.open"));
			
			builder.append(StringHelper.getString("BasicCheck.suggestion.shouldContainsNumber"));

			// HTML
			builder.append(StringHelper.getString("BasicCheck.suggestion.list.item.close"));
		}

		boolean lowerCase = password.containsLowerCase();
		boolean upperCase = password.containsUpperCase();

		if(!lowerCase ){
			 // HTML
			builder.append(StringHelper.getString("BasicCheck.suggestion.list.item.open"));
			
			builder.append(StringHelper.getString("BasicCheck.suggestion.onlyContainsUpperCase"));
			
			 // HTML
			builder.append(StringHelper.getString("BasicCheck.suggestion.list.item.close"));
		}
		
		if(!upperCase ){
			 // HTML
			builder.append(StringHelper.getString("BasicCheck.suggestion.list.item.open"));
			
			builder.append(StringHelper.getString("BasicCheck.suggestion.onlyContainsLowerCase"));
			
			 // HTML
			builder.append(StringHelper.getString("BasicCheck.suggestion.list.item.close"));
		}

		if(!password.containsSymbols()){
			 // HTML
			builder.append(StringHelper.getString("BasicCheck.suggestion.list.item.open"));
			
			builder.append(StringHelper.getString("BasicCheck.suggestion.shouldContainsSymbols"));
			
			 // HTML
			builder.append(StringHelper.getString("BasicCheck.suggestion.list.item.close"));
		}
		
		builder.append(StringHelper.getString("BasicCheck.suggestion.list.close"));
		feed.addSuggestions(builder.toString());
	}

	private void bioCheckSuggestions(Password password){
		BioDataResult result = (BioDataResult) password.getBioDataResult();
		Feedback feed =  password.getFeedback();
		StringBuilder builder = null;
	    if(result.isContainsFullWord()){
	    	builder = StringConstants.getFirstFormattedFeedback(password);
	    	builder.append(StringHelper.getString("BioDataCheck.suggestion.found_in_biodata")+ StringHelper.getString("BioDataCheck.suggestion.fullend"));
	    	builder = StringConstants.getSecondFormatterFeedback(result, builder);
	    	builder.append(StringConstants.P_2);
		}
	    if(result.isContainsPartialWord()){
	    	builder = StringConstants.getFirstFormattedFeedback(password);
	    	builder.append(StringHelper.getString("BioDataCheck.suggestion.found_in_biodata_partial")+ StringHelper.getString("BioDataCheck.suggestion.partialend"));
	    	builder = StringConstants.getSecondFormatterFeedback(result, builder);
	    	builder.append(StringHelper.getString("BioDataCheck.suggestion.biocheck"));
	    	builder.append(StringConstants.P_2);
	    }
	    
	    if(builder != null){
	    	feed.addSuggestions(builder.toString());
	    }
	}
}
