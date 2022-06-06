package utility;

import data.*;
import exceptions.IncorrectInputInScriptException;
import exceptions.MustBeNotEmptyException;
import exceptions.NotInDeclaredLimitsException;
import run.App;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class StudyGroupAsker {
    private final int MAX_Y = 262;
    private final double MIN_HEIGHT = -1;
    private final long MIN_XLOCATION = 1;
    private final long MAX_XLOCATION = 929;
    private long MAX_STUDENTSCOUNT=1;
    private long MIN_STUDENTSCOUNT=0;
    private final String DATE_PATTERN = "dd-MM-yyyy";

    private Scanner userScanner;
    private boolean fileMode;

    public StudyGroupAsker(Scanner userScanner) {
        this.userScanner = userScanner;
        fileMode = false;
    }
    private final SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);

    public void setUserScanner(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    Scanner getUserScanner() {
        return userScanner;
    }

    /**
     * Sets the fileMode variable to true.
     */
    public void setFileMode() {
        fileMode = true;
    }

    /**
     * This function sets the fileMode variable to false.
     */
    public void setUserMode() {
        fileMode = false;
    }

    /**
     * "Ask the user for their name, and return it."
     *
     * The function is a bit more complicated than that, but that's the gist of it
     *
     * @return The name of the user.
     */
    public String askName() throws IncorrectInputInScriptException {
        String name;
        while (true) {
            try {
                Console.println("Enter your name:");
                Console.print(App.PS2);
                name = userScanner.nextLine().trim();
                if (fileMode) Console.println(name);
                if (name.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Name not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Name cannot be empty!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return name;
    }
    public String askNameGroup() throws IncorrectInputInScriptException {
        String name;
        while (true) {
            try {
                Console.println("Enter your name group:");
                Console.print(App.PS2);
                name = userScanner.nextLine().trim();
                if (fileMode) Console.println(name);
                if (name.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Name not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Name cannot be empty!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return name;
    }

    /**
     * "Ask the user for a double value, and return it."
     *
     * The function is a bit more complicated than that, but that's the gist of it
     *
     * @return The X coordinate of the point.
     */
    public double askX() throws IncorrectInputInScriptException {
        String strX;
        double x;
        while (true) {
            try {
                Console.println("Enter X coordinate (> -801, not null):");
                Console.print(App.PS2);
                strX = userScanner.nextLine().trim();
                if (fileMode) Console.println(strX);
                x = Double.parseDouble(strX);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("X coordinate not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("The X coordinate must be represented by a number!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return x;
    }

    /**
     * It asks the user for a Y coordinate, and returns it as a Float
     *
     * @return The Y coordinate of the point.
     */
    public Float askY() throws IncorrectInputInScriptException {
        String strY;
        Float y;
        while (true) {
            try {
                Console.println("Enter Y coordinate (> -497, not null):");
                Console.print(App.PS2);
                strY = userScanner.nextLine().trim();
                if (fileMode) Console.println(strY);
                y = Float.parseFloat(strY);
                if (y > MAX_Y) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Y coordinate not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Y coordinate cannot exceed " + MAX_Y + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("The Y coordinate must be represented by a number!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return y;
    }


    /**
     * It asks the user for coordinates and returns them
     *
     * @return Coordinates
     */
    public Coordinates askCoordinates() throws IncorrectInputInScriptException {
        double x;
        Float y;
        x = askX();
        y = askY();
        return new Coordinates(x, y);
    }

    /**
     * "Ask the user for a height, and return it."
     *
     * The function is a bit long, but it's not that complicated. It's just a loop that asks the user for a height, and
     * keeps asking until the user enters a valid height
     *
     * @return The height of the board.
     */
    public Integer askHeight() throws IncorrectInputInScriptException {
        String strHeight;
        Integer height;
        while (true) {
            try {
                Console.println("Enter height:");
                Console.print(App.PS2);
                strHeight = userScanner.nextLine().trim();
                if (fileMode) Console.println(strHeight);
                height = Integer.parseInt(strHeight);
                if (height < MIN_HEIGHT) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Height is not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Height must be greater than 0!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Height must be represented by a number!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return height;
    }
    public Long askstudentsCount() throws IncorrectInputInScriptException {
        String strstudentsCount;
        Long studentsCount;
        while (true) {
            try {
                Console.println("Enter students Count (not null) : ");
                Console.print(App.PS2);
                strstudentsCount = userScanner.nextLine().trim();
                if (fileMode) Console.println(strstudentsCount);
                studentsCount = Long.parseLong(strstudentsCount);
                if (studentsCount < MIN_STUDENTSCOUNT ) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Students Count is not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Students Count must be greater than 0!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Students Count must be represented by a number!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return studentsCount;
    }
    /**
     * It asks the user to input a nationality, and returns the nationality
     *
     * @return A Country object.
     */
    public Country askNationality() throws IncorrectInputInScriptException {
        String strCategory;
        Country category;
        while (true) {
            try {
                Console.println("List of categories - " + Country.nameList());
                Console.println("Enter category:");
                Console.print(App.PS2);
                strCategory = userScanner.nextLine().trim();
                if (fileMode) Console.println(strCategory);
                category = Country.valueOf(strCategory.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Category not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Category not listed!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return category;
    }

    /**
     * "This function asks the user to enter a hair color, and returns the hair color as a Color object."
     *
     * The function is a bit long, but it's not too complicated. The first thing it does is declare a String variable
     * called strHairColor, and a Color variable called hairColor. Then it enters a while loop. The while loop will keep
     * running until the user enters a valid hair color
     *
     * @return Color
     */
    public Color askHairColor() throws IncorrectInputInScriptException {
        String strHairColor;
        Color hairColor;
        while (true) {
            try {
                Console.println("Hair color list - " + Color.nameList());
                Console.println("Enter hair color.");
                Console.print(App.PS2);
                strHairColor = userScanner.nextLine().trim();
                if (fileMode) Console.println(strHairColor);
                hairColor = Color.valueOf(strHairColor.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Color not recognized");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("There is no color in the list.");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return hairColor;
    }

    /**
     * "Ask the user for a birthday, and return it as a Date object."
     *
     * The function is a bit more complicated than that, but that's the gist of it
     *
     * @return A date object
     */
    public Date askBirthday() throws IncorrectInputInScriptException {
        String strBirthday;
        Date birthday;
        while (true) {
            try {
                Console.println("Enter birthday ("+DATE_PATTERN+ "): ");
                Console.print(App.PS2);
                strBirthday = userScanner.nextLine().trim();
                if (strBirthday==null) throw new NullPointerException();
                if (fileMode) Console.println(strBirthday);
                birthday = formatter.parse(strBirthday);
                break;
            } catch (ParseException e) {
                Console.printerror("Entered birthday does not have the right format.");
            } catch (NullPointerException e) {
                Console.printerror("Birthday can not be null");
            }
        }
        return birthday;
    }

    /**
     * It asks the user to enter a number in order x, and returns it
     *
     * @return Long
     */
    public Long askxLocation() throws IncorrectInputInScriptException {
        String strxLocation;
        Long xlocation;
        while (true) {
            try {
                Console.println("Enter quantity in order x < " + (MAX_XLOCATION + 1) + ":");
                Console.print(App.PS2);
                Console.println("Enter quantity in order x :");
                Console.print(App.PS2);
                strxLocation = userScanner.nextLine().trim();
                if (fileMode) Console.println(strxLocation);
                xlocation = Long.parseLong(strxLocation);
                if ( xlocation < MIN_XLOCATION || xlocation > MAX_XLOCATION) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Quantity in order is not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("The number in order must be positive and not exceed " + MAX_XLOCATION + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("The number in order must be represented by a number!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return xlocation;
    }

    /**
     * It asks the user to enter the number of people to transfer, and returns the entered number
     *
     * @return The number of people to transfer.
     */
    public Long asktransferredStudents() throws IncorrectInputInScriptException {
        String strTransferredStudents;
        long transferredStudents;
        while (true) {
            try {
                Console.println("Enter the number of people to transfer (not null) :");
                Console.print(App.PS2);
                strTransferredStudents = userScanner.nextLine().trim();
                if (fileMode) Console.println(strTransferredStudents);
                transferredStudents = Long.parseLong(strTransferredStudents);
                if (transferredStudents < MIN_STUDENTSCOUNT) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("The number of people in the order is not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("The number of people in order must be greater than 0!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("The number of people in order must be represented by a number!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return transferredStudents;
    }
    /**
     * It asks the user to enter an average mark, and returns it
     *
     * @return The average mark of the student.
     */
    public int askaverageMark() throws IncorrectInputInScriptException {
        String strAverageMark;
        Integer averagemark;
        while (true) {
            try {
                Console.println("Enter average mark:");
                Console.print(App.PS2);
                strAverageMark = userScanner.nextLine().trim();
                if (fileMode) Console.println(strAverageMark);
                averagemark = Integer.parseInt(strAverageMark);
                if (averagemark < MIN_HEIGHT) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Average mark is not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Average mark must be greater than 0!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Average mark must be represented by a number!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return averagemark;
    }

    /**
     * It asks the user to input a semester, and returns the semester
     *
     * @return Semester
     */
    public Semester asksemesterEnum() throws IncorrectInputInScriptException {
        String strSemtester;
        Semester semester;
        while (true) {
            try {
                Console.println("List of categories - " + Semester.nameList());
                Console.println("Enter semester:");
                Console.print(App.PS2);
                strSemtester = userScanner.nextLine().trim();
                if (fileMode) Console.println(strSemtester);
                semester = Semester.valueOf(strSemtester.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Category not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Category not listed!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return semester;
    }

    /**
     * It asks the user for a Y coordinate, and returns it as a Float
     *
     * @return The Y coordinate of the location of the sky.
     */
    public Float askyLocation() throws IncorrectInputInScriptException {
        String strY;
        Float ylocation;
        while (true) {
            try {
                Console.println("Enter Y coordinate  ");
                Console.print(App.PS2);
                strY = userScanner.nextLine().trim();
                if (fileMode) Console.println(strY);
                ylocation = Float.parseFloat(strY);
                if (ylocation > MAX_Y) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Y coordinate not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Y coordinate cannot exceed " + MAX_Y + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("The Y coordinate must be represented by a number!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return ylocation;
    }
    /**
     * This function asks the user for a name of a location and returns it.
     *
     * @return The name of the location.
     */
    public String askNameLocation() throws IncorrectInputInScriptException {
        String nameLocation;
        while (true) {
            try {
                Console.println("Enter address name:");
                Console.print(App.PS2);
                nameLocation = userScanner.nextLine().trim();
                if (fileMode) Console.println(nameLocation);
                if (nameLocation.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Name not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Name cannot be empty!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return nameLocation;
    }
    /**
     * This function asks the user for the name, x and y coordinates of a location and returns a new location object
     *
     * @return A new Location object.
     */
    public Location askLocation() throws IncorrectInputInScriptException {
        long xlocation;
        Float ylocation;
        String nameLocation;
        xlocation = askxLocation();
        ylocation = askyLocation();
        nameLocation= askNameLocation();
        return new Location(nameLocation, xlocation, ylocation);
    }

    /**
     * This function asks the user for the person's birthday, nationality, height, hair color, and location, and returns a
     * new Person object with those attributes
     *
     * @return A new Person object.
     */
    public Person askPerson() throws IncorrectInputInScriptException{
        Country country= askNationality();
        return new Person(askNameGroup(),askBirthday(), country,askHeight(),askHairColor(),askLocation());
    }

    /**
     * It asks a question and returns a boolean value
     *
     * @param question the question to be asked
     * @return A boolean value.
     */
    public boolean askQuestion(String question) throws IncorrectInputInScriptException {
        String finalQuestion = question + " (+/-):";
        String answer;
        while (true) {
            try {
                Console.println(finalQuestion);
                Console.print(App.PS2);
                answer = userScanner.nextLine().trim();
                if (fileMode) Console.println(answer);
                if (!answer.equals("+") && !answer.equals("-")) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Answer not recognized!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("The answer must be represented by '+' or '-'!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return (answer.equals("+")) ? true : false;
    }
}