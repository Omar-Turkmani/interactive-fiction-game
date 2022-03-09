package Commands;

import Components.*;

public class LookCommand extends Command {

    public LookCommand(String commandString) {
        super(commandString);
    }

    @Override
    public String execute(PlayerController playerController) {
        Validation v = validate(playerController);
        if (v.isValid) {
            Element e = playerController.getFacingElement();
            if (Mirror.class.equals(e.getClass())) {
                return "You See a silhouette of you";
            }
            return e.getClass().getSimpleName();
        } else {
            return v.message;
        }

    }

    @Override
    Validation validate(PlayerController playerController) {
        if (playerController.isCurrentRoomLightsOn()) {
            return new Validation(true, null);
        } else {
            return new Validation(false, "Dark");
        }
    }

}
