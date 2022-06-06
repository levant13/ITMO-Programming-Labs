package commands;

import data.StudyGroup;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.StudyGroupAsker;

import java.time.LocalDateTime;

public class AddIfMinCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private StudyGroupAsker studyGroupAsker;

    public AddIfMinCommand(CollectionManager collectionManager, StudyGroupAsker studyGroupAsker) {
        super("add_if_min {element}", "add a new element if its value is less than that of the smallest");
        this.collectionManager = collectionManager;
        this.studyGroupAsker = studyGroupAsker;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            StudyGroup studyGroupToAdd = new StudyGroup(collectionManager.generateNextId(),
                    studyGroupAsker.askName(),
                    studyGroupAsker.askCoordinates(),
                    LocalDateTime.now(),
                    studyGroupAsker.askstudentsCount(),
                    studyGroupAsker.asktransferredStudents(),
                    studyGroupAsker.askaverageMark(),
                    studyGroupAsker.asksemesterEnum(),
                    studyGroupAsker.askPerson()
            );
            if (collectionManager.collectionSize() == 0 || studyGroupToAdd.compareTo (collectionManager.getFirst()) < 0) {
                collectionManager.addToCollection(studyGroupToAdd);
                Console.println("Added successfully!");
                return true;
            } else Console.printerror("The value of a person is greater than the value of the smallest of the people!");
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Usage: '" + getName() + "'");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}