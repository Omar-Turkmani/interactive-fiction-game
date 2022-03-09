import Commands.CommandInvoker;
import Components.Item;
import Components.PlayerController;
import MapCreator.MapCreator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PlayerController playerController = new PlayerController(new Item[0]);
        CommandInvoker inv = new CommandInvoker();
        MapCreator c = new MapCreator();
        c.create();
        playerController.changeRoom(c.getStartingRoom());
        inv.runCommand(playerController);
    }
}
