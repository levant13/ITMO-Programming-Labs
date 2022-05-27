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
    private StudyGroupAsker studyGroupAsker;
    private List<String> scriptStack = new ArrayList<>();

    public Console(CommandManager commandManager, Scanner userScanner, StudyGroupAsker studyGroupAsker) {
        this.commandManager = commandManager;
        this.userScanner = userScanner;
        this.studyGroupAsker = studyGroupAsker;
    }

    /**
     * It takes user input, splits it into a command and an argument, and then passes it to the command manager
     */
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


    /**
     * It reads the script file line by line, and for each line it calls the launchCommand function, which is responsible
     * for executing the command
     *
     * @param argument the name of the script file
     * @return The method returns the status of the command execution.
     */
    public int scriptMode(String argument) {
        String[] userCommand = {"", ""};
        int commandStatus;
        scriptStack.add(argument);
        try (Scanner scriptScanner = new Scanner(new File(argument))) {
            if (!scriptScanner.hasNext()) throw new NoSuchElementException();
            Scanner tmpScanner = studyGroupAsker.getUserScanner();
            studyGroupAsker.setUserScanner(scriptScanner);
            studyGroupAsker.setFileMode();
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
            studyGroupAsker.setUserScanner(tmpScanner);
            studyGroupAsker.setUserMode();
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


    /**
     * It takes an array of strings, and if the first element of the array is a valid command, it executes it
     *
     * @param userCommand the command entered by the user
     * @return The method returns the number of the command that was executed.
     */
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
            case "max_by_id":
                if (!commandManager.MaxByIDCommand(userCommand[1])) return 1;
                break;
            case "sum_of_average_mark":
                if (!commandManager.SumAverageMarkCommand(userCommand[1])) return 1;
                break;
            case "filter_less_than_semester_enum":
                if (!commandManager.FilterLessThanSemesterEnumCommand(userCommand[1])) return 1;
                break;
            case "exit":
                if (!commandManager.exit(userCommand[1])) return 1;
                else return 2;
            default:
                if (!commandManager.noSuchCommand(userCommand[0])) return 1;
        }
        return 0;
    }

    /**
     * Prints the given object to the console.
     *
     * @param toOut The object to print.
     */
    public static void print(Object toOut) {
        System.out.print(toOut);
    }


    /**
     * Println() prints a line to the console.
     *
     * @param toOut The object to print out.
     */
    public static void println(Object toOut) {
        System.out.println(toOut);
    }


    /**
     * This function prints the word 'error' followed by a colon and a space, followed by the object passed to the
     * function.
     *
     * @param toOut The object to print out.
     */
    public static void printerror(Object toOut) {
        System.out.println("error: " + toOut);
    }

    /**
     * This function takes two objects as parameters and prints them out in a table format
     *
     * @param element1 The first element to be printed.
     * @param element2 The second element to be printed.
     */
    public static void printtable(Object element1, Object element2) {
        System.out.printf("%-37s%-1s%n", element1, element2);
    }

    /**
     * This function returns a string that describes the class.
     *
     * @return The class name.
     */
    @Override
    public String toString() {
        return "Console (class for handling command input)";
    }
}