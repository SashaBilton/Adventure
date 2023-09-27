package com.illusionaryterrain.adventure.rpg;

public class Rules {

    public static final String SKILL = "skill";
    public static final String STAMINA = "stamina";
    public static final String MANA = "mana";

    public static final String LUCK = "luck";



    public static CombatResult combat(RPGSheet a, RPGSheet b, DiceGenerator bag) {
        CombatResult r = new CombatResult();
        r.aRoll = bag.getNextTotal(2);
        r.aTotal = r.aRoll + a.stats.get(SKILL);
        r.bRoll = bag.getNextTotal(2);
        r.bTotal = r.bRoll + b.stats.get(SKILL);

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

        a.stats.put(STAMINA, a.stats.get(STAMINA)-r.aDamage);
        b.stats.put(STAMINA, b.stats.get(STAMINA)-r.bDamage);

        return r;
    }
}
