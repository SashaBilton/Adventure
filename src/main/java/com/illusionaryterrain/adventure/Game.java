package com.illusionaryterrain.adventure;

import com.illusionaryterrain.adventure.events.timed.TimedEvents;
import com.illusionaryterrain.adventure.rpg.DiceGenerator;

public class Game  extends HasState{

    public Player player = new Player();
    public TimedEvents timedEvents = new TimedEvents();

    public String introduction;

    public DiceGenerator diceBag;


}
