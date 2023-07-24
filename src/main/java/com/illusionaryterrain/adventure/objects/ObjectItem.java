package com.illusionaryterrain.adventure.objects;

import com.illusionaryterrain.adventure.events.Event;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public interface ObjectItem {
    Enum<ObjectItemType> getType();
    void setType(Enum<ObjectItemType> type);
    String getDescription();
    void setDescription(String description);
    List<String> getKeywords();
    void setKeywords(ArrayList<String> keywords);
    List<Event> getEvents();
    void setEvents(ArrayList<Event> events);
    Hashtable<String, Integer> getState();



}
