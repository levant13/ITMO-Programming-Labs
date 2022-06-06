package commands;

import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;

public class MaxByIDCommand extends AbstractCommand {
        private CollectionManager collectionManager;

        public MaxByIDCommand(CollectionManager collectionManager) {
            super("max_by_id ", "display any object from the collection whose id field value is the maximum");
            this.collectionManager = collectionManager;
        }

        @Override
        public boolean execute(String argument) {
            try {
                if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
                Console.println(collectionManager.getMaxByID());
                return true;
            } catch (WrongAmountOfElementsException exception) {
                Console.println("Usage: '" + getName() + "'");
            } catch (CollectionIsEmptyException exception) {
                Console.printerror("The collection is empty!");
            }
            return true;
        }
    }