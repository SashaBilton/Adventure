package com.illusionaryterrain.adventure;

import com.illusionaryterrain.adventure.simplegame.SimpleGameData;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome to Adventure!");


        Game game = new Game();
        game.player.location = SimpleGameData.GenerateMap(game);

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