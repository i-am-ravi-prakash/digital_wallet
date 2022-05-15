/**
 * 
 */
package com.digitalwallet.utility;

/**
 * @author ravi.prakash1
 *
 */
public class AccountGenerator {
	private static long accountNumber = 464700;
	
	public static long generateAccountNumber() {
		return accountNumber++;
	}
}