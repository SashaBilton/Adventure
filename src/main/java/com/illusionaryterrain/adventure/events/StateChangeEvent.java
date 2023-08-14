package com.illusionaryterrain.adventure.events;

import com.illusionaryterrain.adventure.Game;
import com.illusionaryterrain.adventure.StateType;

/**
 * StateChangeEvents add or set a state value in player, location, or the global set of states.
 */
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
        }

        goNext(game, targets);


    }

}
