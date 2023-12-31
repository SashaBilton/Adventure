package com.illusionaryterrain.adventure.objects;

import com.illusionaryterrain.adventure.HasState;
import com.illusionaryterrain.adventure.events.Event;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class SimpleObject extends HasState implements ObjectItem {

    public String description;
    public ObjectItemType type;

    public ArrayList<String> keywords = new ArrayList<>();
    public ArrayList<Event> events = new ArrayList<>();

    public SimpleObject( ObjectItemType type, String... args) {
        this.description = args[0];
        this.type = type;
        int next = 1;
        while (next < args.length) {
            keywords.add(args[next]);
            next++;
        }
    }

    @Override
    public Enum<ObjectItemType> getType() {
        return type;
    }

    @Override
    public void setType(Enum<ObjectItemType> type) {
        this.type = (ObjectItemType) type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public List<String> getKeywords() {
        return keywords;
    }

    @Override
    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public List<Event> getEvents() {
        return events;
    }

    @Override
    public void setEvents(ArrayList<Event> events) { this.events = events;}

    @Override
    public Hashtable<String, Integer> getState() {
        return state;
    }
}
