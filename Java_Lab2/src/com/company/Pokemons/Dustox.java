package com.company.Pokemons;

import com.company.moves.*;

public class Dustox extends Cascoon{
    public Dustox (String name, int level){
            super(name, level);
            setStats(60,50,70,50,90,65);
            addMove(new Facade());
    }
}
