package com.illusionaryterrain.adventure;

import java.util.ArrayList;
import java.util.List;

public class Location {
    public String shortDescription;
    public String longDescription;
    public boolean visited = false;
    public List<Exit> exits = new ArrayList<Exit>();
    public List<ObjectItem> contents = new ArrayList<>();


    public Location(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void showExits() {
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
