package com.illusionaryterrain.adventure;

import java.util.Scanner;

public class CommandProcess {


    public void work(Player player) {
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
        Out.ln(command);
        Out.ln(parameter);

        switch (command) {
            case "go" -> go(player, parameter);
            case "look" -> look(player);
            case "quit" -> quit(player);
            case "take" -> take(player, parameter);
            case "help" -> help();
        }


    }

    private void go(Player player, String parameter) {

        for (Exit exit: player.location.exits) {
            if (parameter.equals("")) {
                Out.ln(exit.description);
            }
            if (exit.keywords.contains(parameter)) {
                player.location.visited = true;
                player.moved = true;
                player.location = exit.location;
            }
        }
    }

    private void look(Player player) {
        Out.sl("You are in ");
        player.printLongLocation();
        Out.ln("Obvious exits are -");
        player.location.showExits();
    }

    private void quit(Player player) {
        player.isAlive = false;
        Out.ln("Goodbye.");
    }

    private void take(Player player, String parameter) {

        ObjectItem taken = null;
        for (ObjectItem item: player.location.contents) {
            if (parameter.equals("")) {
                player.location.showContents();
            }
            if (item.getKeywords().contains(parameter)) {
                player.inventory.add(item);
                taken = item;
                Out.ln(parameter+" taken.");
            }
        }
        if (taken != null) {
            player.location.contents.remove(taken);
        }
    }

    private void help() {
        Out.ln("I understand the following commands -");
        Out.ln("look - describe where I am.");
        Out.ln("go - list the exits available here.");
        Out.ln("go <direction> - go in a particular direction or towards something.");
        Out.ln("take - take an item from here.");
        Out.ln("drop - leave an item here");
        Out.ln("use - use an item");
        Out.ln("quit - quit Adventure");
        Out.ln("help - prints this list of commands");
    }

}
