package com.javadude.command;

public class DepositCommand implements Command {
	private Account account;
	private int amount;
	
	public DepositCommand(Account account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void execute() {
		account.deposit(amount);
	}

	@Override
	public void undo() {
		account.withdraw(amount);
	}

	@Override
	public void redo() {
		execute();
	}

	@Override
	public String getName() {
		return "Deposit " + amount + " into account " + account.getId();
	}

	@Override
	public boolean isCollapsible(Command command) {
		return command.getClass() == DepositCommand.class;
	}

	@Override
	public void collapse(Command command) {
		amount += ((DepositCommand)command).amount;
	}
}
