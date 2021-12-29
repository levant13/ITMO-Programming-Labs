package com.company.moves;
import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade (){
            super(Type.NORMAL,70,100);
    }
        @Override
        protected void applyOppDamage(Pokemon def, double damage) {
            Status h = def.getCondition();
            if (h.equals(Status.BURN) || h.equals(Status.POISON) || h.equals(Status.PARALYZE)) {
                super.applyOppDamage(def, damage * 2);
            } else
            {
                super.applyOppDamage(def, damage);
            }
        }
        @Override
            protected String describe() {
                    return " Use Facade ";
            }
}
