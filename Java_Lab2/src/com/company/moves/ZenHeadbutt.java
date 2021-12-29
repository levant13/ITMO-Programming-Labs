package com.company.moves;
import ru.ifmo.se.pokemon.*;

public class ZenHeadbutt extends PhysicalMove {
    public ZenHeadbutt(){
        super(Type.PSYCHIC,80, 90);
    }
    @Override
    protected void applyOppEffects(Pokemon def) {
        if ( Math.random()<0.2) {
        Effect.flinch(def);
        }
    }
    @Override
    protected String describe() {
        return "Use Zen Headbutt";
    }
}
