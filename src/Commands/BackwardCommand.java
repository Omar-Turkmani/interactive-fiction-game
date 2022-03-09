package Commands;

import Components.*;

public class BackwardCommand extends Command {

    public BackwardCommand(String commandString) {
        super(commandString);
    }

    @Override
    public String execute(PlayerController playerController) {
        Validation v = validate(playerController);
        if (v.isValid) {
            Door door = (Door) playerController.getOppositeElement();
            if (door.isLocked()) return "door is locked";
            else {
                Room neighboringRoom =  door.getNeighboringRoom(playerController.getCurrentRoom());
                playerController.changeRoom(neighboringRoom);
                if (neighboringRoom.getName().equals("winning_room")){
                    playerController.setWon(true);
                    return "You are in " + neighboringRoom.getName() + " now\n Congrats you have won";
                }
                return "You are in " + neighboringRoom.getName() + " now";
            }
        } else {
            return v.message;
        }
    }

    @Override
    public Validation validate(PlayerController playerController) {
        Element e = playerController.getOppositeElement();
        if (e instanceof Door) {
            return new Validation(true, null);
        } else {
            return new Validation(false, "You are not facing a door");
        }
    }
}