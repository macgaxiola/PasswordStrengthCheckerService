/**
 * 
 */
package src.pwd.analyze.bruteforce;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.math.*;
import src.pwd.analyze.hadler.Handler;
import src.pwd.analyze.result.BruteForceResult;
import src.pwd.entity.Password;
import src.pwd.utils.StringConstants;
import src.pwd.utils.StringHelper;

/**
 * Creates the brute force check analyzis.
 * 
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class BruteForceCheck extends Handler {

	private static final int CHARACTERSNUM_LOWER = 26;
	private static final int CHARACTERSNUM_CAPS = 26;
	
	// i7
	private static final long ATTACK_PC = 76923077; 
	// http://www.dailymail.co.uk/sciencetech/article-2331984/Think-strong-password-Hackers-crack-16-character-passwords-hour.html
	private static final long ATTACK_COMPUTER_CLUSTER 	= 1000000000; // 25 computers
	private static final String ATTACK_SUPERCOMPUTER 	= "33860000000000000";
		
	/* (non-Javadoc)
	 * @see src.pwd.analyze.hadler.Handler#check(src.pwd.entity.Password)
	 * 
	 */
	@Override
	public void check(Password password) {
		StringHelper.logMsg(StringHelper.getString("Flow.msg.bruteforcecheck"));
		if(!password.isGuessed()){
			int cardinality = 0;
			// Check analysis of character
	
			if(password.containsLowerCase()){
				cardinality += CHARACTERSNUM_LOWER;
			}
			
			if(password.containsUpperCase()){
				cardinality += CHARACTERSNUM_CAPS;
			}
			
			if(password.containsNumbers()){
				cardinality += StringConstants.NUMBERS.length;
			}
			
			if(password.containsSymbols()){
				cardinality += StringConstants.SPECIAL_CHARACTERS.length;
			}
	
			if(password.containsInternationalCharacters()){
				cardinality += StringConstants.INTERNATIONAL_CHARACTERS.length;
			}
			
			BigDecimal combinations = characterCombinationCalculation(password.getLength(), cardinality);
			
			BigDecimal bruteForceTime_A = combinations.divide(new BigDecimal(ATTACK_PC), 2, RoundingMode.HALF_EVEN );
			BigDecimal bruteForceTime_B = combinations.divide(new BigDecimal(ATTACK_COMPUTER_CLUSTER), 2, RoundingMode.HALF_EVEN);
			
			// needed for the size of the calculation
			DecimalFormat decimalFormat = new DecimalFormat();
			decimalFormat.setParseBigDecimal(true);
			BigDecimal bruteForceTime_C = null;
			BigDecimal bft_C;
			try {
				bft_C = (BigDecimal) decimalFormat.parse(ATTACK_SUPERCOMPUTER);
				bruteForceTime_C = combinations.divide(bft_C, 4, RoundingMode.HALF_EVEN);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			BruteForceResult bruteForceResult = new BruteForceResult(bruteForceTime_A);
			bruteForceResult.setBruteForceAttack_pc(bruteForceTime_A);
			bruteForceResult.setBruteForceAttack_cluster(bruteForceTime_B);
			bruteForceResult.setBruteForceAttack_superComputer(bruteForceTime_C);
			
			bruteForceResult.setGuessed(true);
			password.setBruteForceResult(bruteForceResult);
			password.setGuessed(true);
		}
		handler.check(password);
	}
	
	private BigDecimal characterCombinationCalculation(int passwordSize , int cardinality){
		BigDecimal cardinalityBigDec = new BigDecimal(cardinality);
		return cardinalityBigDec.pow(passwordSize);
	}
	
	/* References for simple calculation:
	 * 
	 * http://lastbit.com/password-recovery-methods.asp#Brute Force Attack
	 * 
 	 * you are not afraid of formulas: the required time is equal to (C^L) / S / N, 
 	 * where C is the length of the character set, L is the length of the password, 
 	 * S is the number of password checked per second, 
 	 * and N is the number of computers used in password recovery
 	 * 
 	 * Calculation according PC: 
 	 * 
 	 * https://www.betterbuys.com/estimating-password-cracking-times/
 	 * 
 	 * Another resource:
 	 * 
 	 * https://www.password-depot.com/know-how/brute-force-attacks.htm
 	 * 
 	 */

}
