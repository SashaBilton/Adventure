package com.illusionaryterrain.adventure;

import com.illusionaryterrain.adventure.events.Event;
import com.illusionaryterrain.adventure.objects.ObjectItem;

import java.util.Scanner;

public class CommandProcess {


    public static void input(Game game) {
        Out.sl(">");
        String line = new Scanner(System.in).nextLine();
        String[] input = line.split(" ");
        action(game, input);
        game.timedEvents.tick++;
    }

    public static void action(Game game, String... command) {

        switch (command[0]) {
            case "go", "move" -> game.player.go(command[1]);
            case "look" -> game.player.location.look(game);
            case "quit","exit" -> quit(game.player);
            case "take","get" -> game.player.take(command[1]);
            case "drop", "leave" -> game.player.drop(command[1]);
            case "invent", "inventory" -> game.player.invent();
            case "help" -> help();
            case "attack", "fight" -> game.player.fight(command[1], game);
            case "--dump" ->dump(game);
            default -> eventCommand(game, command);

        }
    }


    private static void quit(Player player) {
        player.isAlive = false;
        Out.ln("Goodbye.");
    }

    private static void help() {
        Out.ln("I understand the following commands -");
        Out.ln("look - describe where I am.");
        Out.ln("go - list the exits available here.");
        Out.ln("go <direction - go in a particular direction or towards something.");
        Out.ln("take - take an item from here.");
        Out.ln("drop - leave an item here");
        Out.ln("invent - list the items I'm carrying");
        Out.ln("use - use an item");
        Out.ln("quit - quit Adventure");
        Out.ln("help - prints this list of commands");
    }

    private static void eventCommand(Game game, String[] command){
        // go through all item events and location events
        for (ObjectItem item: game.player.inventory) {
            for(Event event: item.getEvents()) {
                if (event.getKeywords()!= null && event.getKeywords().contains(command[0])) {
                    event.go(game, command);
                }
            }
        }
        for (Event event: game.player.location.events) {
            if(event.getKeywords()!= null && event.getKeywords().contains(command[0])){
                event.go(game, command);
            }
        }
    }

    public static void dump(Game game) {

        Out.ln("Game - ");
        game.state.forEach((name, value) -> Out.ln(name+" = "+value));

        Out.ln("Player - ");
        game.player.state.forEach((name, value) -> Out.ln(name+" = "+value));

        Out.ln("Location - ");
        game.player.location.state.forEach((name, value) -> Out.ln(name+" = "+value));

        Out.ln("Inventory -");
        game.player.inventory.forEach((item) -> {
            Out.ln(item.getDescription());
            item.getState().forEach((name, value) -> Out.ln(name+" = "+value));
        });
    }
}
