package com.illusionaryterrain.adventure;

import java.util.ArrayList;
import java.util.List;

public class Exit extends HasState{
    public String description;
    public Location location;
    List<String> keywords = new ArrayList<>();

    public Exit(Location to, String... args) {
        this.location = to;
        this.description = args[0];
        int next = 1;
        while (next < args.length) {
            keywords.add(args[next]);
            next++;
        }
    }
}
