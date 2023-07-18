package com.illusionaryterrain.adventure.events;

import com.illusionaryterrain.adventure.Location;
import com.illusionaryterrain.adventure.Player;

import java.util.List;

public interface Event {
    public EventType getEventType();
    public void setEventType(EventType type);
    public Event getNextEvent();
    public void setNextEvent(Event event);
    public void go(Player player, Location location, String... target);
    public List<String> getKeywords();
}
