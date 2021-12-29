package com.company.Core.sources;
import com.company.Utility.ActionInterface;
import com.company.Utility.EObject;

public class Bush implements ActionInterface {
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String AcInterface(String name) {
        System.out.println("Now " +name+ " is climbing up the "+ EObject.Bush);
        return name;
    }
}