package commands;

import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;

import java.util.List;

public class FilterGreaterThanHeightCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public FilterGreaterThanHeightCommand(CollectionManager collectionManager) {
        super("filter_greater_than_height <Height>", "display elements whose height field value is greater than the specified one");
        this.collectionManager = collectionManager;
    }


    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            List filteredInfo = collectionManager.FilterGreaterThanHeight();
            if (!filteredInfo.isEmpty()) {
                Console.println(filteredInfo);
                return true;
            } else Console.println("There are no people with the selected height in the collection!");
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Usage: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("The collection is empty!");
        } catch (IllegalArgumentException exception) {
            Console.printerror("The weapon is not on the list!");
         //   Console.println("Список оружия дальнего боя - " + Color.nameList());
        }
        return false;
    }
}