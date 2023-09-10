package com.illusionaryterrain.adventure.events.timed;

import com.illusionaryterrain.adventure.Game;

public class AbstractTimedEvent implements TimedEvent{

    public int ticks;
    TimedEvent timedEvent;

    @Override
    public int getTickToFireOn() {
        return ticks;
    }

    @Override
    public void go(Game game) {

    }

    @Override
    public void goNext(Game game) {
        if (timedEvent != null) {
            timedEvent.go(game);
        }
    }
}
