package src.pwd.entity;

import src.pwd.analyze.result.BasicCheckResult;
import src.pwd.analyze.result.BioDataResult;
import src.pwd.analyze.result.BruteForceResult;
import src.pwd.analyze.result.CommonWordResult;
import src.pwd.analyze.result.DictionaryResult;
import src.pwd.analyze.result.Result;

/**
 * @author Mac - mac.gaxiola@gmail.com
 *
 * 
 * Entity class to manage Password
 *
 */
public class Password {
	
	private String password;
	private String processedPassword;
	private String passwordPattern;
	// Manage all the time using in the password Analysis
	private Long guestime;
	// Contains the feedback
	private Feedback feedback;
	// Contains the biodata if used
	private BioData biodata;

	private Result basicCheckResult;
	private Result bioDataResult;
	private Result bruteForceResult;
	private Result commonWordResult;
	private Result dictionaryResult;
	
	private boolean containsLowerCase;
	private boolean containsUpperCase;
	private boolean containsNumbers;
	private boolean containsSymbols;
	private boolean containsMinLenght;
	private boolean containsInternationalCharacters;
		
	private boolean isGuessed;
	
	public Password(String password){
		this.password = password;
		this.feedback = new Feedback();
		this.biodata = new BioData();
		this.guestime = -1l;
		
	    basicCheckResult = new BasicCheckResult();
	    bioDataResult = new BioDataResult();
		bruteForceResult = new BruteForceResult();
		commonWordResult = new CommonWordResult();
		dictionaryResult = new DictionaryResult();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getLength(){
		return password.length();
	}
	
	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	
	public BioData getBiodata() {
		return biodata;
	}

	public void setBiodata(BioData biodata) {
		this.biodata = biodata;
	}
	
	public Long getGuestime() {
		return guestime;
	}

	public void setGuestime(Long guestime) {
		this.guestime = guestime;
	}

	public boolean containsMinLenght() {
		return containsMinLenght;
	}

	public void setContainsMinLenght(boolean containsMinLenght) {
		this.containsMinLenght = containsMinLenght;
	}

	public boolean containsLowerCase() {
		return containsLowerCase;
	}

	public void setContainsLowerCase(boolean hasLowerCase) {
		this.containsLowerCase = hasLowerCase;
	}

	public boolean containsUpperCase() {
		return containsUpperCase;
	}

	public void setContainsUpperCase(boolean hasUpperCase) {
		this.containsUpperCase = hasUpperCase;
	}

	public boolean containsNumbers() {
		return containsNumbers;
	}

	public void setContainsNumbers(boolean hasNumerics) {
		this.containsNumbers = hasNumerics;
	}

	public boolean containsSymbols() {
		return containsSymbols;
	}

	public void setContainsSymbols(boolean hasSimbols) {
		this.containsSymbols = hasSimbols;
	}

	public boolean isGuessed() {
		return isGuessed;
	}

	public void setGuessed(boolean isGuessed) {
		this.isGuessed = isGuessed;
	}
		
	@Override
	 public String toString() {
		return password; 
	}

	/**
	 * @return the basicCheckResult
	 */
	public Result getBasicCheckResult() {
		return basicCheckResult;
	}

	/**
	 * @param basicCheckResult the basicCheckResult to set
	 */
	public void setBasicCheckResult(Result basicCheckResult) {
		this.basicCheckResult = basicCheckResult;
	}

	/**
	 * @return the bioDataResult
	 */
	public Result getBioDataResult() {
		return bioDataResult;
	}

	/**
	 * @param bioDataResult the bioDataResult to set
	 */
	public void setBioDataResult(Result bioDataResult) {
		this.bioDataResult = bioDataResult;
	}

	/**
	 * @return the bruteForceResult
	 */
	public Result getBruteForceResult() {
		return bruteForceResult;
	}

	/**
	 * @param bruteForceResult the bruteForceResult to set
	 */
	public void setBruteForceResult(Result bruteForceResult) {
		this.bruteForceResult = bruteForceResult;
	}

	/**
	 * @return the commonWordResult
	 */
	public Result getCommonWordResult() {
		return commonWordResult;
	}

	/**
	 * @param commonWordResult the commonWordResult to set
	 */
	public void setCommonWordResult(Result commonWordResult) {
		this.commonWordResult = commonWordResult;
	}

	/**
	 * @return the dictionaryResult
	 */
	public Result getDictionaryResult() {
		return dictionaryResult;
	}

	/**
	 * @param dictionaryResult the dictionaryResult to set
	 */
	public void setDictionaryResult(Result dictionaryResult) {
		this.dictionaryResult = dictionaryResult;
	}

	/**
	 * @return the containsInternationalCharacters
	 */
	public boolean containsInternationalCharacters() {
		return containsInternationalCharacters;
	}

	/**
	 * @param containsInternationalCharacters the containsInternationalCharacters to set
	 */
	public void setContainsInternationalCharacters(boolean containsInternationalCharacters) {
		this.containsInternationalCharacters = containsInternationalCharacters;
	}

	/**
	 * @return the processedPassword
	 */
	public String getProcessedPassword() {
		return processedPassword;
	}

	/**
	 * @param processedPassword the processedPassword to set
	 */
	public void setProcessedPassword(String processedPassword) {
		this.processedPassword = processedPassword;
	}

	/**
	 * @return the passwordPattern
	 */
	public String getPasswordPattern() {
		return passwordPattern;
	}

	/**
	 * @param passwordPattern the passwordPattern to set
	 */
	public void setPasswordPattern(String passwordPattern) {
		this.passwordPattern = passwordPattern;
	}
}
