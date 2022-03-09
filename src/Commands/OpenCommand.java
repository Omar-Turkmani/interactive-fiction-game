package Commands;

import Components.*;

import java.util.Map;

public class OpenCommand extends Command {
    public OpenCommand(String commandString) {
        super(commandString);
    }

    @Override
    String execute(PlayerController playerController) {
        Validation v = validate(playerController);
        if (v.isValid) {
            Element e = playerController.getFacingElement();
            Door door = (Door) e;
            door.openDoor();
            return "Door is open now";
        } else
            return v.message;
    }

    @Override
    Validation validate(PlayerController playerController) {
        Element e = playerController.getFacingElement();
        if (e instanceof Door) {
            LockableElement l = (LockableElement) e;
            if (l.isLocked())
                return new Validation(false, l.getClass().getSimpleName() + " is locked, " + l.getLockKey().getName() + " key is needed to unlock");
            else return new Validation(true, null);
        }
        return new Validation(false, "You are not facing a door");
    }
}
