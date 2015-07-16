package com.javadude.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferAction implements ActionListener {
	private Account from;
	private Account to;
	private int amount;

	public TransferAction(Account from, Account to, int amount) {
		this.from = from;
		this.to = to;
		this.amount = amount;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new TransferCommand(from, to, amount).execute();
	}
}
