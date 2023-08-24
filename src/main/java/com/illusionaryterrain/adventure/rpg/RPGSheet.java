package com.illusionaryterrain.adventure.rpg;

import java.util.Hashtable;

public class RPGSheet {

    public String name = "";
    public Hashtable<String, Integer> stats;

    public RPGSheet() {}

    public RPGSheet(String name, Hashtable<String, Integer> stats){
        this.name = name;
        this.stats = stats;
    }

}
