package commands;

import exceptions.WrongAmountOfElementsException;
import utility.Console;

public class HistoryCommand extends AbstractCommand {

    public HistoryCommand() {
        super("history", "display history of used commands");
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