package com.illusionaryterrain.adventure;

import com.illusionaryterrain.adventure.simplegame.SimpleGameData;
import com.illusionaryterrain.adventure.tunnelsofterror.TunnelsOfTerrorGameData;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        game.player.location = TunnelsOfTerrorGameData.Generate(game);

        Out.ln(game.introduction);

        while (game.player.isAlive) {
            if (game.player.moved) {
                game.player.location.enter(game);
                game.player.moved = false;

            }
            CommandProcess cp = new CommandProcess();
            cp.input(game);
        }
    }


}