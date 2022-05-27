package commands;

import exceptions.WrongAmountOfElementsException;
import utility.Console;


public class HelpCommand extends AbstractCommand {

    public HelpCommand() {
        super("help", "display help on available commands");
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