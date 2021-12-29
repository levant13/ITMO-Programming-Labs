package Utility;


import com.company.Utility.WrongNameException;

public abstract class AbstractHuman {
    public abstract String getName();

    public abstract void setName(String name) throws WrongNameException;

}