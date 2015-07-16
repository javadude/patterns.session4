package com.javadude.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawAction implements ActionListener {
	private Account account;
	private int amount;
	
	public WithdrawAction(Account account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new WithdrawCommand(account, amount).execute();
	}
}
