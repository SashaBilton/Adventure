package com.illusionaryterrain.adventure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
}
