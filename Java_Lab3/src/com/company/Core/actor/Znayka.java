package com.company.Core.actor;
import Utility.AbstractHuman;
import com.company.Utility.EObject;
import com.company.Utility.*;



public class Znayka extends AbstractHuman {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) throws WrongNameException {
        if (name == "Znayka") {
            this.name = name;
            joinStory();
        } else {
            throw new WrongNameException("Wrong name of Znayka");
        }
    }

    public Znayka() {
        super();
    }

    private void joinStory() {
        System.out.println(name + " join in story");
    }

    public void Order(character Shpuntik){
        System.out.println(name + " ordered " + Shpuntik.getName()+ "tie the birch bark to the bottom corner of the "+ EObject.Net);
    }
    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                '}';
    }


}
