package commands;

import data.*;
import exceptions.CollectionIsEmptyException;
import exceptions.IncorrectInputInScriptException;
import exceptions.MarineNotFoundException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.PersonAsker;

import java.time.LocalDateTime;
import java.util.Date;

public class UpdateCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private PersonAsker personAsker;

    public UpdateCommand(CollectionManager collectionManager, PersonAsker personAsker) {
        super("update <ID> {element}", "update collection element value by ID");
        this.collectionManager = collectionManager;
        this.personAsker = personAsker;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();

            Long id = Long.parseLong(argument);
            Person oldPerson = collectionManager.getById(id);
            if (oldPerson == null) throw new MarineNotFoundException();

            String name = oldPerson.getName();
            Coordinates coordinates = oldPerson.getCoordinates();
            LocalDateTime creationDate = oldPerson.getCreationDate();
            Integer height = oldPerson.getHeight();
            Date birthday = oldPerson.getBirthday();
            Color hairColor = oldPerson.getHairColor();
            Country nationality = oldPerson.getNationality();
            Location location = oldPerson.getLocation();

            collectionManager.removeFromCollection(oldPerson);

            if (personAsker.askQuestion("Want to change your name?")) name = personAsker.askName();
            if (personAsker.askQuestion("Want to change a person's coordinates?")) coordinates = personAsker.askCoordinates();
            if (personAsker.askQuestion("Want to change a person's height?")) height = personAsker.askHeight();
            if (personAsker.askQuestion("Want to change a person's date of birth?")) birthday = personAsker.askBirthday();
            if (personAsker.askQuestion("Want to change a person's hair color?")) hairColor = personAsker.askHairColor();
            if (personAsker.askQuestion("Want to change one's country?")) nationality = personAsker.askNationality();
            if (personAsker.askQuestion("Want to change a person's position?")) location = personAsker.askLocation();

            collectionManager.addToCollection( new Person( id,
                    name,
                    coordinates,
                    creationDate,
                    birthday,
                    nationality,
                    height,
                    hairColor,
                    location));
            Console.println("Successfully changed!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Usage: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("The collection is empty!");
        } catch (NumberFormatException exception) {
            Console.printerror("ID must be represented by a number!");
        } catch (MarineNotFoundException exception) {
            Console.printerror("There are no people with this ID in the collection!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}