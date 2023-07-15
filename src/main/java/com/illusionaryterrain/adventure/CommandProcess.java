package com.illusionaryterrain.adventure;

import java.util.Scanner;

public class CommandProcess {


    public void input(Player player) {
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
        action(player, input);
    }

    public void action(Player player, String... command) {

        switch (command[0]) {
            case "go" -> player.go(command[1]);
            case "look" -> player.location.look();
            case "quit" -> quit(player);
            case "take" -> player.take(command[1]);
            case "drop" -> player.drop(command[1]);
            case "invent" -> player.invent();
            case "help" -> help();
            default -> eventCommand(player, command);

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
        Out.ln("go <direction> - go in a particular direction or towards something.");
        Out.ln("take - take an item from here.");
        Out.ln("drop - leave an item here");
        Out.ln("invent - list the items I'm carrying");
        Out.ln("use - use an item");
        Out.ln("quit - quit Adventure");
        Out.ln("help - prints this list of commands");
    }

    private void eventCommand(Player player, String[] command){
        // go through all item events and location events
        for (ObjectItem item: player.inventory) {
            for(Event event: item.getEvents()) {
                if (event.getKeywords().contains(command[0])) {
                    event.go(player, player.location, command);
                }
            }
        }
        for (Event event: player.location.events) {
            if(event.getKeywords().contains(command[0])){
                event.go(player, player.location, command);
            }
        }
    }
}
