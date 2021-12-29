package com.company.Core.sources;
import com.company.Utility.EObject;
import com.company.Utility.PullInterface;
public class Basket implements PullInterface {
    public void RectangularBasket() {
        System.out.println("rectangular " + EObject.Basket+". On each edge, a "+EObject.Bench+" is created.");

    }

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
    public void pull(String name) {
        System.out.println(name + " pulled the "+ EObject.Basket + " up to the " +EObject.Bush);

    }
}