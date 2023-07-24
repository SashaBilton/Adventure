package com.illusionaryterrain.adventure.simplegame;

import com.illusionaryterrain.adventure.Exit;
import com.illusionaryterrain.adventure.Game;
import com.illusionaryterrain.adventure.Location;
import com.illusionaryterrain.adventure.StateType;
import com.illusionaryterrain.adventure.events.*;
import com.illusionaryterrain.adventure.objects.ObjectItemType;
import com.illusionaryterrain.adventure.objects.SimpleObject;

public class SimpleGameData {

    public static Location GenerateMap(Game game) {
        Location hall = new Location(
                "A long hall.",
                "a long hall with an arched ceiling far above you and a chequered floor beneath.");


        Location cal = new Location(
                "The cauldron room.",
                "a square dark room with a massive iron cauldron bubbling away in the centre of it.");
        cal.state.put("LIT", 0);

        Exit irondoor = new Exit(cal, "An iron shod door in the east.", "door", "east");
        hall.exits.add(irondoor);
        irondoor.location = cal;

        Exit irondoor2 = new Exit(hall, "An iron shod door in the west.", "door", "west");
        cal.exits.add(irondoor2);

        SimpleObject candle = new SimpleObject( ObjectItemType.LIGHT, "An unlit candle.","candle");
        candle.state.put("LIT", 0);
        ItemDescriptionChangeEvent idce = new ItemDescriptionChangeEvent(null, candle, "A lit, flicking candle.");
        OutputEvent oe = new OutputEvent(idce,"You light the candle.");
        ItemStateChangeEvent isce = new ItemStateChangeEvent(oe, candle, "LIT", 1);
        StateChangeEvent sce = new StateChangeEvent(isce, StateType.PLAYER, "LIGHT", 1);
        KeywordObjectEvent ke = new KeywordObjectEvent(sce, "light","candle");
        candle.events.add(ke);

        hall.contents.add(candle);

        game.player.state.put("LIGHT", 0);

        return hall;


    }
}
