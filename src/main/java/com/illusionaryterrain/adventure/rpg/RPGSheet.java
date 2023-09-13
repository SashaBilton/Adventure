package com.illusionaryterrain.adventure.rpg;

import com.illusionaryterrain.adventure.Creature;

import java.util.Hashtable;

public class RPGSheet implements Creature{

    public String name = "";
    public String description;
    public Hashtable<String, Integer> stats;

    public CreatureType type;

    public RPGSheet() {}

    public RPGSheet(String name, String desciption, Hashtable<String, Integer> stats){
        this.name = name;
        this.stats = stats;
        type = CreatureType.FOE;
        this.description = desciption;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Creature.CreatureType getCreatureType() {
        return type;
    }
}
