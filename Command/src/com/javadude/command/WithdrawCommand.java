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

	@Override
	public void undo() {
		account.deposit(amount);
	}

	@Override
	public void redo() {
		execute();
	}

	@Override
	public String getName() {
		return "Withdraw " + amount + " from account " + account.getId();
	}
	
	@Override
	public boolean isCollapsible(Command command) {
		return command.getClass() == WithdrawCommand.class;
	}

	@Override
	public void collapse(Command command) {
		amount += ((WithdrawCommand)command).amount;
	}
}
