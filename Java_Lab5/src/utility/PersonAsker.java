package utility;

import data.Color;
import data.Coordinates;
import data.Country;
import data.Location;
import exceptions.IncorrectInputInScriptException;
import exceptions.MustBeNotEmptyException;
import exceptions.NotInDeclaredLimitsException;
import run.App;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class PersonAsker {
    private final int MAX_Y = 262;
    private final double MIN_HEIGHT = -1;
    private final long MIN_XLOCATION = 1;
    private final long MAX_XLOCATION = 929;
    private final String DATE_PATTERN = "dd-MM-yyyy";

    private Scanner userScanner;
    private boolean fileMode;

    public PersonAsker(Scanner userScanner) {
        this.userScanner = userScanner;
        fileMode = false;
    }
    private final SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);

    public void setUserScanner(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    public Scanner getUserScanner() {
        return userScanner;
    }

    public void setFileMode() {
        fileMode = true;
    }

    public void setUserMode() {
        fileMode = false;
    }

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

    public double askX() throws IncorrectInputInScriptException {
        String strX;
        double x;
        while (true) {
            try {
                Console.println("Enter X coordinate:");
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

    public Float askY() throws IncorrectInputInScriptException {
        String strY;
        Float y;
        while (true) {
            try {
                Console.println("Enter Y coordinate < " + (MAX_Y + 1) + ":");
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


    public Coordinates askCoordinates() throws IncorrectInputInScriptException {
        double x;
        Float y;
        x = askX();
        y = askY();
        return new Coordinates(x, y);
    }

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

    public Long askxLocation() throws IncorrectInputInScriptException {
        String strxLocation;
        Long xlocation;
        while (true) {
            try {
                Console.println("Enter quantity in order x < " + (MAX_XLOCATION + 1) + ":");
                Console.print(App.PS2);
                Console.println("Enter quantity in order y :");
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
    public Float askyLocation() throws IncorrectInputInScriptException {
        String strY;
        Float ylocation;
        while (true) {
            try {
                Console.println("Enter Y coordinate <  + ");
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
    public Location askLocation() throws IncorrectInputInScriptException {
        long xlocation;
        Float ylocation;
        String nameLocation;
        xlocation = askxLocation();
        ylocation = askyLocation();
        nameLocation= askNameLocation();
        return new Location(nameLocation, xlocation, ylocation);
    }

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