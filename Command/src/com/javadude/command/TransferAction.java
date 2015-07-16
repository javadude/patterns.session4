package com.javadude.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferAction implements ActionListener {
	private Account from;
	private Account to;
	private int amount;
	private UndoManager undoManager;

	public TransferAction(UndoManager undoManager, Account from, Account to, int amount) {
		this.undoManager = undoManager;
		this.from = from;
		this.to = to;
		this.amount = amount;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		undoManager.execute(new TransferCommand(from, to, amount));
	}
}
