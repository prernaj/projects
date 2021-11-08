package com.example.commands;

import java.util.HashMap;

import com.example.OutputPrinter;
import com.example.exceptions.InvalidCommandException;
import com.example.model.Command;
import com.example.service.ParkingLotService;
import java.util.Map;

/**
 * Factory to get correct CommandExecutor from a given command.
 */
public class CommandExecutorFactory {
    private Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(final ParkingLotService parkingLotService) {
        final OutputPrinter outputPrinter = new OutputPrinter();
        commands.put(CreateParkingLotCommandExecutor.COMMAND_NAME, new CreateParkingLotCommandExecutor(parkingLotService, outputPrinter));
        commands.put(ParkCommandExecutor.COMMAND_NAME, new ParkCommandExecutor(parkingLotService, outputPrinter));
        commands.put(SlotForRegistrationNumberCommandExecutor.COMMAND_NAME, new SlotForRegistrationNumberCommandExecutor(parkingLotService, outputPrinter));
        commands.put(StatusCommandExecutor.COMMAND_NAME, new StatusCommandExecutor(parkingLotService, outputPrinter));
        commands.put(LeaveCommandExecutor.COMMAND_NAME, new LeaveCommandExecutor(parkingLotService, outputPrinter));
        commands.put(ColorToRegNumberCommandExecutor.COMMAND_NAME, new ColorToRegNumberCommandExecutor(parkingLotService, outputPrinter));
        commands.put(ColorToSlotNumberCommandExecutor.COMMAND_NAME, new ColorToSlotNumberCommandExecutor(parkingLotService, outputPrinter));
        commands.put(ExitCommandExecutor.COMMAND_NAME, new ExitCommandExecutor(parkingLotService, outputPrinter));
    }

    /**
    * Gets {@link CommandExecutor} for a particular command. It basically uses name of command to
    * fetch its corresponding executor.
    *
    * @param command Command for which executor has to be fetched.
    * @return Command executor.
    */
    public CommandExecutor getCommandExecutor(final Command command) {
        final CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (commandExecutor == null) {
            throw new InvalidCommandException();
        }
        return commandExecutor;
  }
}
