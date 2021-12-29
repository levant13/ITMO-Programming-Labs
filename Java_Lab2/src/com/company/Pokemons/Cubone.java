package com.company.Pokemons;
import ru.ifmo.se.pokemon.*;
import com.company.moves.*;
public class Cubone extends Pokemon{
    public Cubone (String name, int level ) {
            super(name,level);
            setStats(50,50,95,40,50,35);
            setType(Type.GROUND);
            setMove(new Aerial(),new Screech(),new Facade());
    }
}
