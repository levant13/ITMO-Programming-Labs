package utility;

import commands.Command;
import exceptions.HistoryIsEmptyException;

import java.util.ArrayList;
import java.util.List;

/**
 * Operates the commands.
 */
public class CommandManager {
    private final int COMMAND_HISTORY_SIZE = 8;

    private String[] commandHistory = new String[COMMAND_HISTORY_SIZE];
    private List<Command> commands = new ArrayList<>();
    private Command helpCommand;
    private Command infoCommand;
    private Command showCommand;
    private Command addCommand;
    private Command updateCommand;
    private Command removeByIdCommand;
    private Command clearCommand;
    private Command saveCommand;
    private Command exitCommand;
    private Command executeScriptCommand;
    private Command addIfMinCommand;
    private Command removeGreaterCommand;
    private Command historyCommand;
    private Command PrintAscendingCommand;
    private Command PrintUniqueNationality;
    private Command FilterGreaterThanHeightCommand;

    public CommandManager(Command helpCommand, Command infoCommand, Command showCommand, Command addCommand, Command updateCommand,
                          Command removeByIdCommand, Command clearCommand, Command saveCommand, Command exitCommand, Command executeScriptCommand,
                          Command addIfMinCommand, Command removeGreaterCommand, Command historyCommand, Command PrintAscendingCommand,
                          Command PrintUniqueNationality, Command FilterGreaterThanHeightCommand) {
        this.helpCommand = helpCommand;
        this.infoCommand = infoCommand;
        this.showCommand = showCommand;
        this.addCommand = addCommand;
        this.updateCommand = updateCommand;
        this.removeByIdCommand = removeByIdCommand;
        this.clearCommand = clearCommand;
        this.saveCommand = saveCommand;
        this.exitCommand = exitCommand;
        this.executeScriptCommand = executeScriptCommand;
        this.addIfMinCommand = addIfMinCommand;
        this.removeGreaterCommand = removeGreaterCommand;
        this.historyCommand = historyCommand;
        this.PrintAscendingCommand = PrintAscendingCommand;
        this.PrintUniqueNationality = PrintUniqueNationality;
        this.FilterGreaterThanHeightCommand = FilterGreaterThanHeightCommand;

        // commands.add(helpCommand);
        commands.add(infoCommand);
        commands.add(showCommand);
        commands.add(addCommand);
        commands.add(updateCommand);
        commands.add(removeByIdCommand);
        commands.add(clearCommand);
        commands.add(saveCommand);
        commands.add(exitCommand);
        commands.add(executeScriptCommand);
        commands.add(addIfMinCommand);
        commands.add(removeGreaterCommand);
        commands.add(historyCommand);
        commands.add(PrintAscendingCommand);
        commands.add(PrintUniqueNationality);
        commands.add(FilterGreaterThanHeightCommand);
    }

    public String[] getCommandHistory() {
        return commandHistory;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void addToHistory(String commandToStore) {

        for (Command command : commands) {
            if (command.getName().split(" ")[0].equals(commandToStore)) {
                for (int i = COMMAND_HISTORY_SIZE-1; i>0; i--) {
                    commandHistory[i] = commandHistory[i-1];
                }
                commandHistory[0] = commandToStore;
            }
        }
    }

    public boolean noSuchCommand(String command) {
        Console.println("Command '" + command + "' not found. Type 'help' for help.");
        return false;
    }

    public boolean help(String argument) {
        if (helpCommand.execute(argument)) {
            for (Command command : commands) {
                Console.printtable(command.getName(), command.getDescription());
            }
            return true;
        } else return false;
    }

    public boolean info(String argument) {
        return infoCommand.execute(argument);
    }

    public boolean show(String argument) {
        return showCommand.execute(argument);
    }

    public boolean add(String argument) {
        return addCommand.execute(argument);
    }

    public boolean update(String argument) {
        return updateCommand.execute(argument);
    }

    public boolean removeById(String argument) {
        return removeByIdCommand.execute(argument);
    }

    public boolean clear(String argument) {
        return clearCommand.execute(argument);
    }

    public boolean save(String argument) {
        return saveCommand.execute(argument);
    }


    public boolean exit(String argument) {
        return exitCommand.execute(argument);
    }

    public boolean executeScript(String argument) {
        return executeScriptCommand.execute(argument);
    }

    public boolean addIfMin(String argument) {
        return addIfMinCommand.execute(argument);
    }

    public boolean removeGreater(String argument) {
        return removeGreaterCommand.execute(argument);
    }

    public boolean history(String argument) {
        if (historyCommand.execute(argument)) {
            try {
                if (commandHistory.length == 0) throw new HistoryIsEmptyException();

                Console.println("Recent commands used:");
                for (int i=0; i<commandHistory.length; i++) {
                    if (commandHistory[i] != null) Console.println(" " + commandHistory[i]);
                }
                return true;
            } catch (HistoryIsEmptyException exception) {
                Console.println("No commands have been used yet!");
            }
        }
        return false;
    }

    public boolean PrintAscendingCommand(String argument) {
        return PrintAscendingCommand.execute(argument);
    }

    public boolean PrintUniqueNationality(String argument) {
        return PrintUniqueNationality.execute(argument);
    }

    public boolean FilterGreaterThanHeightCommand(String argument) {
        return FilterGreaterThanHeightCommand.execute(argument);
    }

    @Override
    public String toString() {
        return "CommandManager (helper class for working with commands)";
    }
}