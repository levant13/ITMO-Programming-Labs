package commands;

import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;

public class SumAverageMarkCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public SumAverageMarkCommand(CollectionManager collectionManager) {
        super("sum_of_average_mark", "display the sum of the values of the field averageMark for all elements of the collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            double SumArageMark = collectionManager.getSumArageMark();
            if (SumArageMark == 0) throw new CollectionIsEmptyException();
            Console.println("The sum of the average scores of the elements: " + SumArageMark );
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Usage: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Collection is empty!");
        }
        return false;
    }
}