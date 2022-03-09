package Components;

import java.util.HashMap;
import java.util.Map;

public class Cabinet extends LockableElement {
    private Map<String, Item> cabinetItems;

    public Cabinet(boolean isLocked, String name, Key lockKey, Item[] items) {
        super(isLocked, name, lockKey);
        Map<String, Item> cItems = new HashMap<>();
        for (Item i : items) {
            cItems.put(i.getName(), i);
        }
        cabinetItems = cItems;
    }

    public Map<String, Item> getCabinetItems() {
        if (!isLocked) {
            Map<String,Item> tmp = Map.copyOf(cabinetItems);
            cabinetItems = null;
            return tmp;
        } else return null;
    }
}
