package com.illusionaryterrain.adventure;

import java.util.ArrayList;
import java.util.List;

public interface ObjectItem {
    public Enum<ObjectItemType> getType();
    public void setType(Enum<ObjectItemType> type);
    public String getDescription();
    public void setDescription(String description);
    public List<String> getKeywords();
    public void setKeywords(ArrayList<String> keywords);

}
