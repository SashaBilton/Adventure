package com.illusionaryterrain.adventure;

import java.util.ArrayList;
import java.util.List;

public class SimpleObjectEvent implements Event {
    public ArrayList<String> keywords = new ArrayList<String>();
    Event next;

    public SimpleObjectEvent(Event event) {
        this.next = event;
    }

    @Override
    public EventType getEventType() {
        return EventType.KEYWORDOBJECT;
    }

    @Override
    public void setEventType(EventType type) {

    }

    @Override
    public Event getNextEvent() {
        return next;
    }

    @Override
    public void setNextEvent(Event event) {
        this.next = event;
    }

    @Override
    public List<String> getKeywords() {
        return keywords;
    }

    @Override
    public void go(Player player, Location location, String... targets) {
        for(String target:targets) {
            Out.ln(target);
        }
    }
}
