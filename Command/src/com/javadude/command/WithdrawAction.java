package com.javadude.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawAction implements ActionListener {
	private Account account;
	private int amount;
	private UndoManager undoManager;
	
	public WithdrawAction(UndoManager undoManager, Account account, int amount) {
		this.undoManager = undoManager;
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		undoManager.execute(new WithdrawCommand(account, amount));
	}
}
