/**
 * 
 */
package com.digitalwallet.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
public class Transaction {
	private long fromAccountNumber;
	private long toAccountNumber;
	private BigDecimal transferAmount;
	private Date transferDate;
	
	public Transaction(long _fromAccountNumber, long _toAccountNumber, BigDecimal _transferAmount, Date _transferDate) {
		this.fromAccountNumber = _fromAccountNumber;
		this.toAccountNumber = _toAccountNumber;
		this.transferAmount = _transferAmount;
		this.transferDate = _transferDate;
	}
	
	@Override
	public String toString() {
		return "Transactions: " + "From: " + fromAccountNumber + ", To: " + toAccountNumber + ", Amount: " + transferAmount + ", Date: " + transferDate;
	}
	
	public long getFromAcountNumber() {
		return fromAccountNumber;
	}
	
	public void setFromAccountNumber(long _fromAccountNumber) {
		this.fromAccountNumber = _fromAccountNumber;
	}
	
	public long getToAccountNumber() {
		return toAccountNumber;
	}
	
	public void setToAccountNumber(long _toAccountNumber) {
		this.toAccountNumber = _toAccountNumber;
	}
	
	public BigDecimal getTransferAmount() {
		return transferAmount;
	}
	
	public void setTransferAmount(BigDecimal _transferAmount) {
		this.transferAmount = _transferAmount;
	}
	
	public Date getTransferDate() {
		return transferDate;
	}
	
	public void setTransferDate(Date _transferDate) {
		this.transferDate = _transferDate;
	}
}
