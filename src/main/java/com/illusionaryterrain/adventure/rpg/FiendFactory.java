package com.illusionaryterrain.adventure.rpg;

import java.util.Hashtable;

public class FiendFactory {

    public static RPGSheet createGiantSpider() {

        Hashtable<String, Integer> giantSpiderStat = new Hashtable<>();
        giantSpiderStat.put("skill", 6);
        giantSpiderStat.put("stamina", 5);

        return new RPGSheet("giant spider", giantSpiderStat);

    }


}
