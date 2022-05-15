/**
 * 
 */
package com.digitalwallet.entity;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

import com.digitalwallet.utility.AccountGenerator;

/**
 *
 */
public class Accounts {
	private Users users;
	private BigDecimal walletBalance;
	private long accountNumer;
	private Set<Transaction> transaction;
	
	public Accounts(String userName, BigDecimal walletAmount) {
		this.users = new Users(userName);
		this.walletBalance = walletAmount;
		this.accountNumer = AccountGenerator.generateAccountNumber();
		this.transaction = new TreeSet<>((a, b) -> a.getTransferDate().compareTo(b.getTransferDate()));
	}
	
	public Users getUsers() {
		return users;
	}
	
	public void setUsers(Users _users) {
		this.users = _users;
	}
	
	public BigDecimal getWalletBalance() {
		return walletBalance;
	}
	
	public void setWalletBalance(BigDecimal _walletBalance) {
		this.walletBalance = _walletBalance;
	}
	
	public long getAccountNumber() {
		return accountNumer;
	}
	
	public void setAccountNumber(long _accountNumber) {
		this.accountNumer = _accountNumber;
	}
	
	public Set<Transaction> getTransactions(){
		return transaction;
	}
	
	public void setTransactions(TreeSet<Transaction> _transaction) {
		this.transaction = _transaction;
	}
}
