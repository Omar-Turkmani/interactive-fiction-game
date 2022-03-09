package Commands;

import Components.*;

public class UseItemCommand extends Command {
    public UseItemCommand(String commandString) {
        super(commandString);
    }

    @Override
    String execute(PlayerController playerController) {
        Validation v = validate(playerController, commandString);
        if (v.isValid) {
            String[] args = commandString.split(" ");
            if (args.length >= 3 && args[args.length-1].equals("Key")) return useKey(playerController, args[1]);
            if (args.length == 2 && args[1].equals("Flashlight")) return useFlashlight(playerController, args[1]);
            return "";
        } else return v.message;
    }

    @Override
    Validation validate(PlayerController playerController) {
        Element e = playerController.getFacingElement();
        if (!(e instanceof LockableElement))
            return new Validation(false, "You can't use key for facing element");
        return new Validation(true, "");

    }

    private Validation validate(PlayerController playerController, String command) {
        String[] args = command.split(" ");
        if (args.length <= 1 || (args.length == 2 && !args[1].equals("Flashlight")) || (args.length >= 3 && !args[args.length-1].equals("Key")))
            return new Validation(false, "Invalid argument, valid arguments are(Flashlight, <key name> Key)");
        if (args.length >= 3 && args[args.length-1].equals("Key"))
            return validate(playerController);
        return new Validation(true, "");
    }

    private String useKey(PlayerController playerController, String keyName) {
        Key k = (Key) playerController.getItemByName(keyName);
        if (k != null) {
            LockableElement l = (LockableElement) playerController.getFacingElement();
            if (l.getLockKey().equals(k)) {
                if (l.isLocked()){
                    l.unlock(k);
                    return l.getClass().getSimpleName() +" has unlocked";
                }
                else{
                    l.lock(k);
                    return l.getClass().getSimpleName() +" has locked";
                }
            } else return "This is irrelevant key";
        } else return "You don't have the required key";
    }

    private String useFlashlight(PlayerController playerController, String flashlightName) {
        Flashlight f = (Flashlight) playerController.getItemByName(flashlightName);
        if (f != null) {
            f.switchFlash();
            if (f.isFlashOn()) return "Flashlight is on now";
            else return "Flashlight is off now";
        } else return "You don't have a flashlight";
    }

}

