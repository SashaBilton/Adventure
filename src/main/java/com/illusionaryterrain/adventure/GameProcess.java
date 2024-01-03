package com.illusionaryterrain.adventure;

import com.illusionaryterrain.adventure.rpg.CombatResult;
import com.illusionaryterrain.adventure.rpg.RPGSheet;
import com.illusionaryterrain.adventure.rpg.Rules;

public class GameProcess {

    public static void loop(Game game) {

        while (game.player.isAlive) {

            creaturesFight(game);

            if (game.player.moved) {
                // I don't like this "delayed move" mechanic, used so that monsters attack one last time.
                game.player.location = game.player.nextLocation;
                game.player.location.enter(game);
                game.player.moved = false;

            }
            CommandProcess.input(game);

        }
    }

    public static void creaturesFight(Game game) {
        Location here = game.player.location;

        for(Creature creature : here.inhabitants.values()) {
            if (creature.getCreatureType() == Creature.CreatureType.FOE) {
                CombatResult cr = Rules.combat(game.player.rpg, (RPGSheet) creature, game.diceBag);
                cr.displayResults(game.player, (RPGSheet) creature);
            }

        }

    }
}
