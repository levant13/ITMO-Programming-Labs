package com.company.Pokemons;
import com.company.moves.*;
import ru.ifmo.se.pokemon.*;
public class Audino extends Pokemon {
        public Audino(String name, int level ){
            super(name, level);
            setStats(103,60,86,60,86,50);
            setType(Type.NORMAL);
            setMove(new ZenHeadbutt(),new ChargeBean(),new Swagger(),new Facade() );
        }
}
