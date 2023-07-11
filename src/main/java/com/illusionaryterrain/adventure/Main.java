package com.illusionaryterrain.adventure;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and to Adventure!");

        Location start = GenerateMap();
        Player player = new Player();
        player.location = start;

        while (player.isAlive) {
            if (player.moved) {
                Out.sl("You are in ");
                if (player.location.visited) {
                    Out.ln(player.location.shortDescription);
                } else {
                    Out.ln(player.location.longDescription);
                }
                Out.ln("Obvious exits are -");
                player.location.showExits();
                player.location.showContents();
                player.moved = false;

            }
            CommandProcess cp = new CommandProcess();
            cp.work(player);
        }
    }

    public static Location GenerateMap() {
        Location hall = new Location("a long hall.");
        hall.longDescription = "a long hall with an arched ceiling far above you and a chequered floor beneath.";
        Exit irondoor = new Exit("An iron shod door in the east.");
        irondoor.keywords.add("door");
        irondoor.keywords.add("east");
        hall.exits.add(irondoor);

        Location cal = new Location("the cauldron room ");
        cal.longDescription = "a square dark room with a massive iron cauldron bubbling away in the centre of it.";
        irondoor.location = cal;
        Exit irondoor2 = new Exit("An iron shod door in the west.");
        irondoor2.keywords.add("door");
        irondoor2.keywords.add("west");
        cal.exits.add(irondoor2);
        irondoor2.location = hall;

        SimpleObject candle = new SimpleObject("Flickering candle", ObjectItemType.LIGHT);
        candle.keywords.add("candle");
        hall.contents.add(candle);


        return hall;


    }
}