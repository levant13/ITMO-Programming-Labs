    package run;
    
    import commands.*;
    import utility.*;
    
    import java.util.Scanner;
    


    public class App {
        public static final String PS1 = "$ ";
        public static final String PS2 = "> ";
    
        public static void main(String[] args) {
            try (Scanner userScanner = new Scanner(System.in)) {
                final String envVariable = "HUNG";
    
                PersonAsker personAsker = new PersonAsker(userScanner);
                FileManager fileManager = new FileManager(envVariable);
                CollectionManager collectionManager = new CollectionManager(fileManager);
                CommandManager commandManager = new CommandManager(
                        new HelpCommand(),
                        new InfoCommand(collectionManager),
                        new ShowCommand(collectionManager),
                        new AddCommand(collectionManager, personAsker),
                        new UpdateCommand(collectionManager, personAsker),
                        new RemoveByIdCommand(collectionManager),
                        new ClearCommand(collectionManager),
                        new SaveCommand(collectionManager),
                        new ExitCommand(),
                        new ExecuteScriptCommand(),
                        new AddIfMinCommand(collectionManager, personAsker),
                        new RemoveGreaterCommand(collectionManager, personAsker),
                        new HistoryCommand(),
                        new PrintUniqueNationality(collectionManager),
                        new PrintAscendingCommand(collectionManager),
                        new FilterGreaterThanHeightCommand(collectionManager)
                );
                Console console = new Console(commandManager, userScanner, personAsker);
    
                console.interactiveMode();
            }
        }
    }