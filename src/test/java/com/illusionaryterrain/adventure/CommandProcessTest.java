package com.illusionaryterrain.adventure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandProcessTest {


    @Test
    void go() {
        CommandProcess cp = new CommandProcess();
        Player p = new Player();
        Location l1 = new Location("Room 1");
        Location l2 = new Location("Room 2");
        Exit exit = new Exit("room1toroom2");
        exit.keywords.add("room1toroom2");
        exit.location = l2;
        l1.exits.add(exit);
        p.location = l1;
        assertEquals("Room 1", p.location.shortDescription);
        cp.action(p,"go","room1toroom2");
        assertEquals("Room 2", p.location.shortDescription);

    }

    @Test
    void takeThenDrop() {
        CommandProcess cp = new CommandProcess();
        Player p = new Player();
        Location l1 = new Location("Room 1");
        p.location = l1;
        SimpleObject o = new SimpleObject("book", ObjectItemType.USELESS);
        o.keywords.add("book");
        l1.contents.add(o);
        assertEquals("book", l1.contents.get(0).getDescription());
        cp.action(p,"take","book");
        assertEquals("book", p.inventory.get(0).getDescription());
        assertEquals(0,l1.contents.size());
        cp.action(p,"drop","book");
        assertEquals(0, p.inventory.size());
        assertEquals("book", l1.contents.get(0).getDescription());

    }
}