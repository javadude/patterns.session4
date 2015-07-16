package com.javadude.command;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Account {
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(propertyName, listener);
	}
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(propertyName, listener);
	}
	
	private int id;
	private int balance;
	
	public Account(int id) {
		this.id = id;
	}
	
	public Account(int id, int balance) {
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}
	
	public void deposit(int amount) {
		int oldBalance = balance;
		balance += amount;
		pcs.firePropertyChange("balance", oldBalance, balance);
	}
	public void withdraw(int amount) {
		if (amount > balance) {
			throw new IllegalStateException("Insufficient Funds");
		}
		int oldBalance = balance;
		balance -= amount;
		pcs.firePropertyChange("balance", oldBalance, balance);
	}
	
	public int getBalance() {
		return balance;
	}
}
