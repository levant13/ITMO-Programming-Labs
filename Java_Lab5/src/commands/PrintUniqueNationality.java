package commands;

        import exceptions.CollectionIsEmptyException;
        import exceptions.WrongAmountOfElementsException;
        import utility.CollectionManager;
        import utility.Console;


public class PrintUniqueNationality extends AbstractCommand {
    private CollectionManager collectionManager;

    public PrintUniqueNationality(CollectionManager collectionManager) {
        super("print_unique_nationality", "display the unique values of the nationality field of all elements in the collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            Console.println(collectionManager.minNationlity());
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Usage: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("The collection is empty!");
        }
        return true;
    }
}
