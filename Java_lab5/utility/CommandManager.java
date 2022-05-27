package utility;

import commands.Command;
import commands.HelpCommand;
import exceptions.HistoryIsEmptyException;

import java.util.ArrayDeque;


/**
 * Operates the commands.
 */
public class CommandManager {
    private final int COMMAND_HISTORY_SIZE = 8;

    private String[] commandHistory = new String[COMMAND_HISTORY_SIZE];
    private ArrayDeque<Command> commands = new ArrayDeque<>();
    private Command helpCommand;
    private Command infoCommand;
    private Command showCommand;
    private Command addCommand;
    private Command updateCommand;
    private Command removeByIdCommand;
    private Command clearCommand;
    private Command saveCommand;
    private Command executeScriptCommand;
    private Command addIfMinCommand;
    private Command removeGreaterCommand;
    private Command historyCommand;
    private Command maxbyidCommand;
    private Command sumaveragemarkCommand;
    private Command filterlessthansemesterenumCommand;
    private Command exitCommand;

    public CommandManager(Command helpCommand, Command infoCommand, Command showCommand, Command addCommand, Command updateCommand,
                          Command removeByIdCommand, Command clearCommand, Command saveCommand, Command executeScriptCommand,
                          Command addIfMinCommand, Command removeGreaterCommand, Command historyCommand, Command maxbyidCommand, Command sumaveragemarkCommand,
                          Command filterlessthansemesterenumCommand, Command exitCommand) {
        this.helpCommand = helpCommand;
        this.infoCommand = infoCommand;
        this.showCommand = showCommand;
        this.addCommand = addCommand;
        this.updateCommand = updateCommand;
        this.removeByIdCommand = removeByIdCommand;
        this.clearCommand = clearCommand;
        this.saveCommand = saveCommand;
        this.executeScriptCommand = executeScriptCommand;
        this.addIfMinCommand = addIfMinCommand;
        this.removeGreaterCommand = removeGreaterCommand;
        this.historyCommand = historyCommand;
        this.maxbyidCommand = maxbyidCommand;
        this.sumaveragemarkCommand = sumaveragemarkCommand;
        this.filterlessthansemesterenumCommand = filterlessthansemesterenumCommand;
        this.exitCommand = exitCommand;

        commands.add(helpCommand);
        commands.add(infoCommand);
        commands.add(showCommand);
        commands.add(addCommand);
        commands.add(updateCommand);
        commands.add(removeByIdCommand);
        commands.add(clearCommand);
        commands.add(saveCommand);
        commands.add(executeScriptCommand);
        commands.add(addIfMinCommand);
        commands.add(removeGreaterCommand);
        commands.add(historyCommand);
        commands.add(maxbyidCommand);
        commands.add(sumaveragemarkCommand);
        commands.add(filterlessthansemesterenumCommand);
        commands.add(exitCommand);

    }

    public String[] getCommandHistory() {
        return commandHistory;
    }

    /**
     * This function returns the commands variable.
     *
     * @return The commands array deque.
     */
    public ArrayDeque<Command> getCommands() {
        return commands;
    }

    /**
     * It takes a string, and if that string is the name of a command, it adds it to the command history
     *
     * @param commandToStore The command to be stored in the history.
     */
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

    /**
     * If the user types a command that doesn't exist, print an error message and return false.
     *
     * @param command The command that was entered.
     * @return A boolean value.
     */
    public boolean noSuchCommand(String command) {
        Console.println("Command '" + command + "' not found. Type 'help' for help.");
        return false;
    }

    /**
     * If the help command is executed, print the name and description of each command
     *
     * @param argument The argument passed to the command.
     * @return A boolean value.
     */
    public boolean help(String argument) {
        if (helpCommand.execute(argument)) {
            for (Command command : commands) {
                Console.printtable(command.getName(), command.getDescription());
            }
            return true;
        } else return false;
    }

    /**
     * The info function returns the result of executing the infoCommand object's execute function with the argument
     * argument.
     *
     * @param argument The argument to the command.
     * @return A boolean value.
     */
    public boolean info(String argument) {
        return infoCommand.execute(argument);
    }

    /**
     * The show() function calls the execute() function of the showCommand object, passing it the argument string.
     *
     * @param argument The argument to the command.
     * @return The return value is a boolean.
     */
    public boolean show(String argument) {
        return showCommand.execute(argument);
    }

    /**
     * The add function calls the execute function of the addCommand object, passing it the argument.
     *
     * @param argument The argument to be passed to the command.
     * @return A boolean value.
     */
    public boolean add(String argument) {
        return addCommand.execute(argument);
    }

    /**
     * If the update command is executed, then return true.
     *
     * @param argument The argument to be passed to the command.
     * @return The return value is a boolean.
     */
    public boolean update(String argument) {
        return updateCommand.execute(argument);
    }

    /**
     * Remove an item from the database by its id.
     *
     * @param argument The id of the object to be removed.
     * @return A boolean value.
     */
    public boolean removeById(String argument) {
        return removeByIdCommand.execute(argument);
    }

    /**
     * The clear function executes the clear command with the given argument.
     *
     * @param argument The argument to the command.
     * @return The return value is a boolean.
     */
    public boolean clear(String argument) {
        return clearCommand.execute(argument);
    }

    /**
     * Save() calls saveCommand.execute() and returns the result.
     *
     * @param argument The argument to be passed to the command.
     * @return The return value of the execute method of the saveCommand object.
     */
    public boolean save(String argument) {
        return saveCommand.execute(argument);
    }

    /**
     * The exit function calls the execute function of the exitCommand object, passing it the argument.
     *
     * @param argument The argument to the command.
     * @return The return value of the execute method of the exitCommand object.
     */
    public boolean exit(String argument) {
        return exitCommand.execute(argument);
    }

    /**
     * ExecuteScriptCommand.execute(argument)
     *
     * @param argument The argument to the script command.
     * @return The return value is a boolean.
     */
    public boolean executeScript(String argument) {
        return executeScriptCommand.execute(argument);
    }

    public boolean addIfMin(String argument) {
        return addIfMinCommand.execute(argument);
    }

    /**
     * If the argument is a number, remove all elements with a value greater than the argument.
     *
     * @param argument the name of the element to be removed.
     * @return boolean
     */
    public boolean removeGreater(String argument) {
        return removeGreaterCommand.execute(argument);
    }

    /**
     * If the history command is executed, print the command history
     *
     * @param argument The argument passed to the command.
     * @return A boolean value.
     */
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

    /**
     * Execute the maxbyidCommand with the given argument and return the result.
     *
     * @param argument The argument to the command.
     * @return The return type is boolean.
     */
    public boolean MaxByIDCommand(String argument) {
        return maxbyidCommand.execute(argument);
    }

    /**
     * The function SumAverageMarkCommand() takes a string argument and returns a boolean value
     *
     * @param argument The argument to the command.
     * @return The return value is a boolean.
     */
    public boolean SumAverageMarkCommand(String argument) {
        return    sumaveragemarkCommand.execute(argument);
    }

    /**
     * This function is used to filter the list of courses by semester
     *
     * @param argument The argument to be passed to the command.
     * @return The return type is boolean.
     */
    public boolean FilterLessThanSemesterEnumCommand(String argument) {
        return filterlessthansemesterenumCommand.execute(argument);
    }

    /**
     * This function returns a string that describes the CommandManager class.
     *
     * @return The toString() method is being returned.
     */
    @Override
    public String toString() {
        return "CommandManager (helper class for working with commands)";
    }
}