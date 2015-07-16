package com.javadude.command;

public class CompositeCommand implements Command {
	private Command[] commands;
	private String name;
	
	public CompositeCommand(String name, Command... commands) {
		this.name = name;
		this.commands = commands;
	}

	@Override
	public void execute() {
		try {
			// start transaction
			for (Command command : commands) {
				command.execute();
			}
		} finally {
			// end transaction
		}
	}

	@Override
	public void undo() {
		try {
			// start transaction
			for (int i = commands.length-1; i >= 0; i--) {
				Command command = commands[i];
				command.undo();
			}
		} finally {
			// end transaction
		}
	}

	@Override
	public void redo() {
		execute();
	}

	@Override
	public boolean isCollapsible(Command command) {
		return false;
	}

	@Override
	public void collapse(Command command) {
	}

	@Override
	public String getName() {
		return name;
	}
}
