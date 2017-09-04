/**
 * 
 */
package src.pwd.analyze.result;

import java.math.BigDecimal;

/**
 * Result to handle analysis results.
 * 
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public abstract class Result {
	
	protected BigDecimal time;
	protected boolean guessed;
	
	public boolean isGuessed() {
		return guessed;
	}

	public void setGuessed(boolean guessed) {
		this.guessed = guessed;
	}

	public BigDecimal getAnalyzisTime(){
		return time;
	}
	
	public void setAnalyzisTime(final BigDecimal  time){
		this.time = time;
	}


}
