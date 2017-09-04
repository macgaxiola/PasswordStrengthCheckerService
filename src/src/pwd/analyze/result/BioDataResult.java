/**
 * 
 */
package src.pwd.analyze.result;

import java.math.BigDecimal;

/**
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class BioDataResult extends Result {
	
	private boolean containsPartialWord;
	private boolean containsFullWord;
	
	public BioDataResult() {
	}
	
	public BioDataResult(BigDecimal time) {
		this.time = time;
	}
	
	public boolean isContainsPartialWord() {
		return containsPartialWord;
	}

	public void setContainsPartialWord(boolean containsPartialWord) {
		this.containsPartialWord = containsPartialWord;
	}

	public boolean isContainsFullWord() {
		return containsFullWord;
	}

	public void setContainsFullWord(boolean containsFullWord) {
		this.containsFullWord = containsFullWord;
	}

}
