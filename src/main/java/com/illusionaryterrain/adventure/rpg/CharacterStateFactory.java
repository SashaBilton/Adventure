package com.illusionaryterrain.adventure.rpg;

import com.illusionaryterrain.adventure.Out;

import java.util.Hashtable;

/**
 * This class will generate a new character, returning a Hashtable of named states to be added to players state.
 */
public class CharacterStateFactory {

    public static RPGSheet createNewCharacter(DiceGenerator rnd) {


        Hashtable<String, Integer> stats = new Hashtable<>();

        stats.put("skill", rnd.getNext() + 6);
        stats.put("stamina", rnd.getNextTotal(2)+ 12);
        stats.put("luck", rnd.getNext() + 6);
        stats.put("mana", rnd.getNextTotal(2)+6);

        return new RPGSheet("", stats);
    }

    public static void writeStats(RPGSheet rpg) {
        Out.ln("Skill.... "+ rpg.stats.get("skill"));
        Out.ln("Stamina.. "+rpg.stats.get("stamina"));
        Out.ln("Luck..... "+rpg.stats.get("luck"));
        Out.ln("Mana..... "+rpg.stats.get("mana"));

    }

}