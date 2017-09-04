/**
 * 
 */
package src.pwd.analyze.result;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class DictionaryResult extends Result {

	private int index;
	private boolean modifiedWord;
	
	public DictionaryResult() {
	}
	
	public DictionaryResult(BigDecimal time) {
		this.time = time;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the modifiedWord
	 */
	public boolean isModifiedWord() {
		return modifiedWord;
	}

	/**
	 * @param modifiedWord the modifiedWord to set
	 */
	public void setModifiedWord(boolean modifiedWord) {
		this.modifiedWord = modifiedWord;
	}

}
