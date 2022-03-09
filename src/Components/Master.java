package Components;

import java.util.HashMap;
import java.util.Map;

public class Master extends Element {
    private Map<String, Item> masterItems;
//    private final Map<String, Item> MapItems;

    public Master(String name, Item[] items) {
        super(name);
        Map<String, Item> sItems = new HashMap<String, Item>();
        for (Item i : items) {
            sItems.put(i.getName(), i);
        }
        masterItems = sItems;
    }

    public Map<String, Item> getMasterItems() {
        return masterItems;
    }

    public boolean hasItem(String itemName){
        return getMasterItems().get(itemName) != null;
    }



    public void addToMasterList(Item i) {
        masterItems.put(i.getName(), i);
    }

    public void removeFromMasterList(Item i) {
        masterItems.remove(i.getName());
    }
}
