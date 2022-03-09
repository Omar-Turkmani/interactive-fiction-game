package Components;

public class Door extends LockableElement {
    private Room room1,room2;
    private boolean isOpen;

    public Door(boolean isLocked, Room room1, Room room2, boolean isOpen, String name,Key lockKey) {
        super(isLocked,name,lockKey);
        this.room1 = room1;
        this.room2 = room2;
        this.isOpen = isOpen;
    }

    public void openDoor(){
        if (!isLocked){
            isOpen = true;
        }
    }

    public boolean isOpen() {
        return isOpen;
    }

    public Room getNeighboringRoom(Room currentRoom){
        if (currentRoom.equals(room1)) return room2;
        else return room1;
    }
}
