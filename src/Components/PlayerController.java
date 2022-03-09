package Components;

import java.util.HashMap;
import java.util.Map;

public class PlayerController {
    private Player player;
    private final Direction direction;
    private boolean isWon;

    public PlayerController(Item[] items) {
        this.player = Player.getInstance();
        this.direction = new Direction();
        player.initializePlayer(100, items);
        this.isWon = false;
    }


    private class Direction {
        private final Directions[] dirs = Directions.values();
        private int i;

        private Direction() {
            this.i = 0;
        }

        private void turnRight() {
            if (i == 3)
                i = 0;
            else
                i++;
        }

        private void turnLeft() {
            if (i == 0)
                i = 3;
            else
                i--;

        }

        private Directions getCurrentDirection() {
            return dirs[i];
        }

        private Directions getOppositeDirection() {
            return dirs[(i + 2) % 4];
        }
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }

    public Directions turnRight() {
        direction.turnRight();
        return direction.getCurrentDirection();
    }

    public Directions turnLeft() {
        direction.turnLeft();
        return direction.getCurrentDirection();
    }

    public Element getFacingElement() {
        Directions dir = direction.getCurrentDirection();
        Room room = player.getCurrentRoom();
        return room.getWallElement(dir);
    }

    public Element getOppositeElement() {
        Directions dir = direction.getOppositeDirection();
        Room room = player.getCurrentRoom();
        return room.getWallElement(dir);
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public void changeRoom(Room room) {
        player.setCurrentRoom(room);
    }

    public String acquireKey(ContainerElements e) {
        Key k = e.acquireKey();
        player.addToPlayerList(k);
        return k.getName();
    }

    public Map<String, Item> acquireCabinetItems(Cabinet c) {
        Map<String, Item> items = c.getCabinetItems();
        if (items != null) {
            for (Item i : items.values())
                player.addToPlayerList(i);
        }
        return items;
    }

    public Item getItemByName(String itemName) {
        Map<String, Item> playerItems = player.getPlayerItems();
        return playerItems.get(itemName);
    }

    public boolean hasItem(String itemName){
        return  getItemByName(itemName) != null;
    }

    public boolean isCurrentRoomLightsOn() {
        Room r = getCurrentRoom();
        Flashlight f = (Flashlight) getItemByName("Flashlight");
        if (f == null) return r.isLightingOn();
        else return (f.isFlashOn() || r.isLightingOn());
    }

    public boolean canBuyItem(Item i) {
        return (player.getAmtOfGold() - i.getPrice()) >= 0;
    }

    public void buyItem(Item i, Master master) {
        if (canBuyItem(i)) {
            player.addToPlayerList(i);
            player.discountGold(i.getPrice());
            master.removeFromMasterList(i);
        }
    }

    public void sellItem(Item i, Master master) {
            master.addToMasterList(i);
            player.addGold(i.getPrice());
            player.removeFromPlayerList(i);
    }

    public Map<String,String> getPlayerStatus(){
        Map<String, String> pStatus = new HashMap<String, String>();
        StringBuilder stringBuilder = new StringBuilder();
        for (Item i : player.getPlayerItems().values()) {
            stringBuilder.append(i.getName()+",");
        }
        pStatus.put("Items", stringBuilder.toString());
        pStatus.put("Amount of gold", String.valueOf(player.getAmtOfGold()));
        pStatus.put("Direction", direction.getCurrentDirection().toString());
        return pStatus;
    }




}
