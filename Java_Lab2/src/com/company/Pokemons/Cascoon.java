package com.company.Pokemons;
import com.company.moves.*;

public class Cascoon extends Wurmple{
    public Cascoon (String name, int level){
            super (name,level);
            setStats(50,35,55,25,25,15);
            addMove(new Slash());
    }
}
