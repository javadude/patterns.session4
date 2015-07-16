package com.javadude.command;

public class TransferCommand implements Command {
	private Account from;
	private Account to;
	private int amount;

	public TransferCommand(Account from, Account to, int amount) {
		this.from = from;
		this.to = to;
		this.amount = amount;
	}

	@Override
	public void execute() {
		try {
			// start transaction
			from.withdraw(amount);
			to.deposit(amount);
		} finally {
			// end transaction
		}
	}
}
