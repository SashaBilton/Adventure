package com.illusionaryterrain.adventure.objects;

import com.illusionaryterrain.adventure.events.Event;

import java.util.ArrayList;
import java.util.List;

public interface ObjectItem {
    public Enum<ObjectItemType> getType();
    public void setType(Enum<ObjectItemType> type);
    public String getDescription();
    public void setDescription(String description);
    public List<String> getKeywords();
    public void setKeywords(ArrayList<String> keywords);
    public List<Event> getEvents();
    public void setEvents(ArrayList<Event> events);



}
