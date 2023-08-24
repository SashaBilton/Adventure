package com.illusionaryterrain.adventure.rpg;

import java.util.Random;

/**
 * A standard always random dice roll generator
 */
public class InfiniteDiceBag implements RandomDiceGenerator{

    Random rnd = new Random();
    @Override
    public Integer getNext() {
        return rnd.nextInt(1,7);
    }

    @Override
    public Integer getNextTotal(int n) {
        int value =0;
        for(int i=0; i<n; i++) {
            value += getNext();
        }
        return value;
    }
}
