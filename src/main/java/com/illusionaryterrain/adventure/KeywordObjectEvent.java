package com.illusionaryterrain.adventure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeywordObjectEvent extends SimpleObjectEvent {



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
