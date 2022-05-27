package commands;

import data.StudyGroup;
import exceptions.GroupNotFoundException;
import exceptions.WrongAmountOfElementsException;
import exceptions.CollectionIsEmptyException;
import utility.CollectionManager;
import utility.Console;

public class RemoveByIdCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public RemoveByIdCommand(CollectionManager collectionManager) {
        super("remove_by_id <ID>", "remove item from collection by ID");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            Long id = Long.parseLong(argument);
            StudyGroup marineToRemove = collectionManager.getById(id);
            if (marineToRemove == null) throw new GroupNotFoundException();
            collectionManager.removeFromCollection(marineToRemove);
            Console.println("The person has been successfully deleted!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Usage: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("The collection is empty!");
        } catch (NumberFormatException exception) {
            Console.printerror("ID must be represented by a number!");
        } catch (GroupNotFoundException exception) {
            Console.printerror("There are no people with this ID in the collection!");
        }
        return false;
    }
}