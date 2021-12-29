package com.company.moves;
import ru.ifmo.se.pokemon.*;
import java.util.*;
public class Aerial extends PhysicalMove {
    public void dispMessage() {
        System.out.println("Used");
    }
    public Aerial(){
            super(Type.FLYING,60,9999);
    }

    @Override
    protected String describe() {
        Aerial mes = new Aerial();
        mes.dispMessage();
        return "Use Aerial Ace";
    }

}
