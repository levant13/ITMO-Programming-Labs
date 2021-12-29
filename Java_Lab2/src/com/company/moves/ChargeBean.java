package com.company.moves;
import ru.ifmo.se.pokemon.*;

public class ChargeBean extends SpecialMove {
    public ChargeBean() {
        super(Type.ELECTRIC, 50, 90);
    }

    @Override
    protected void applySelfEffects (Pokemon pDef) {
        double spAtt =  pDef.getStat(Stat.SPECIAL_ATTACK);
        if (Math.random() < 0.7) {
            pDef.setMod(Stat.ACCURACY, (int) spAtt + 6);
        }
    }

    @Override
    protected String describe() {
        return " Use Charge Bean ";

    }
}
