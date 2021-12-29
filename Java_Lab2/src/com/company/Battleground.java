package com.company;
import com.company.Pokemons.*;
import ru.ifmo.se.pokemon.*;
public class Battleground {

    public static void main(String[] args) {
        Battle b = new Battle();

        Audino p1 = new Audino("Thao", 20);
        Cubone p2 = new Cubone("Loc", 25);
        Marowak p3 = new Marowak("Huy", 29);
        Wurmple p4 = new Wurmple("Thu", 3);
        Cascoon p5 = new Cascoon("Tran", 9);
        Dustox p6 = new Dustox("Minh", 15);

        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);

        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);

        b.go();
    }
}
