package com.illusionaryterrain.adventure.events;

import com.illusionaryterrain.adventure.*;
import com.illusionaryterrain.adventure.objects.ObjectItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This event fires if the first string parameter is listed in the events list of keywords AND
 * the player owes the item listed as the second item.
 * This allows for "light candle" as a command for example.
 */
public class KeywordItemEvent extends SimpleObjectEvent {

    ArrayList<String> keywords = new ArrayList<>();
    public KeywordItemEvent(Event event, String... keywords){
        super(event);
        this.keywords.addAll(Arrays.asList(keywords));
    }
    @Override
    public void go(Game game, String... target) {

        if (keywords.contains(target[0])) {
            ObjectItem hasItem = game.player.getItem(target[1]);
            if (hasItem != null) {
                goNext(game, target);
            }
        }


    }
    public List<String> getKeywords() {
        return keywords;
    }


}
