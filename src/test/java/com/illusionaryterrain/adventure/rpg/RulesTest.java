package com.illusionaryterrain.adventure.rpg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RulesTest {
    @Test
    void combatBetweenTwoGiantSpiders() {
        Integer[] dice = {1,1,6,6};
        TestableDiceBag bag = new TestableDiceBag(dice);

        RPGSheet spiderA = FiendFactory.createGiantSpider();
        RPGSheet spiderB = FiendFactory.createGiantSpider();

        CombatResult cr = Rules.combat(spiderA, spiderB, bag);

        assertEquals(3, spiderA.stats.get("stamina"));
        assertEquals(5, spiderB.stats.get("stamina"));
        assertEquals(2, cr.aDamage);
        assertEquals(0, cr.bDamage);
        assertEquals(8,cr.aTotal);
        assertEquals(2, cr.aRoll);
        assertEquals(18,cr.bTotal);
        assertEquals(12, cr.bRoll);



    }
}
