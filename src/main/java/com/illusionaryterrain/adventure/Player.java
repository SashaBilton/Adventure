package com.illusionaryterrain.adventure;

import java.util.ArrayList;

public class Player {
    public Location location;
    public boolean isAlive = true;
    public boolean moved = true;

    public ArrayList<ObjectItem> inventory = new ArrayList<>();

    public void take(String parameter) {

        ObjectItem taken = null;
        for (ObjectItem item: location.contents) {
            if (parameter.equals("")) {
                location.showContents();
            }
            if (item.getKeywords().contains(parameter)) {
                inventory.add(item);
                taken = item;
                Out.ln(parameter+" taken.");
            }
        }
        if (taken != null) {
            location.contents.remove(taken);
        }
    }

    protected void drop(String parameter) {

        ObjectItem dropped = null;
        for (ObjectItem item: inventory) {
            if (item.getKeywords().contains(parameter)) {
                location.contents.add(item);
                dropped = item;
                Out.ln(parameter+" dropped.");
            }
        }
        if (dropped != null) {
            inventory.remove(dropped);
        }
    }
    public void invent() {
        Out.ln("I am carrying -");
        for (ObjectItem item: inventory) {
            Out.ln(item.getDescription());
        }
    }



    public void go(String parameter) {

        for (Exit exit: location.exits) {
            if (parameter.equals("")) {
                Out.ln(exit.description);
            }
            if (exit.keywords.contains(parameter)) {
                location.visited = true;
                moved = true;
                location = exit.location;
            }
        }
    }

}
