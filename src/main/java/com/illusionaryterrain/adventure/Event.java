package com.illusionaryterrain.adventure;

import java.util.List;

public interface Event {
    public EventType getEventType();
    public void setEventType(EventType type);
    public Event getNextEvent();
    public void setNextEvent(Event event);
    public void go(Player player, Location location, String... target);
    public List<String> getKeywords();
}
