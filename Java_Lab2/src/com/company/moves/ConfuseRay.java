package com.company.moves;
import ru.ifmo.se.pokemon.*;
public class ConfuseRay extends StatusMove{
    public ConfuseRay(){
            super(Type.GHOST,0,100);
    }
    @Override
    protected void applySelfEffects (Pokemon pDef) {
        Effect.confuse(pDef);
        if (Math.random() < 0.33) {
            pDef.setMod(Stat.HP, -40);
        }
    }
    @Override
    protected String describe() {
        return "Use Confuse Ray";
    }
}
