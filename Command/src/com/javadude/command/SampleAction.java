package com.javadude.command;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class SampleAction extends AbstractAction {
	public SampleAction() {
		putValue(Action.NAME, "Foo");
		putValue(Action.SHORT_DESCRIPTION, "Foo description");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
