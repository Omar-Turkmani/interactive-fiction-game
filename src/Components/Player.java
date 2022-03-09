package Components;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private static Player p = new Player();
    private Room currentRoom;
    private int amountOfGold;
    private Map<String, Item> playerItems;

    private Player() {
    }

    public static Player getInstance() {
        return p;
    }

    public void initializePlayer(int amountOfGold, Item[] items) {
        setAmountOfGold(amountOfGold);
        Map<String, Item> pItems = new HashMap<String, Item>();
        for (Item i : items) {
            pItems.put(i.getName(), i);
        }
        playerItems = pItems;

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getAmtOfGold() {
        return amountOfGold;
    }

    public void addGold(int amount) {
        amountOfGold += amount;
    }

    public void discountGold(int amount) {
        if (amountOfGold - amount >= 0)
            amountOfGold -= amount;
    }

    public void setAmountOfGold(int amountOfGold) {
        this.amountOfGold = amountOfGold;
    }

    public Map<String, Item> getPlayerItems() {
        return playerItems;
    }

    public void addToPlayerList(Item i) {
        playerItems.put(i.getName(), i);
    }

    public void removeFromPlayerList(Item i) {
        playerItems.remove(i.getName());
    }

}
