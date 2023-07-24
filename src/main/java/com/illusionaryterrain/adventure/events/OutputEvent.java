package com.illusionaryterrain.adventure.events;

import com.illusionaryterrain.adventure.Game;
import com.illusionaryterrain.adventure.Out;

public class OutputEvent extends SimpleObjectEvent{

    String output = "";
    public OutputEvent(Event event, String output) {
        super(event);
        this.output = output;

    }

    @Override
    public void go(Game game, String... targets) {
        Out.ln(output);
        goNext(game, targets);
    }
}
