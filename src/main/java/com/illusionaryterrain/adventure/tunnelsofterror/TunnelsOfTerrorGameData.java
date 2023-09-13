package com.illusionaryterrain.adventure.tunnelsofterror;

import com.illusionaryterrain.adventure.*;
import com.illusionaryterrain.adventure.events.*;
import com.illusionaryterrain.adventure.objects.ObjectItemType;
import com.illusionaryterrain.adventure.objects.SimpleObject;
import com.illusionaryterrain.adventure.rpg.CharacterStateFactory;
import com.illusionaryterrain.adventure.rpg.FiendFactory;
import com.illusionaryterrain.adventure.rpg.InfiniteDiceBag;

public class TunnelsOfTerrorGameData {
    public static Location Generate(Game game) {

        InfiniteDiceBag bag = new InfiniteDiceBag();
        game.diceBag = bag;
        game.player.rpg = CharacterStateFactory.createNewCharacter(bag);


        game.introduction = "Welcome to Tunnels Of Terror.\n"+
                "You were once an aspiring young sorcerer, pussiant with magical spells and deft with a your scimitar of killing. "+
                "Those days are gone, your teacher became possessed by an terrible entity and was driven mad. "+
                "They stole your tools of power, destroyed your precious spell book, tortured you and then finally flung your bodily into the dungeon known as the Tunnels Of Terror!"+
                "\n"+
                "Lost, hungry and with no protection, can you survive and escape the tunnels to wreck your revenge?\n";

        game.player.state.put("LIGHT", 0);

        Location entrance = new Location("Entrance chamber",
                "a small grim dungeon chamber, with a vaulted ceiling that holds a the trapdoor you were thrown down previous. The air is damp and musty, the light dim and the floor stained with unpleasant spills.");

        Exit d1s = new Exit("A bent and broken iron gate leads south from this room into the gloom of a larger chamber beyond", "gate", "gateway", "south");
        entrance.exits.add(d1s);

        Location holding = new Location("Holding area.",
                "what seems to have been a holding chamber. Rusted iron rings line the walls, while a barely recognisable mouldering and smashed table sits in the centre.");
        d1s.location = holding;

        Exit d2n = new Exit("A bent and broken iron gate leads north from this room into a small vaulted room", "gate", "gateway", "north");
        holding.exits.add(d2n);

        Exit d2w = new Exit("A plain old wooden door in the west wall", "plain door", "west");
        holding.exits.add(d2w);
        Exit d2e = new Exit("The heavily webbed outline of a door in the east", "webbed door", "east");
        holding.exits.add(d2e);
        SimpleObject wood = new SimpleObject(ObjectItemType.USELESS, "mouldy rotten wood from a old table", "wood");
        holding.contents.add(wood);

        Location p1 = new Location("A plain square room.", "a plain square room with badly white plastered walls. The stonework behind is visible in a number of places. This room is reasonably dry.");
        d2w.location = p1;
        Exit d3e = new Exit("A plain old wooden door in the east wall.", "plain door", "west");

        SimpleObject flint = new SimpleObject(ObjectItemType.LIGHT, "a flint & steel set", "flint");
        SimpleObject candle = new SimpleObject( ObjectItemType.LIGHT, "An unlit candle.","candle");
        candle.state.put("LIT", 0);
        ItemDescriptionChangeEvent idce = new ItemDescriptionChangeEvent(null, candle, "A lit, flicking candle.");
        OutputEvent oe = new OutputEvent(idce,"You light the candle.");
        ItemStateChangeEvent isce = new ItemStateChangeEvent(oe, candle, "LIT", 1);
        StateChangeEvent sce = new StateChangeEvent(isce, StateType.PLAYER, "LIGHT", 1);
        HasItemEvent hie = new HasItemEvent(sce, flint, "I have nothing to light it with.");
        KeywordItemEvent ke = new KeywordItemEvent(hie, "light","candle");

        p1.contents.add(flint);
        p1.contents.add(candle);
        candle.events.add(ke);

        Location spiderroom = new Location("A hall with thick spider webs throughout.","thick ropey spiderwebs cover the walls and ceiling of this long hall. The corners are so hidden by webs they are difficult to see.");
        Creature spider = FiendFactory.createGiantSpider();
        spiderroom.inhabitants.put(spider.getName(), spider);
        d2e.location = spiderroom;






        return entrance;
    }

}
