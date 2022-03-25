package commands;

import data.Person;
import exceptions.CollectionIsEmptyException;
import exceptions.IncorrectInputInScriptException;
import exceptions.MarineNotFoundException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.PersonAsker;

import java.time.LocalDateTime;

public class RemoveGreaterCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private PersonAsker personAsker;

    public RemoveGreaterCommand(CollectionManager collectionManager, PersonAsker personAsker) {
        super("remove_greater {element}", "remove from the collection all elements greater than the given value");
        this.collectionManager = collectionManager;
        this.personAsker = personAsker;
    }

    @Override
    public boolean execute(String argument) {
        try {

            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            Person personToFind = new Person(collectionManager.generateNextId(),
                    personAsker.askName(),
                    personAsker.askCoordinates(),
                    LocalDateTime.now(),
                    personAsker.askBirthday(),
                    personAsker.askNationality(),
                    personAsker.askHeight(),
                    personAsker.askHairColor(),
                    personAsker.askLocation()
            );
            Person personFromCollection = collectionManager.getByValue(personToFind);
            if (personFromCollection == null) throw new MarineNotFoundException();
            collectionManager.removeGreater(personFromCollection);
            Console.println("Removed successfully!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("usage: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("The collection is empty!");
        } catch (MarineNotFoundException exception) {
            Console.printerror("There is no one with such characteristics in the collection!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}