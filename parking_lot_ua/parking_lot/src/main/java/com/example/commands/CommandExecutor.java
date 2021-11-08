package com.example.commands;

import com.example.OutputPrinter;
import com.example.model.Command;
import com.example.service.ParkingLotService;

/**
 * Command executor interface
 */
public abstract class CommandExecutor {
    protected ParkingLotService parkingLotService;
    protected OutputPrinter outputPrinter;

    public CommandExecutor(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        this.parkingLotService = parkingLotService;
        this.outputPrinter = outputPrinter;
    }

    /**
     * 
     * @param command Command to be validated
     * @return Boolean indicating whether command is valid or not
     */
    public abstract boolean validate(Command command);

    /**
     * Executes the command
     * @param command Command to be executed.
     */
    public abstract void execute(Command command);
}
