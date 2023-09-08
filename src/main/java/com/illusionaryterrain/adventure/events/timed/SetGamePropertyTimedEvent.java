package com.illusionaryterrain.adventure.events.timed;

import com.illusionaryterrain.adventure.Game;

public class SetGamePropertyTimedEvent implements TimedEvent{

    int tick;
    String key;
    Integer value;
    public SetGamePropertyTimedEvent(int tick, String key, Integer value ) {
        this.tick = tick;
        this.key = key;
        this.value = value;

    }

    @Override
    public int getTickToFireOn() {
        return tick;
    }

    @Override
    public void go(Game game) {
        game.state.put(key, value);

    }
}
