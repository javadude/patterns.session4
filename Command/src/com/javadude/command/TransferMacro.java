package com.javadude.command;

public class TransferMacro {
	public void doTransfer(Account a1, Account a2, int amount) {
		try {
			// start transaction
			a1.withdraw(amount);
			a2.deposit(amount);
		} finally {
			// end transaction
		}
	}
}
