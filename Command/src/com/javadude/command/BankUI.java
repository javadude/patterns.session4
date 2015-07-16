package com.javadude.command;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class BankUI extends JFrame {
	private Account account1 = new Account(1);
	private Account account2 = new Account(2);
	private UndoManager undoManager = new UndoManager();
	private MyButton undoButton = new MyButton("Undo", e -> {undoManager.undo();});
	private MyButton redoButton = new MyButton("Redo", e -> {undoManager.redo();});
	
	public BankUI() {
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, new JPanel(new GridLayout(1, 0, 5, 5)) {{
			add(new AccountUI(account1));
			add(new AccountUI(account2));
		}});
		add(BorderLayout.SOUTH, new JPanel(new GridLayout(0, 1, 5, 5)) {{
			add(new MyButton("Deposit $10 to account 1", new DepositAction(undoManager, account1, 10)));
			add(new MyButton("Deposit $10 to account 2", new DepositAction(undoManager, account2, 10)));
			add(new MyButton("Withdraw $10 from account 1", new WithdrawAction(undoManager, account1, 10)));
			add(new MyButton("Withdraw $10 from account 2", new WithdrawAction(undoManager, account2, 10)));
			add(new MyButton("Transfer $10 from account 1 to account 2", new TransferAction(undoManager, account1, account2, 10)));
			add(new MyButton("Transfer $10 from account 2 to account 1", new TransferAction(undoManager, account2, account1, 10)));
			add(undoButton);
			add(redoButton);
		}});
		undoManager.addPropertyChangeListener(e -> updateButtons());
		updateButtons();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
	}

	private void updateButtons() {
		undoButton.setVisible(undoManager.isUndoAvailable());
		undoButton.setText("Undo " + undoManager.getUndoName());
		redoButton.setVisible(undoManager.isRedoAvailable());
		redoButton.setText("Redo " + undoManager.getRedoName());
	}
	
	private static class MyButton extends JButton {
		public MyButton(String text, ActionListener actionListener) {
			super(text);
			addActionListener(actionListener);
		}
	}
}
