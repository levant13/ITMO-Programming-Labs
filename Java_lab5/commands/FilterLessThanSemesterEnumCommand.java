package commands;

import data.Semester;
import data.StudyGroup;
import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;

import java.util.ArrayList;

public class FilterLessThanSemesterEnumCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public FilterLessThanSemesterEnumCommand(CollectionManager collectionManager) {
        super("filter_less_than_semester_enum <semesterEnum>", "display elements whose semesterEnum field value is less than the given one");
        this.collectionManager = collectionManager;
    }


    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            Semester semesterEnum = Semester.valueOf(argument);
            ArrayList<StudyGroup> filteredInfo = collectionManager.FilterLessThanSemesterEnum(semesterEnum);
            if (!filteredInfo.isEmpty()) {
                Console.println(filteredInfo);
                return true;
            } else Console.println("There are no people with the selected height in the collection!");
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Usage: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("The collection is empty!");
        }
        return false;
    }
}