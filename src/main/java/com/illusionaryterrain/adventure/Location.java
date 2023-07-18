package com.illusionaryterrain.adventure;

import com.illusionaryterrain.adventure.events.Event;
import com.illusionaryterrain.adventure.objects.ObjectItem;

import java.util.ArrayList;
import java.util.List;

public class Location {
    public String shortDescription;
    public String longDescription;
    public boolean visited = false;
    public List<Exit> exits = new ArrayList<Exit>();
    public List<ObjectItem> contents = new ArrayList<>();

    public List<Event> events = new ArrayList<>();


    public Location(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    public Location(String shortDescription, String longDescription) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public void enter(){
        if (visited) {
            Out.ln(shortDescription);
            showExits();
            showContents();
        } else {
            look();
        }
    }
    public void look() {
        Out.sl("You are in ");
        Out.ln(longDescription);
        showExits();
        showContents();
    }
    public void showExits() {
        Out.ln("Obvious exits are -");
        for (Exit exit: exits) {
            Out.ln(exit.description);
        }
    }

    public void showContents() {
        if (contents.size() > 0) {
            Out.ln("You also see here -");
            for (ObjectItem item: contents) {
                Out.ln(item.getDescription());
            }
        }
    }

}
