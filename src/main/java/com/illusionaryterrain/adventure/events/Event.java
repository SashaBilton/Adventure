package com.illusionaryterrain.adventure.events;

import com.illusionaryterrain.adventure.Game;

import java.util.List;

public interface Event {
    EventType getEventType();
    void setEventType(EventType type);
    Event getNextEvent();
    void setNextEvent(Event event);
    void go(Game game, String... target);
    void goNext(Game game, String... target);
    List<String> getKeywords();
}
