package run;

import commands.*;
import utility.*;

import java.util.Scanner;



public class App {
    public static final String PS1 = "$ ";
    public static final String PS2 = "> ";




    public static void main(String[] args) {
        try (Scanner userScanner = new Scanner(System.in)) {
          //  final String envVariable = "HUNG";
            final String envVariable= args[0];
            StudyGroupAsker studyGroupAsker = new StudyGroupAsker(userScanner);
            FileManager fileManager = new FileManager(envVariable);
            CollectionManager collectionManager = new CollectionManager(fileManager);
            CommandManager commandManager = new CommandManager(
                    new HelpCommand(),
                    new InfoCommand(collectionManager),
                    new ShowCommand(collectionManager),
                    new AddCommand(collectionManager, studyGroupAsker),
                    new UpdateCommand(collectionManager, studyGroupAsker),
                    new RemoveByIdCommand(collectionManager),
                    new ClearCommand(collectionManager),
                    new SaveCommand(collectionManager),
                    new ExecuteScriptCommand(),
                    new AddIfMinCommand(collectionManager, studyGroupAsker),
                    new RemoveGreaterCommand(collectionManager, studyGroupAsker),
                    new HistoryCommand(),
                    new MaxByIDCommand(collectionManager),
                    new SumAverageMarkCommand(collectionManager),
                    new FilterLessThanSemesterEnumCommand(collectionManager),
                    new ExitCommand()
            );
            Console console = new Console(commandManager, userScanner, studyGroupAsker);

            console.interactiveMode();
        }
    }
}