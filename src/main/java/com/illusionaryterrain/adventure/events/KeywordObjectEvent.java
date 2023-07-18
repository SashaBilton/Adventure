package com.illusionaryterrain.adventure.events;

import com.illusionaryterrain.adventure.*;
import com.illusionaryterrain.adventure.objects.ObjectItem;

import java.util.ArrayList;
import java.util.Arrays;

public class KeywordObjectEvent extends SimpleObjectEvent {


    ArrayList<String> keywords = new ArrayList<>();
    public KeywordObjectEvent(Event event, String... keywords){
        super(event);
        this.keywords.addAll(Arrays.asList(keywords));
    }
    @Override
    public void go(Player player, Location location, String[] target) {

        if (keywords.contains(target[0])) {
            ObjectItem hasItem = player.getItem(target[1]);
            if (hasItem != null) {
                next.go(player, location, target);
            }
        }
    }


}
