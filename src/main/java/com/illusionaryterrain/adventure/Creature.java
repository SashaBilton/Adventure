package com.illusionaryterrain.adventure;

public interface Creature {

    enum CreatureType {
        FRIENDLY,
        FOE
    }

    public String getName();
    public String getDescription();
    public CreatureType getCreatureType();
}
