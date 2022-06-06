package commands;

import data.*;
import exceptions.CollectionIsEmptyException;
import exceptions.IncorrectInputInScriptException;
import exceptions.GroupNotFoundException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.StudyGroupAsker;

import java.time.LocalDateTime;

public class UpdateCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private StudyGroupAsker studyGroupAsker;

    public UpdateCommand(CollectionManager collectionManager, StudyGroupAsker studyGroupAsker) {
        super("update <ID> {element}", "update collection element value by ID");
        this.collectionManager = collectionManager;
        this.studyGroupAsker = studyGroupAsker;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();

            Long id = Long.parseLong(argument);
            StudyGroup oldStudyGroup = collectionManager.getById(id);
            if (oldStudyGroup == null) throw new GroupNotFoundException();

            String name = oldStudyGroup.getName();
            Coordinates coordinates = oldStudyGroup.getCoordinates();
            LocalDateTime creationDate = oldStudyGroup.getCreationDate();
            Long studentsCount=oldStudyGroup.getstudentsCount();
            Long transferredStudents=oldStudyGroup.gettransferredStudents();
            int averageMark=oldStudyGroup.getaverageMark();
            Semester semesterEnum=oldStudyGroup.getsemesterEnum();
            Person groupAdmin= oldStudyGroup.getgroupAdmin();

            collectionManager.removeFromCollection(oldStudyGroup);

            if (studyGroupAsker.askQuestion("Want to change your name?")) name = studyGroupAsker.askName();
            if (studyGroupAsker.askQuestion("Want to change a person's coordinates?")) coordinates = studyGroupAsker.askCoordinates();
            if (studyGroupAsker.askQuestion("Want to change the number of students?")) studentsCount=studyGroupAsker.askstudentsCount();
            if (studyGroupAsker.askQuestion("want to change the number of transfers?")) transferredStudents=studyGroupAsker.asktransferredStudents();
            if (studyGroupAsker.askQuestion("Want to change average Mark?")) averageMark=studyGroupAsker.askaverageMark();
            if (studyGroupAsker.askQuestion("Want to change semester?")) semesterEnum=studyGroupAsker.asksemesterEnum();
            if (studyGroupAsker.askQuestion("Want to change group Admin?")) groupAdmin = studyGroupAsker.askPerson();


            collectionManager.addToCollection( new StudyGroup( id,
                    name,
                    coordinates,
                    creationDate,
                    studentsCount,
                    transferredStudents,
                    averageMark,
                    semesterEnum,
                    groupAdmin
                    ));
            Console.println("Successfully changed!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Usage: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("The collection is empty!");
        } catch (NumberFormatException exception) {
            Console.printerror("ID must be represented by a number!");
        } catch (GroupNotFoundException exception) {
            Console.printerror("There are no people with this ID in the collection!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}