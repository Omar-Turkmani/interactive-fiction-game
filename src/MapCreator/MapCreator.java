package MapCreator;

import Components.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapCreator {
    private Room startingRoom;

    public Room getStartingRoom() {
        return startingRoom;
    }

    public void create(){
        //Rooms
        Room startingRoom = new Room("starting_room",true,true);
        Room room1 = new Room("room1",false,true);
        Room room2 = new Room("room2",false,true);
        Room room3 = new Room("room3",false,false);
        Room room4 = new Room("winning_room",true,true);
        //Keys
        Key d2Key = new Key("d2key",10);
        Key d3Key = new Key("d3key",10);
        Key d4Key = new Key("d4key",10);
        Key c2Key = new Key("c2key",25);
        //Flashlights
        Flashlight flashlight = new Flashlight(75);
        //Cabinets
        Item[] ch1Items = new Item[1];
        ch1Items[0] = d2Key;
        Cabinet ch1 = new Cabinet(false,"Cabinet1",null,ch1Items);

        Item[] ch2Items = new Item[1];
        ch2Items[0] = d4Key;
        Cabinet ch2 = new Cabinet(true,"Cabinet2",c2Key,ch2Items);
        //Mirrors
        Mirror m1 = new Mirror("m1",null);
        Mirror m2 = new Mirror("m2",null);
        //Plates
        Plate p1 = new Plate("p1",d3Key);
        //Masters
        Item[] masterArray= new Item[2];
        masterArray[0]= c2Key;
        masterArray[1]= flashlight;
        Master master = new Master("Master",masterArray);
        //Doors
        Door d1 = new Door(false,startingRoom,room1,false,"d1",null);
        Door d2 = new Door(true,room1,room2,false,"d2",d2Key);
        Door d3 = new Door(true,room1,room3,true,"d3",d3Key);
        Door d4 = new Door(true,room1,room4,false,"d4",d4Key);
        //Room walls
        RoomWalls startingRoomWalls = new RoomWalls(null,d1,ch1,null);
        RoomWalls room1Walls = new RoomWalls(d1,d4,d2,d3);
        RoomWalls room2Walls = new RoomWalls(m1,p1, master,d2);
        RoomWalls room3Walls = new RoomWalls(m2,ch2,d3,null);
        RoomWalls room4Walls = new RoomWalls(null,d4,null,null);
        startingRoom.setWalls(startingRoomWalls);
        room1.setWalls(room1Walls);
        room2.setWalls(room2Walls);
        room3.setWalls(room3Walls);
        room4.setWalls(room4Walls);
        this.startingRoom = startingRoom;
    }

    private Map<String ,Item> createItemsMap(List<Item> l){
        Map<String, Item> items = new HashMap<String, Item>();
        for (Item i : l) {
            items.put(i.getName(), i);
        }
        return items;
    }
}
