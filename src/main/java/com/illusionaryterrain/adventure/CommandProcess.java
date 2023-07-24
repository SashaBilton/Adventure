package com.illusionaryterrain.adventure;

import com.illusionaryterrain.adventure.events.Event;
import com.illusionaryterrain.adventure.objects.ObjectItem;

import java.util.Scanner;

public class CommandProcess {


    public void input(Game game) {
        Out.sl(">");
        String line = new Scanner(System.in).nextLine();
        String[] input = line.split(" ");
        String command = "wait";
        String parameter = "";
        if (input.length > 0) {
            command = input[0];
            if (input.length> 1) {
                parameter = input[1];
            }
        }
        action(game, input);
    }

    public void action(Game game, String... command) {

        switch (command[0]) {
            case "go" -> game.player.go(command[1]);
            case "look" -> game.player.location.look(game);
            case "quit" -> quit(game.player);
            case "take" -> game.player.take(command[1]);
            case "drop" -> game.player.drop(command[1]);
            case "invent" -> game.player.invent();
            case "help" -> help();
            case "--dump" ->dump(game);
            default -> eventCommand(game, command);

        }
    }


    private void quit(Player player) {
        player.isAlive = false;
        Out.ln("Goodbye.");
    }

    private void help() {
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

    private void eventCommand(Game game, String[] command){
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

    public void dump(Game game) {

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
