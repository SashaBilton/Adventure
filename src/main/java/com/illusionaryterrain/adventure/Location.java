package com.illusionaryterrain.adventure;

import java.util.ArrayList;
import java.util.List;

public class Location {
    public String shortDescription;
    public String longDescription;
    public boolean visited = false;
    public List<Exit> exits = new ArrayList<Exit>();

}
