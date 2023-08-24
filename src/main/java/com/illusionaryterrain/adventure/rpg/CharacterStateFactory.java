package com.illusionaryterrain.adventure.rpg;

import com.illusionaryterrain.adventure.Out;

import java.util.Hashtable;

/**
 * This class will generate a new character, returning a Hashtable of named states to be added to players state.
 */
public class CharacterStateFactory {

    public static Hashtable<String, Integer> createNewCharacter(RandomDiceGenerator rnd) {
        Hashtable<String, Integer> stats = new Hashtable<>();

        stats.put("skill", rnd.getNext() + 6);
        stats.put("stamina", rnd.getNextTotal(2)+ 12);
        stats.put("luck", rnd.getNext() + 6);
        stats.put("mana", rnd.getNextTotal(2)+6);

        return stats;
    }

    public static void writeStats(Hashtable<String, Integer> state) {
        Out.ln("Skill.... "+state.get("skill"));
        Out.ln("Stamina.. "+state.get("stamina"));
        Out.ln("Luck..... "+state.get("luck"));
        Out.ln("Mana..... "+state.get("mana"));

    }

}