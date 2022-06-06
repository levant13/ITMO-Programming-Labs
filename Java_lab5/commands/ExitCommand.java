package commands;

import exceptions.WrongAmountOfElementsException;
import utility.Console;

public class ExitCommand extends AbstractCommand {

    public ExitCommand() {
        super("exit", "terminate the program (without saving to a file)");
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Usage: '" + getName() + "'");
        }
        return false;
    }
}