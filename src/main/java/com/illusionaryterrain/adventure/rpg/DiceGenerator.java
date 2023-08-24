package com.illusionaryterrain.adventure.rpg;

/**
 * Classes that implement this method are expected to generate dice rolls values, either as a single roll or a total of n d6.
 * While it's nice from a code narrative point of view, it also means you can unit test "random" events by supplying predefined rolls.
 */
public interface DiceGenerator {

    Integer getNext();
    Integer getNextTotal(int n);
}
