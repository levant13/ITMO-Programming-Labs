package commands;

import data.Person;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.PersonAsker;
import java.time.LocalDateTime;

public class AddCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private PersonAsker personAsker;

    public AddCommand(CollectionManager collectionManager, PersonAsker personAsker) {
        super("add {element}", "add a new element to the collection");
        this.collectionManager = collectionManager;
        this.personAsker = personAsker;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            collectionManager.addToCollection(new Person(
                    collectionManager.generateNextId(),
                    personAsker.askName(),
                    personAsker.askCoordinates(),
                    LocalDateTime.now(),
                    personAsker.askBirthday(),
                    personAsker.askNationality(),
                    personAsker.askHeight(),
                    personAsker.askHairColor(),
                    personAsker.askLocation()
            ));
            Console.println("Added success!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Usage: '" + getName() + "'");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}