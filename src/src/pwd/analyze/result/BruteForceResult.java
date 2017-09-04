/**
 * 
 */
package src.pwd.analyze.result;

import java.math.BigDecimal;

import src.pwd.utils.StringConstants;

/**
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class BruteForceResult extends Result{

	BigDecimal bruteForceAttack_pc;
	BigDecimal bruteForceAttack_cluster;
	BigDecimal bruteForceAttack_superComputer;

	public BruteForceResult() {
	}
	
	public BruteForceResult(BigDecimal time) {
		this.time = time;
	}

	/**
	 * @return the bruteForceAttack_pc
	 */
	public BigDecimal getBruteForceAttack_pc() {
		return bruteForceAttack_pc;
	}

	/**
	 * @param bruteForceAttack_pc the bruteForceAttack_pc to set
	 */
	public void setBruteForceAttack_pc(BigDecimal bruteForceAttack_pc) {
		this.bruteForceAttack_pc = bruteForceAttack_pc;
	}

	/**
	 * @return the bruteForceAttack_cluster
	 */
	public BigDecimal getBruteForceAttack_cluster() {
		return bruteForceAttack_cluster;
	}

	/**
	 * @param bruteForceAttack_cluster the bruteForceAttack_cluster to set
	 */
	public void setBruteForceAttack_cluster(BigDecimal bruteForceAttack_cluster) {
		this.bruteForceAttack_cluster = bruteForceAttack_cluster;
	}

	/**
	 * @return the bruteForceAttack_superComputer
	 */
	public BigDecimal getBruteForceAttack_superComputer() {
		return bruteForceAttack_superComputer;
	}

	/**
	 * @param bruteForceAttack_superComputer the bruteForceAttack_superComputer to set
	 */
	public void setBruteForceAttack_superComputer(BigDecimal bruteForceAttack_superComputer) {
		this.bruteForceAttack_superComputer = bruteForceAttack_superComputer;
	}
	


}
