package com.illusionaryterrain.adventure.events;

import com.illusionaryterrain.adventure.Game;
import com.illusionaryterrain.adventure.StateType;
import com.illusionaryterrain.adventure.objects.ObjectItem;

public class StateChangeEvent extends SimpleObjectEvent{

    private StateType type;
    private String state;
    private Integer value;
    public StateChangeEvent(Event event,StateType type,String state, Integer value) {
        super(event);
        this.state = state;
        this.value = value;
        this.type = type;
    }

    @Override
    public void go(Game game, String... targets) {
        switch (type) {
            case PLAYER -> game.player.state.put(state, value);
            case LOCATION -> game.player.location.state.put(state, value);
            case GLOBAL -> game.state.put(state, value);
            case ITEM -> setItemState(game, targets);
        }

    }
    public void setItemState(Game game, String... targets) {

        for (ObjectItem item : game.player.inventory) {
            item.getState().put(state,value);
        }
    }

}
