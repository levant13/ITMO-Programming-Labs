package com.company.run;
import com.company.Core.actor.Znayka;
import com.company.Core.actor.character;
import com.company.Core.sources.Basket;
import com.company.Core.sources.Bench;
import com.company.Utility.ActionInterface;
import com.company.Utility.WrongInstanceException;
import com.company.Utility.WrongNameException;

public class Story {


    public static void main(String[] args) throws WrongInstanceException {
        character They = new character();
        try {
            They.setName("Shpuntik and Toropyzhka");
        } catch (WrongNameException e) {
            e.printStackTrace();
        }
        character.Climb cl=new character.Climb();
            cl.climbthebush(They.getName());
            cl.pullball(They.getName());
            cl.pullBasket(They.getName());
        // Java Lambda Expressions
        ActionInterface pul =(s)-> s+ " pulled both up";
        printFormatted("They", pul);

        Znayka z = new Znayka();
        try {
            z.setName("Znayka");
        } catch (WrongNameException e) {
            e.printStackTrace();
        }

            They.getAttention(z);


        z.Order(They);
            System.out.println(z.toString());
            Basket basket = new Basket();
            basket.RectangularBasket();

            Bench b = new Bench();//kjhkhkjj
            b.Bench();

    }
    // Java Lambda Expressions
    public static void printFormatted (String name, ActionInterface format){
        String result = format.AcInterface(name);
        System.out.println(result);

    }
}