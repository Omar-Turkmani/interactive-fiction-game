package Components;

import java.util.HashMap;
import java.util.Map;

public class RoomWalls {
    private Map<Directions, Element> roomWalls;
    public RoomWalls(Element southElement, Element northElement, Element westElement, Element eastElement) {
        roomWalls = new HashMap<>();
        if (southElement != null)
            roomWalls.put(Directions.South, southElement);
        else
            roomWalls.put(Directions.South, new Wall("plain wall"));
        if (northElement != null)
            roomWalls.put(Directions.North, northElement);
        else
            roomWalls.put(Directions.South, new Wall("plain wall"));
        if (westElement != null)
            roomWalls.put(Directions.West, westElement);
        else
            roomWalls.put(Directions.West, new Wall("plain wall"));
        if (eastElement != null)
            roomWalls.put(Directions.East, eastElement);
        else
            roomWalls.put(Directions.East, new Wall("plain wall"));
    }

    public Map<Directions, Element> getRoomWalls() {
        return roomWalls;
    }
}
