package com.illusionaryterrain.adventure;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    public Location location;
    public boolean isAlive = true;
    public boolean moved = true;

    public ArrayList<ObjectItem> inventory = new ArrayList<>();


    public void printLongLocation() {
        System.out.println(location.longDescription);
    }
}
