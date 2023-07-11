package com.illusionaryterrain.adventure;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and to Adventure!");

        Location location = new Location();
        location.longDescription = "A long hall with an arched ceiling far above you and a chequered floor.";
        Player player = new Player();
        player.location = location;
        player.printLongLocation();

    }
}