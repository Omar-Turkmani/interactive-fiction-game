package Commands;

import Components.*;

import java.util.Map;

public class CheckCommand extends Command {

    public CheckCommand(String commandString) {
        super(commandString);
    }

    @Override
    public String execute(PlayerController playerController) {
        Validation v = validate(playerController,commandString);
        if (v.isValid) {
            Element e = playerController.getFacingElement();
            if (Mirror.class.equals(e.getClass()) || Plate.class.equals(e.getClass())) {
                ContainerElements c = (ContainerElements) e;
                if (c.hasKey()) {
                    String keyName = playerController.acquireKey(c);
                    return "“The " + keyName + " key was acquired";
                } else
                    return "Nothing here";
            } else if (Cabinet.class.equals(e.getClass())) {
                Map<String, Item> items = playerController.acquireCabinetItems((Cabinet) e);
                if (items != null) {
                    StringBuilder message = new StringBuilder();
                    message.append("You have acquired the following items: \n");
                    for (Map.Entry<String, Item> entry : items.entrySet()) {
                        message.append(entry.getValue().getClass().getSimpleName() + " " + entry.getKey() + "\n");
                    }
                    return message.toString();
                } else return "Nothing here";
            } else if (Door.class.equals(e.getClass())) {
                Door d = (Door) e;
                if (d.isOpen())
                    return "Door is open";
                else return "Door is closed";
            }
            return "Nothing here";
        } else {
            return v.message;
        }

    }

    @Override
    Validation validate(PlayerController playerController) {
        Element e = playerController.getFacingElement();
        if (Mirror.class.equals(e.getClass()) || Plate.class.equals(e.getClass())) {
            return new Validation(true, null);
        } else if (Cabinet.class.equals(e.getClass()) || Door.class.equals(e.getClass())) {
            LockableElement l = (LockableElement) e;
            if (l.isLocked())
                return new Validation(false, l.getClass().getSimpleName() + " is locked, " + l.getLockKey().getName() + " key is needed to unlock");
            else return new Validation(true, null);
        }
        return new Validation(false, "Nothing here");
    }

    private Validation validate(PlayerController playerController, String command){
        Element e = playerController.getFacingElement();
        String[] args = command.split(" ");
        if (args.length <=1 )
            return new Validation(false, "Needs argument, valid arguments are(Mirror, Cabinet, Door, Plate)");
        if (!command.split(" ")[1].equals(e.getClass().getSimpleName()))
            return new Validation(false, "Invalid argument, you are facing a "+e.getClass().getSimpleName());
        return validate(playerController);
    }

}
