package com.illusionaryterrain.adventure.events;

import com.illusionaryterrain.adventure.Game;
import com.illusionaryterrain.adventure.objects.ObjectItem;

/**
 * Change or add a state to item
 */
public class ItemStateChangeEvent extends SimpleObjectEvent{


    private String state;
    private Integer value;

    private ObjectItem item;

    public ItemStateChangeEvent(Event event, ObjectItem item, String state, Integer value) {
        super(event);
        this.state = state;
        this.value = value;
        this.item = item;
    }

    @Override
    public void go(Game game, String... targets) {
        item.getState().put(state,value);
        goNext(game, targets);
    }


}
