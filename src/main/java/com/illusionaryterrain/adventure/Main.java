package com.illusionaryterrain.adventure;

import com.illusionaryterrain.adventure.events.KeywordObjectEvent;
import com.illusionaryterrain.adventure.events.SimpleObjectEvent;
import com.illusionaryterrain.adventure.objects.ObjectItemType;
import com.illusionaryterrain.adventure.objects.SimpleObject;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome to Adventure!");

        Location start = GenerateMap();
        Game game = new Game();
        game.player.location = start;

        while (game.player.isAlive) {
            if (game.player.moved) {
                game.player.location.enter();
                game.player.moved = false;

            }
            CommandProcess cp = new CommandProcess();
            cp.input(game);
        }
    }

    public static Location GenerateMap() {
        Location hall = new Location(
                "A long hall.",
                "a long hall with an arched ceiling far above you and a chequered floor beneath.");


        Location cal = new Location(
                "The cauldron room.",
                "a square dark room with a massive iron cauldron bubbling away in the centre of it.");

        Exit irondoor = new Exit(cal, "An iron shod door in the east.", "door", "east");
        hall.exits.add(irondoor);
        irondoor.location = cal;

        Exit irondoor2 = new Exit(hall, "An iron shod door in the west.", "door", "west");
        cal.exits.add(irondoor2);

        SimpleObject candle = new SimpleObject( ObjectItemType.LIGHT, "A flickering candle.","candle");

        SimpleObjectEvent se = new SimpleObjectEvent(null);
        KeywordObjectEvent ke = new KeywordObjectEvent(se, "light","candle");
        candle.events.add(ke);

        hall.contents.add(candle);


        return hall;


    }
}