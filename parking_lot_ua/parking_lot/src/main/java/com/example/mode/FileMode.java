package com.example.mode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.example.OutputPrinter;
import com.example.commands.CommandExecutorFactory;
import com.example.model.Command;

/**
 * Mode running in which input commands are given from a file.
 */
public class FileMode extends Mode {
    private String fileName;

    public FileMode(final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter, final String fileName) {
        super(commandExecutorFactory, outputPrinter);
        this.fileName = fileName;
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void process() throws IOException {
        final File file = new File(fileName);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            outputPrinter.invalidFile();
            return;
        }

        String input = reader.readLine();
        while (input != null) {
            final Command command = new Command(input);
            processCommand(command);
            input = reader.readLine();
        }
        reader.close();
  }
}
