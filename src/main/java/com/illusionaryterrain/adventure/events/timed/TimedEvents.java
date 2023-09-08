package com.illusionaryterrain.adventure.events.timed;

import com.illusionaryterrain.adventure.Game;

import java.util.ArrayList;

public class TimedEvents {

    public int tick = 0;

    public ArrayList<TimedEvent> list = new ArrayList<>();

    public void checkAndCallTimedEvents(Game game){
        list.stream().filter( timedEvent -> timedEvent.getTickToFireOn() == tick).forEach(timedEvent -> timedEvent.go(game));
    }




}
