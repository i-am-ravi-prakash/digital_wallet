/**
 * 
 */
package com.digitalwallet.entity;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Wallet {
	private Map<Long, Accounts> walletAccountMap;
	
	public Wallet() {
		this.walletAccountMap = new HashMap<>();
	}
	
	public Map<Long, Accounts> getWalletAccountMap() {
		return walletAccountMap;
	}
	
	public void setWalletAccountMap(Map<Long, Accounts> _walletAccountMap) {
		this.walletAccountMap = _walletAccountMap;
	}
}
