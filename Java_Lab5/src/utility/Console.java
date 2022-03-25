package utility;

import exceptions.ScriptRecursionException;
import run.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console {
    private CommandManager commandManager;
    private Scanner userScanner;
    private PersonAsker personAsker;
    private List<String> scriptStack = new ArrayList<>();

    public Console(CommandManager commandManager, Scanner userScanner, PersonAsker personAsker) {
        this.commandManager = commandManager;
        this.userScanner = userScanner;
        this.personAsker = personAsker;
    }

    public void interactiveMode() {
        String[] userCommand = {"", ""};
        int commandStatus;
        try {
            do {
                Console.print(App.PS1);
                userCommand = (userScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                commandManager.addToHistory(userCommand[0]);
                commandStatus = launchCommand(userCommand);
            } while (commandStatus != 2);
        } catch (NoSuchElementException exception) {
            Console.printerror("User input not found!");
        } catch (IllegalStateException exception) {
            Console.printerror("Unexpected error!");
        }
    }


    public int scriptMode(String argument) {
        String[] userCommand = {"", ""};
        int commandStatus;
        scriptStack.add(argument);
        try (Scanner scriptScanner = new Scanner(new File(argument))) {
            if (!scriptScanner.hasNext()) throw new NoSuchElementException();
            Scanner tmpScanner = personAsker.getUserScanner();
            personAsker.setUserScanner(scriptScanner);
            personAsker.setFileMode();
            do {
                userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                while (scriptScanner.hasNextLine() && userCommand[0].isEmpty()) {
                    userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                    userCommand[1] = userCommand[1].trim();
                }
                Console.println(App.PS1 + String.join(" ", userCommand));
                if (userCommand[0].equals("execute_script")) {
                    for (String script : scriptStack) {
                        if (userCommand[1].equals(script)) throw new ScriptRecursionException();
                    }
                }
                commandStatus = launchCommand(userCommand);
            } while (commandStatus == 0 && scriptScanner.hasNextLine());
            personAsker.setUserScanner(tmpScanner);
            personAsker.setUserMode();
            if (commandStatus == 1 && !(userCommand[0].equals("execute_script") && !userCommand[1].isEmpty()))
                Console.println("Check the script for the correctness of the entered data!");
            return commandStatus;
        } catch (FileNotFoundException exception) {
            Console.printerror("Script file not found!");
        } catch (NoSuchElementException exception) {
            Console.printerror("Script file is empty!");
        } catch (ScriptRecursionException exception) {
            Console.printerror("Scripts cannot be called recursively!");
        } catch (IllegalStateException exception) {
            Console.printerror("Unexpected error!");
            System.exit(0);
        } finally {
            scriptStack.remove(scriptStack.size()-1);
        }
        return 1;
    }


    private int launchCommand(String[] userCommand) {
        switch (userCommand[0]) {
            case "":
                break;
            case "help":
                if (!commandManager.help(userCommand[1])) return 1;
                break;
            case "info":
                if (!commandManager.info(userCommand[1])) return 1;
                break;
            case "show":
                if (!commandManager.show(userCommand[1])) return 1;
                break;
            case "add":
                if (!commandManager.add(userCommand[1])) return 1;
                break;
            case "update":
                if (!commandManager.update(userCommand[1])) return 1;
                break;
            case "remove_by_id":
                if (!commandManager.removeById(userCommand[1])) return 1;
                break;
            case "clear":
                if (!commandManager.clear(userCommand[1])) return 1;
                break;
            case "save":
                if (!commandManager.save(userCommand[1])) return 1;
                break;
            case "execute_script":
                if (!commandManager.executeScript(userCommand[1])) return 1;
                else return scriptMode(userCommand[1]);
            case "add_if_min":
                if (!commandManager.addIfMin(userCommand[1])) return 1;
                break;
            case "remove_greater":
                if (!commandManager.removeGreater(userCommand[1])) return 1;
                break;
            case "history":
                if (!commandManager.history(userCommand[1])) return 1;
                break;
            case "print_ascending":
                if (!commandManager.PrintAscendingCommand(userCommand[1])) return 1;
                break;
            case "print_unique_nationality":
                if (!commandManager.PrintUniqueNationality(userCommand[1])) return 1;
                break;
            case "filter_greater_than_height":
                if (!commandManager.FilterGreaterThanHeightCommand(userCommand[1])) return 1;
                break;
            case "exit":
                if (!commandManager.exit(userCommand[1])) return 1;
                else return 2;
            default:
                if (!commandManager.noSuchCommand(userCommand[0])) return 1;
        }
        return 0;
    }

    public static void print(Object toOut) {
        System.out.print(toOut);
    }


    public static void println(Object toOut) {
        System.out.println(toOut);
    }


    public static void printerror(Object toOut) {
        System.out.println("error: " + toOut);
    }

    public static void printtable(Object element1, Object element2) {
        System.out.printf("%-37s%-1s%n", element1, element2);
    }

    @Override
    public String toString() {
        return "Console (class for handling command input)";
    }
}