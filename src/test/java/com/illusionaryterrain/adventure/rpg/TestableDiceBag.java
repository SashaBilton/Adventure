package com.illusionaryterrain.adventure.rpg;

public class TestableDiceBag implements com.illusionaryterrain.adventure.rpg.RandomDiceGenerator{

    public Integer[] diceRolls;
    public TestableDiceBag(Integer[] diceRolls) {
        this.diceRolls = diceRolls;
    }

    public int position = 0;

    @Override
    public Integer getNext() {
        return diceRolls[position++];
    }

    @Override
    public Integer getNextTotal(int n) {
        Integer total = 0;
        for(int i =0; i<n; i++) {
            total+= getNext();
        }
        return total;
    }
}
