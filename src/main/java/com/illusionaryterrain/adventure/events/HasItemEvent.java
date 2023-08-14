package com.illusionaryterrain.adventure.events;

import com.illusionaryterrain.adventure.Game;
import com.illusionaryterrain.adventure.Out;
import com.illusionaryterrain.adventure.objects.ObjectItem;

/**
 * Call the next Event if the player has a item/object
 */
public class HasItemEvent extends SimpleObjectEvent {

    ObjectItem item;
    String failMsg;


    public HasItemEvent(Event event, ObjectItem item, String fail) {
        super(event);
        this.item = item;
        this.failMsg = fail;
    }

    @Override
    public void go(Game game, String... targets) {
        boolean found = false;
        for (String keyword : item.getKeywords())
            if (game.player.getItem(keyword) != null) {
                found = true;
            }
        if (found) {
            goNext(game, targets);
        }
        else {
            if (!failMsg.equals("")) {
                Out.ln(failMsg);
            }
        }
    }
}
