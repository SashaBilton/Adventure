package com.illusionaryterrain.adventure;

import com.illusionaryterrain.adventure.objects.ObjectItemType;
import com.illusionaryterrain.adventure.objects.SimpleObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void take() {
        Player p = new Player();
        Location l = new Location("here");
        SimpleObject o = new SimpleObject(ObjectItemType.IMMOVABLE,"big", "big");
        l.contents.add(o);
        p.location = l;
        p.take("big");
        assertEquals(0, p.inventory.size());

        SimpleObject o2 = new SimpleObject(ObjectItemType.USELESS,"small", "small");
        l.contents.add(o2);
        p.take("small");
        assertEquals(1, p.inventory.size());




    }
}