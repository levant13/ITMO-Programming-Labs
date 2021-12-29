package com.company.moves;
import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public void dispMessage() {
        System.out.println("Used");
    }
    public Swagger() {
        super(Type.NORMAL, 0, 85);
    }
    @Override
    protected void applySelfEffects (Pokemon pDef) {
        pDef.setMod(Stat.ATTACK, 2);
        Effect.confuse(pDef);
    }
    @Override
    protected String describe() {
        Swagger mes = new Swagger();
        mes.dispMessage();
        return "Use Swagger";
    }
}