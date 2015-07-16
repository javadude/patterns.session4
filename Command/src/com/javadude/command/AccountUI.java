package com.javadude.command;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AccountUI extends JPanel {
	private JLabel accountNumField = new JLabel("-----");
	private JLabel balanceField = new JLabel("--------");
	private Account model;
	
	public AccountUI(Account model) {
		this();
		setModel(model);
	}
	public AccountUI() {
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, new JPanel(new BorderLayout()) {{
			add(BorderLayout.WEST, new JPanel(new GridLayout(0, 1, 5, 5)) {{
				add(new JLabel("Account #"));
				add(new JLabel("Balance $"));
			}});
			add(BorderLayout.CENTER, new JPanel(new GridLayout(0, 1, 5, 5)) {{
				add(accountNumField);
				add(balanceField);
			}});
		}});
	}
	private PropertyChangeListener listener = e -> updateFields();
	
	public void setModel(Account model) {
		if (this.model != null) {
			this.model.removePropertyChangeListener(listener);
		}
		this.model = model;
		if (this.model != null) {
			this.model.addPropertyChangeListener(listener);
		}
		updateFields();
	}
	
	private void updateFields() {
		accountNumField.setText(this.model != null ? this.model.getId() + "" : "");
		balanceField.setText(this.model != null ? this.model.getBalance() + "" : "");
	}
}
