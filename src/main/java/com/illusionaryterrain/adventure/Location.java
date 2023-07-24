package com.illusionaryterrain.adventure;

import com.illusionaryterrain.adventure.events.Event;
import com.illusionaryterrain.adventure.objects.ObjectItem;

import java.util.ArrayList;
import java.util.List;

public class Location extends HasState{
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

    public void enter(Game game){
        if (itIsDark(game.player)) {
            return;
        }
        if (visited) {
            Out.ln(shortDescription);
            showExits();
            showContents();
        } else {
            look(game);
        }
    }
    public void look(Game game) {
        if (itIsDark(game.player)) {
            return;
        }
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

    public boolean itIsDark(Player player) {
        if ((state.get("LIT") != null && state.get("LIT") == 0 ) &&
                (player.state.get("LIGHT") !=null && player.state.get("LIGHT")==0)) {
            Out.ln("It's too dark too see in here.");
            return true;
        }
        else {
            return false;
        }
    }
}
