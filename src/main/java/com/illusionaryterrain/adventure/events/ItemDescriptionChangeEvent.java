package com.illusionaryterrain.adventure.events;

import com.illusionaryterrain.adventure.Game;
import com.illusionaryterrain.adventure.objects.ObjectItem;

/**
 * Change the description of an item
 */
public class ItemDescriptionChangeEvent extends SimpleObjectEvent {

    String newDesc;
    ObjectItem item;

    public ItemDescriptionChangeEvent(Event event, ObjectItem item, String description) {
        super(event);
        newDesc = description;
        this.item = item;
    }

    @Override
    public void go(Game game, String... targets) {
        item.setDescription(newDesc);
        goNext(game, targets);
    }
}
