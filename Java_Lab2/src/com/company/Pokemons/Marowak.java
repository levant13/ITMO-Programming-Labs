package com.company.Pokemons;

import com.company.moves.*;

public class Marowak extends Cubone{
    public Marowak (String name, int level){
        super(name, level);
        setStats(60,80,110,50,80,45 );
        addMove(new ConfuseRay());
    }
}
