package com.illusionaryterrain.adventure;

import com.illusionaryterrain.adventure.objects.ObjectItem;
import com.illusionaryterrain.adventure.objects.ObjectItemType;

import java.util.ArrayList;
import java.util.Hashtable;

public class Player {
    public Location location;
    public boolean isAlive = true;
    public boolean moved = true;

    public ArrayList<ObjectItem> inventory = new ArrayList<>();
    public Hashtable<String, Integer> state = new Hashtable<>();

    public Player() {
    }

    public void take(String parameter) {

        ObjectItem taken = null;
        boolean found = false;
        if (parameter.equals("")) {
            location.showContents();
        }

        for (ObjectItem item: location.contents) {
            if (item.getKeywords().contains(parameter) ) {
                found = true;
                if (item.getType() != ObjectItemType.IMMOVABLE) {
                    inventory.add(item);
                    taken = item;
                    Out.ln(parameter + " taken.");
                } else {
                    Out.ln(parameter + " cannot be taken.");
                }
            }
        }
        if (taken != null) {
            location.contents.remove(taken);
        }
        if (!found) {
            Out.ln("There is no "+parameter+" here.");
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
                Integer closed = exit.state.get("CLOSED");

                if (closed != null && closed > 0 ) {
                    Out.ln("I can't currently go that way.");
                } else {
                    location.visited = true;
                    moved = true;
                    location = exit.location;
                }
            }
        }
    }

    public ObjectItem getItem(String name) {
        for(ObjectItem item: inventory) {
            if (item.getKeywords().contains(name)) {
                return item;
            }
        }
        return null;
    }

}
