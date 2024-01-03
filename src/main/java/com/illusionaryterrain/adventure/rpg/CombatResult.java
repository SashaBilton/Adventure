package com.illusionaryterrain.adventure.rpg;

import com.illusionaryterrain.adventure.Out;
import com.illusionaryterrain.adventure.Player;

import static com.illusionaryterrain.adventure.rpg.Rules.STAMINA;

public class CombatResult {

    public Integer aRoll;
    public Integer aTotal;
    public Integer aDamage;

    public Integer bRoll;
    public Integer bTotal;
    public Integer bDamage;


    public void displayResults(Player player, RPGSheet creature) {
        Out.ln("You rolled a "+aRoll+" and the "+creature.getName()+" rolled a "+ bRoll);
        Out.ln("Your total is "+aTotal+" while it's is "+bTotal);
        if (aDamage > 0) {
            Out.ln("You take "+aDamage+" damage!");
        } else if(bDamage>0) {
            Out.ln("It takes "+bDamage+" damage.");
        } else {
            Out.ln("You exchange blows but neither wound each other.");
        }
        if (creature.stats.get(STAMINA) < 1) {
            Out.ln("You have slain the "+creature.name+"!");
            player.location.killCreature(creature);
        } if (player.rpg.stats.get(STAMINA) < 1) {
            Out.ln("The "+creature.name+" has killed you!");
            player.die();
        }
    }



}
