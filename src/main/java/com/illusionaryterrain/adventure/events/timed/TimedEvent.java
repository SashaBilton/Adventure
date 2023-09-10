package com.illusionaryterrain.adventure.events.timed;

import com.illusionaryterrain.adventure.Game;

public interface TimedEvent {

    int getTickToFireOn();

    void go(Game game);

    void goNext(Game game);


}

