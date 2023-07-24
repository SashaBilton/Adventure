package com.illusionaryterrain.adventure.events;

import com.illusionaryterrain.adventure.*;

import java.util.List;

public abstract class SimpleObjectEvent implements Event {
      Event next;
      EventType type;

      String description;

    public SimpleObjectEvent(Event event) {
        this.next = event;
    }

    @Override
    public EventType getEventType() {
        return type;
    }

    @Override
    public void setEventType(EventType type) { this.type = type;}


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
        return null;
    }

    @Override
    public void go(Game game, String... targets) {
        goNext(game, targets);
    }

    public void goNext(Game game, String... targets){
        if(next!=null) {
            next.go(game, targets);
        }
    }
}
