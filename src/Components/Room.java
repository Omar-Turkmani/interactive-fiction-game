package Components;

public class Room {


    private String name;
    private RoomWalls walls;
    private boolean isLightingOn;
    private final boolean hasLighting;


    public Room(String name, boolean isLightingOn, boolean hasLighting) {
        this.name = name;
        this.hasLighting = hasLighting;
        if (hasLighting)
            this.isLightingOn = isLightingOn;
        else this.isLightingOn = false;
    }

    public Element getWallElement(Directions dir) {
        return walls.getRoomWalls().get(dir);
    }

    public boolean isLightingOn() {
        if (hasLighting)
            return isLightingOn;
        else return false;
    }

    public String getName() {
        return name;
    }

    public boolean isHasLighting() {
        return hasLighting;
    }


    public void switchLights() {
        if (hasLighting) {
            isLightingOn = !isLightingOn;
        }
    }

    public void setWalls(RoomWalls walls) {
        this.walls = walls;
    }
}
