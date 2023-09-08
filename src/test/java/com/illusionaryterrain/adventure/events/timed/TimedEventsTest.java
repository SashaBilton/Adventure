package com.illusionaryterrain.adventure.events.timed;
import com.illusionaryterrain.adventure.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TimedEventsTest {
    @Test
    void callsSetGamePropertyTest() {

        Game game = new Game();

        SetGamePropertyTimedEvent event = new SetGamePropertyTimedEvent(3, "tick", 3);
        game.timedEvents.list.add(event);

        game.timedEvents.checkAndCallTimedEvents(game);
        assertFalse(game.state.contains("tick"));

        game.timedEvents.tick = 3;
        game.timedEvents.checkAndCallTimedEvents(game);
        //game.timedEvents.oldWay(game);

        assertTrue(game.state.containsKey("tick"));

    }

    @Test
    void callsSetGamePropertyOnTwoEventsWithSameTickTest() {

        Game game = new Game();

        SetGamePropertyTimedEvent event1 = new SetGamePropertyTimedEvent(3, "tick", 3);
        SetGamePropertyTimedEvent event2 = new SetGamePropertyTimedEvent(3, "tock", 3);
        game.timedEvents.list.add(event1);
        game.timedEvents.list.add(event2);


        game.timedEvents.checkAndCallTimedEvents(game);
        assertFalse(game.state.contains("tick"));
        assertFalse(game.state.contains("tock"));

        game.timedEvents.tick = 3;
        game.timedEvents.checkAndCallTimedEvents(game);

        assertTrue(game.state.containsKey("tick"));
        assertTrue(game.state.containsKey("tock"));

    }
}
