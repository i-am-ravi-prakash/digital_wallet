/**
 * 
 */
package com.digitalwallet.driver;

import java.math.BigDecimal;
import java.util.Scanner;

import com.digitalwallet.services.WalletService;

/**
 * @purpose: main driver class for the wallet
 *
 */
public class Driver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		WalletService walletService;
		int optionSelected = 0;
		
		walletService = new WalletService();
		
		outer: while(true) {
			System.out.println("Please select an option:");
			System.out.println("1. Create Wallet");
			System.out.println("2. Transfer Money");
			System.out.println("3. Check Balance");
			System.out.println("4. Account Statement");
			System.out.println("5. Overview");
			System.out.println("6. Exit");
			
			optionSelected = scanner.nextInt();
			
			switch(optionSelected) {
			case 1:
				System.out.println("Option selected: Create Wallet");
				System.out.println("Please enter name");
				String customerName = scanner.next();
				System.out.println("Please enter wallet amount");
				BigDecimal walletAmount = scanner.nextBigDecimal();
				walletService.createAccount(customerName, walletAmount);
				break;
				
			case 2:
				System.out.println("Option selected: Transfer Money");
				System.out.println("Please sender your account number");
				long fromAccountNumber = scanner.nextLong();
				System.out.println("Please receiver your account number");
				long toAccountNumber = scanner.nextLong();
				System.out.println("Please enter amount to be transferred");
				BigDecimal transferAmount = scanner.nextBigDecimal();
				walletService.transferMoney(fromAccountNumber, toAccountNumber, transferAmount);
				break;
				
			case 3:
				System.out.println("Option selected: Check Balance");
				System.out.println("Please enter account number");
				long accountNumber = scanner.nextLong();
				walletService.showBalance(accountNumber);
				break;
				
			case 4:
				System.out.println("Option selected: Account Statement");
				System.out.println("Please enter account number");
				long accNumber = scanner.nextLong();
				walletService.displayAccountStatement(accNumber);
				break;
				
			case 5:
				System.out.println("Option selected: Overview");
				walletService.overview();
				break;
				
			case 6:
				System.out.println("Exiting application");
				break outer;
				
			default:
				System.out.println("Invalid option selected");
				break;
			}
		}
	}
}
