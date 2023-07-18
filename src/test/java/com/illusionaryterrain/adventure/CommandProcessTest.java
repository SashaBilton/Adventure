package com.illusionaryterrain.adventure;

import com.illusionaryterrain.adventure.objects.ObjectItemType;
import com.illusionaryterrain.adventure.objects.SimpleObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandProcessTest {


    @Test
    void go() {
        Game g = new Game();
        CommandProcess cp = new CommandProcess();
        Player p = new Player();
        g.player = p;
        Location l1 = new Location("Room 1");
        Location l2 = new Location("Room 2");
        Exit exit = new Exit(l2,"room1toroom2", "room1toroom2");

        exit.location = l2;
        l1.exits.add(exit);
        p.location = l1;
        assertEquals("Room 1", p.location.shortDescription);
        cp.action(g,"go","room1toroom2");
        assertEquals("Room 2", p.location.shortDescription);

    }

    @Test
    void takeThenDrop() {
        Game g = new Game();
        CommandProcess cp = new CommandProcess();
        Player p = new Player();
        g.player = p;
        Location l1 = new Location("Room 1");
        p.location = l1;
        SimpleObject o = new SimpleObject(ObjectItemType.USELESS, "book", "book");

        l1.contents.add(o);
        assertEquals("book", l1.contents.get(0).getDescription());
        cp.action(g,"take","book");
        assertEquals("book", p.inventory.get(0).getDescription());
        assertEquals(0,l1.contents.size());
        cp.action(g,"drop","book");
        assertEquals(0, p.inventory.size());
        assertEquals("book", l1.contents.get(0).getDescription());

    }
}