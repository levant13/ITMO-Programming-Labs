package commands;

import data.Person;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.PersonAsker;

import java.time.LocalDateTime;

public class AddIfMinCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private PersonAsker personAsker;

    public AddIfMinCommand(CollectionManager collectionManager, PersonAsker personAsker) {
        super("add_if_min {element}", "add a new element if its value is less than that of the smallest");
        this.collectionManager = collectionManager;
        this.personAsker = personAsker;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            Person personToAdd = new Person(collectionManager.generateNextId(),
                    personAsker.askName(),
                    personAsker.askCoordinates(),
                    LocalDateTime.now(),
                    personAsker.askBirthday(),
                    personAsker.askNationality(),
                    personAsker.askHeight(),
                    personAsker.askHairColor(),
                    personAsker.askLocation()
            );
            if (collectionManager.collectionSize() == 0 || personToAdd.compareTo(collectionManager.getFirst()) < 0) {
                collectionManager.addToCollection(personToAdd);
                Console.println("Added successfully!");
                return true;
            } else Console.printerror("The value of a person is greater than the value of the smallest of the people!");
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Usage: '" + getName() + "'");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}