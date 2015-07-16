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
	
	public BankUI() {
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, new JPanel(new GridLayout(1, 0, 5, 5)) {{
			add(new AccountUI(account1));
			add(new AccountUI(account2));
		}});
		add(BorderLayout.SOUTH, new JPanel(new GridLayout(0, 1, 5, 5)) {{
			add(new MyButton("Deposit $10 to account 1", e -> {account1.deposit(10);}));
			add(new MyButton("Deposit $10 to account 2", e -> {account2.deposit(10);}));
			add(new MyButton("Withdraw $10 from account 1", e -> {account1.withdraw(10);}));
			add(new MyButton("Withdraw $10 from account 2", e -> {account2.withdraw(10);}));
		}});
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
	}
	
	private static class MyButton extends JButton {
		public MyButton(String text, ActionListener actionListener) {
			super(text);
			addActionListener(actionListener);
		}
	}
}
