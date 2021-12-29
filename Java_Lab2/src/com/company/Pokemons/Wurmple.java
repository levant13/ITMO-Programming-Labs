package com.company.Pokemons;

import com.company.moves.*;
import ru.ifmo.se.pokemon.*;

public class Wurmple extends Pokemon {
    public Wurmple (String name, int level){
            super (name, level);
            setStats(45,45,35,20,30,20);
            setType(Type.BUG);
            setMove(new Facade(),new DoubleTeam());
    }
}
