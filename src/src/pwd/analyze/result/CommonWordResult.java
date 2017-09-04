/**
 * 
 */
package src.pwd.analyze.result;

import java.math.BigDecimal;

/**
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class CommonWordResult extends Result {
	
	private int index;
	
	public CommonWordResult() {
	}
	
	public CommonWordResult(BigDecimal time) {
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

}
