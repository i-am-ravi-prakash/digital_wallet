/**
 * 
 */
package com.digitalwallet.services;

import java.math.BigDecimal;
import java.util.Date;
import com.digitalwallet.entity.Accounts;
import com.digitalwallet.entity.Transaction;
import com.digitalwallet.entity.Wallet;
import com.digitalwallet.utility.Constants;

/**
 * @author ravi.prakash1
 * @purpose handles all wallet services
 */
public class WalletService {
	private Wallet wallet;
	
	public WalletService() {
		wallet = new Wallet();
	}
	
	/**
	 * 
	 * @param userName
	 * @param walletAmount
	 */
	public void createAccount(String userName, BigDecimal walletAmount) {
		Accounts account = new Accounts(userName, walletAmount);
		wallet.getWalletAccountMap().put(account.getAccountNumber(), account);
		System.out.println("Wallet created. Details: \n" + "Name: " + userName + "\nAccount number: " + account.getAccountNumber() + "\nWallet balance: " + walletAmount);
	}
	
	/**
	 * 
	 * @param fromAccountNumber
	 * @param toAccountNumber
	 * @param transferAmount
	 */
	public void transferMoney(long fromAccountNumber, long toAccountNumber, BigDecimal transferAmount) {
		if(!validateDetails(fromAccountNumber, toAccountNumber, transferAmount)) {
			return;
		}
		
		Transaction transaction = new Transaction(fromAccountNumber, toAccountNumber, transferAmount, new Date());
		Accounts fromAccount = wallet.getWalletAccountMap().get(fromAccountNumber);
		Accounts toAccount = wallet.getWalletAccountMap().get(toAccountNumber);
		
		if(fromAccount.getWalletBalance().compareTo(transferAmount) < 0) {
			System.out.println("Insufficient balance");
			return;
		}
		
		fromAccount.setWalletBalance(fromAccount.getWalletBalance().subtract(transferAmount));
		toAccount.setWalletBalance(toAccount.getWalletBalance().add(transferAmount));
		fromAccount.getTransactions().add(transaction);
		toAccount.getTransactions().add(transaction);
		System.out.println("Transaction successful");
	}
	
	/**
	 * 
	 * @param accountNumber
	 */
	public void displayAccountStatement(long accountNumber) {
		Accounts account = wallet.getWalletAccountMap().get(accountNumber);
		
		if(account == null) {
			System.out.println("Invalid account number");
			return;
		}
		
		System.out.println("Showing statement for account number: " + account.getAccountNumber());
		System.out.println("Current balance: " + account.getWalletBalance());
		System.out.println("Transactions history:\n" + account.getTransactions());
	}
	
	/**
	 * 
	 * @param accountNumber
	 */
	public void showBalance(long accountNumber) {
		Accounts account = wallet.getWalletAccountMap().get(accountNumber);
		
		if(account == null) {
			System.out.println("Invalid account number");
			return;
		}
		
		System.out.println("Current balance: " + account.getWalletBalance());
	}
	
	/**
	 * return list of all account numbers with balance
	 */
	public void overview() {
		for(long accountNumber : wallet.getWalletAccountMap().keySet()) {
			System.out.println("Account number: " + accountNumber);
			System.out.println("Balance: " + wallet.getWalletAccountMap().get(accountNumber).getWalletBalance());
		}
	}
	
	/**
	 * 
	 * @param fromAccountNumber
	 * @param toAccountNumber
	 * @param amount
	 * @return
	 */
	public boolean validateDetails(long fromAccountNumber, long toAccountNumber, BigDecimal amount) {		
		if(fromAccountNumber == toAccountNumber) {
			System.out.println("From and to account numbers cannot be same");
			return false;
		}
		
		if(!wallet.getWalletAccountMap().containsKey(fromAccountNumber)) {
			System.out.println("From account number is invalid");
			return false;
		}
		
		if(!wallet.getWalletAccountMap().containsKey(toAccountNumber)) {
			System.out.println("To account number is invalid");
			return false;
		}
		
		if(amount.compareTo(Constants.MIN_TRANSFER_AMOUNT) < 0) {
			System.out.println("Minimum transfer amount is 0.0001" + Constants.MIN_TRANSFER_AMOUNT);
			return false;
		}
		
		return true;
	}
}