package commands;

import data.StudyGroup;
import exceptions.CollectionIsEmptyException;
import exceptions.IncorrectInputInScriptException;
import exceptions.GroupNotFoundException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.StudyGroupAsker;

import java.time.LocalDateTime;

public class RemoveGreaterCommand extends AddCommand {
    private CollectionManager collectionManager;
    private StudyGroupAsker studyGroupAsker;

    public RemoveGreaterCommand(CollectionManager collectionManager, StudyGroupAsker studyGroupAsker) {
        super("remove_greater {element}", "remove from the collection all elements greater than the given value");
        this.collectionManager = collectionManager;
        this.studyGroupAsker = studyGroupAsker;
    }

    @Override
    public boolean execute(String argument) {
        try {

            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            StudyGroup studyGroupToFind = new StudyGroup(collectionManager.generateNextId(),
                    studyGroupAsker.askName(),
                    studyGroupAsker.askCoordinates(),
                    LocalDateTime.now(),
                    studyGroupAsker.askstudentsCount(),
                    studyGroupAsker.asktransferredStudents(),
                    studyGroupAsker.askaverageMark(),
                    studyGroupAsker.asksemesterEnum(),
                    studyGroupAsker.askPerson()
            );
            StudyGroup studyGroupFromCollection = collectionManager.getByValue(studyGroupToFind);
            if (studyGroupFromCollection == null) throw new GroupNotFoundException();
            collectionManager.removeGreater(studyGroupFromCollection);
            Console.println("Removed successfully!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("usage: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("The collection is empty!");
        } catch (GroupNotFoundException exception) {
            Console.printerror("There is no one with such characteristics in the collection!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}