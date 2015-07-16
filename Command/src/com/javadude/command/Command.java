package com.javadude.command;

public interface Command {
	void execute();
	void undo();
	void redo();
	String getName();
}
