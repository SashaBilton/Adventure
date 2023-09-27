package com.illusionaryterrain.adventure;

import com.illusionaryterrain.adventure.objects.ObjectItem;
import com.illusionaryterrain.adventure.objects.ObjectItemType;
import com.illusionaryterrain.adventure.rpg.CombatResult;
import com.illusionaryterrain.adventure.rpg.RPGSheet;
import com.illusionaryterrain.adventure.rpg.Rules;

import java.util.ArrayList;
import java.util.Hashtable;

import static com.illusionaryterrain.adventure.rpg.Rules.STAMINA;

public class Player {
    public Location location;
    public boolean isAlive = true;
    public boolean moved = true;

    public ArrayList<ObjectItem> inventory = new ArrayList<>();
    public Hashtable<String, Integer> state = new Hashtable<>();

    public RPGSheet rpg;
    public Player() {
    }

    public void take(String parameter) {

        ObjectItem taken = null;
        boolean found = false;
        if (parameter.equals("")) {
            location.showContents();
        }

        for (ObjectItem item: location.contents) {
            if (item.getKeywords().contains(parameter) ) {
                found = true;
                if (item.getType() != ObjectItemType.IMMOVABLE) {
                    inventory.add(item);
                    taken = item;
                    Out.ln(parameter + " taken.");
                } else {
                    Out.ln(parameter + " cannot be taken.");
                }
            }
        }
        if (taken != null) {
            location.contents.remove(taken);
        }
        if (!found) {
            Out.ln("There is no "+parameter+" here.");
        }
    }

    protected void drop(String parameter) {

        ObjectItem dropped = null;
        for (ObjectItem item: inventory) {
            if (item.getKeywords().contains(parameter)) {
                location.contents.add(item);
                dropped = item;
                Out.ln(parameter+" dropped.");
            }
        }
        if (dropped != null) {
            inventory.remove(dropped);
        }
    }
    public void invent() {
        Out.ln("I am carrying -");
        for (ObjectItem item: inventory) {
            Out.ln(item.getDescription());
        }
    }



    public void go(String parameter) {

        for (Exit exit: location.exits) {
            if (parameter.equals("")) {
                Out.ln(exit.description);
            }
            if (exit.keywords.contains(parameter)) {
                Integer closed = exit.state.get("CLOSED");

                if (closed != null && closed > 0 ) {
                    Out.ln("I can't currently go that way.");
                } else {
                    location.visited = true;
                    moved = true;
                    location = exit.location;
                }
            }
        }
    }

    public ObjectItem getItem(String name) {
        for(ObjectItem item: inventory) {
            if (item.getKeywords().contains(name)) {
                return item;
            }
        }
        return null;
    }

    public void fight(String foe, Game game) {
        RPGSheet creature = (RPGSheet) game.player.location.inhabitants.get(foe);

        if (creature != null) {
            CombatResult cr = Rules.combat(game.player.rpg, creature, game.diceBag);
            Out.ln("You rolled a "+cr.aRoll+" and the "+creature.getName()+" rolled a "+ cr.bRoll);
            Out.ln("Your total is "+cr.aTotal+" while it's is "+cr.bTotal);
            if (cr.aDamage > 0) {
                Out.ln("You take "+cr.aDamage+" damage!");
            } else if(cr.bDamage>0) {
                Out.ln("It takes "+cr.bDamage+" damage.");
            } else {
                Out.ln("You exchange blows but neither wound each other.");
            }
            if (creature.stats.get(STAMINA) < 1) {
                Out.ln("You have slain the "+creature.name+"!");
                game.player.location.killCreature(creature);
            } if (game.player.rpg.stats.get(STAMINA) < 1) {
                Out.ln("The "+creature.name+" has killed you!");
                game.player.die();
            }
        }
    }

    private void die() {
        isAlive = false;
    }

}
