package com.company.moves;

import ru.ifmo.se.pokemon.*;

public class Slash extends PhysicalMove {
          public Slash() {
              super(Type.NORMAL,70,100);
    }
    @Override
    protected double calcCriticalHit(Pokemon att, Pokemon def) {
        if (Math.random() < (att.getStat(Stat.SPEED)/256.0)) {
            return 2.0;
        }
        else {
            return 1.0;
        }
    }
    @Override
    protected String describe() {
        return "Use Slash";
    }
}
