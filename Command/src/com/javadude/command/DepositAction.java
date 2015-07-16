package com.javadude.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositAction implements ActionListener {
	private Account account;
	private int amount;
	
	public DepositAction(Account account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new DepositCommand(account, amount).execute();
	}
}
