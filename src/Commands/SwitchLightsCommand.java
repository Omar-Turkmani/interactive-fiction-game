package Commands;

import Components.Door;
import Components.PlayerController;
import Components.Room;

public class SwitchLightsCommand extends Command {

    public SwitchLightsCommand(String commandString) {
        super(commandString);
    }

    @Override
    public String execute(PlayerController playerController) {
        Validation v = validate(playerController);
        if (v.isValid) {
            Room room = playerController.getCurrentRoom();
            room.switchLights();
            if (room.isLightingOn()) return "Lights switch ON";
            else return "Lights switch OFF";
        } else {
            return v.message;
        }
    }

    @Override
    Validation validate(PlayerController playerController) {
        Room room = playerController.getCurrentRoom();
        if (room.isHasLighting()) {
            return new Validation(true, null);
        } else {
            return new Validation(false, "This room hasn't lights !");
        }
    }
}
