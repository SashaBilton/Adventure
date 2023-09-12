package com.illusionaryterrain.adventure.tunnelsofterror;

import com.illusionaryterrain.adventure.Exit;
import com.illusionaryterrain.adventure.Game;
import com.illusionaryterrain.adventure.Location;
import com.illusionaryterrain.adventure.objects.ObjectItemType;
import com.illusionaryterrain.adventure.objects.SimpleObject;

public class TunnelsOfTerrorGameData {
    public static Location Generate(Game game) {

        game.introduction = "Welcome to Tunnels Of Terror.\n"+
                "You were once an aspiring young sorcerer, pussiant with magical spells and deft with a your scimitar of killing. "+
                "Those days are gone, your teacher became possessed by an terrible entity and was driven mad. "+
                "They stole your tools of power, destroyed your precious spell book, tortured you and then finally flung your bodily into the dungeon known as the Tunnels Of Terror!"+
                "\n"+
                "Lost, hungry and with no protection, can you survive and escape the tunnels to wreck your revenge?\n";

        Location entrance = new Location("Entrance chamber",
                "a small grim dungeon chamber, with a vaulted ceiling that holds a the trapdoor you were thrown down previous. The air is damp and musty, the light dim and the floor stained with unpleasant spills.");

        Exit d1s = new Exit("A bent and broken iron gate leads south from this room into the gloom of a larger chamber beyond", "gate", "gateway", "south");
        entrance.exits.add(d1s);

        Location holding = new Location("Holding area.",
                "what seems to have been a holding chamber. Rusted rings line the walls, while a barely recognisable mouldering and smashed table sits in the centre.");
        d1s.location = holding;

        Exit d2n = new Exit("A bent and broken iron gate leads north from this room into a small vaulted room", "gate", "gateway", "north");
        holding.exits.add(d2n);

        Exit d2w = new Exit("A plain old wooden door in the west wall", "plain door", "west");
        holding.exits.add(d2w);
        Exit d2e = new Exit("The heavily webbed outline of a door in the east", "webbed door", "east");
        holding.exits.add(d2e);
        SimpleObject wood = new SimpleObject(ObjectItemType.USELESS, "mouldy rotten wood from a old table", "rotten wood", "wood");
        holding.contents.add(wood);



        return entrance;
    }

}
