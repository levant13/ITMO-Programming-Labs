package commands;

import data.StudyGroup;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.StudyGroupAsker;
import java.time.LocalDateTime;

public class AddCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private StudyGroupAsker studyGroupAsker;

    public AddCommand(CollectionManager collectionManager, StudyGroupAsker studyGroupAsker) {
        super("add {element}", "add a new element to the collection");
        this.collectionManager = collectionManager;
        this.studyGroupAsker = studyGroupAsker;
    }



    public AddCommand(String s, String s1) {
        super(s, s1);
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            collectionManager.addToCollection(new StudyGroup(
                    collectionManager.generateNextId(),
                    studyGroupAsker.askName(),
                    studyGroupAsker.askCoordinates(),
                    LocalDateTime.now(),
                    //collectionManager.generateNextCount(),
                    studyGroupAsker.askstudentsCount(),
                    studyGroupAsker.asktransferredStudents(),
                    studyGroupAsker.askaverageMark(),
                    studyGroupAsker.asksemesterEnum(),
                    studyGroupAsker.askPerson()
            ));
            Console.println("Added success!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Usage: '" + getName() + "'");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}