package com.illusionaryterrain.adventure;

import java.util.ArrayList;
import java.util.List;

public class Exit {
    public String description;
    public Location location;
    List<String> keywords = new ArrayList<String>();

    public Exit(String description) {
        this.description = description;
    }
}
