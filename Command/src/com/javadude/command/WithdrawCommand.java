package com.javadude.command;

public class WithdrawCommand implements Command {
	private Account account;
	private int amount;
	
	public WithdrawCommand(Account account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void execute() {
		account.withdraw(amount);
	}
}
