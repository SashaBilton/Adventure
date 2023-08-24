package com.illusionaryterrain.adventure.rpg;

public class Rules {

    public static CombatResult combat(RPGSheet a, RPGSheet b, DiceGenerator bag) {
        CombatResult r = new CombatResult();
        r.aRoll = bag.getNextTotal(2);
        r.aTotal = r.aRoll + a.stats.get("skill");
        r.bRoll = bag.getNextTotal(2);
        r.bTotal = r.bRoll + b.stats.get("skill");

        if (r.aTotal > r.bTotal) {
            r.bDamage = 2;
            r.aDamage = 0;
        } else if (r.aTotal < r.bTotal ) {
            r.bDamage = 0;
            r.aDamage = 2;
        } else {
            r.bDamage = 0;
            r.aDamage = 0;
        }

        a.stats.put("stamina", a.stats.get("stamina")-r.aDamage);
        b.stats.put("stamina", b.stats.get("stamina")-r.bDamage);

        return r;
    }
}
