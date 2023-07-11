package com.illusionaryterrain.adventure;

import java.util.ArrayList;
import java.util.List;

public class SimpleObject implements ObjectItem{

    public String description ="";
    public ObjectItemType type = ObjectItemType.USELESS;

    public ArrayList<String> keywords = new ArrayList<String>();

    public SimpleObject(String description, ObjectItemType type) {
        this.description = description;
        this.type = type;
    }

    @Override
    public Enum<ObjectItemType> getType() {
        return type;
    }

    @Override
    public void setType(Enum<ObjectItemType> type) {
        this.type = (ObjectItemType) type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public List<String> getKeywords() {
        return keywords;
    }

    @Override
    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }
}
