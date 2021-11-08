package com.example;

import java.io.IOException;

import com.example.commands.CommandExecutorFactory;
import com.example.exceptions.InvalidModeException;
import com.example.mode.FileMode;
import com.example.mode.InteractiveMode;
import com.example.service.ParkingLotService;

/**
 * Parking lot
 */
public final class App {
    private App() {
    }

    /**
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws IOException {
        final OutputPrinter outputPrinter = new OutputPrinter();
        final ParkingLotService parkingLotService = new ParkingLotService();
        final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);

        if (isFileInputMode(args)) {
            new FileMode(commandExecutorFactory, outputPrinter, args[0]).process();
        } else if (isInteractiveMode(args)) {
            new InteractiveMode(commandExecutorFactory, outputPrinter).process();
        } else {
            throw new InvalidModeException();
        }
    }

    /**
     * Checks whether the program is running in file mode.
     * 
     * @param args
     * @return Boolean indicating whether it is file input mode.
     */
    private static boolean isFileInputMode(final String[] args) {
        return args.length == 1;
    }

    /**
     * Checks whether the program is running using interactive shell mode.
     * 
     * @param args
     * @return Boolean indicating whether it is interactive shell mode.
     */
    private static boolean isInteractiveMode(final String[] args) {
        return args.length == 0;
    }
}
