package com.example.mode;

import java.io.IOException;

import com.example.OutputPrinter;
import com.example.commands.CommandExecutor;
import com.example.commands.CommandExecutorFactory;
import com.example.exceptions.InvalidCommandException;
import com.example.model.Command;

public abstract class Mode {
    private CommandExecutorFactory commandExecutorFactory;
    protected OutputPrinter outputPrinter;

    public Mode(final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter) {
        this.commandExecutorFactory = commandExecutorFactory;
        this.outputPrinter = outputPrinter;
    }

    /**
     * Helper method to process a command.
     * It uses {@link CommandExecutor} to run the given command.
     * 
     * @param command Command to be processed.
     */
    protected void processCommand(final Command command) {
        final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
        if (commandExecutor.validate(command)) {
            commandExecutor.execute(command);
        } else {
            throw new InvalidCommandException();
        }
    }

    /**
     * Abstract method to process the mode. Each mode will process in it's own way.
     * @throws IOException
     */
    public abstract void process() throws IOException;
}
