package Commands;

import Components.Directions;
import Components.PlayerController;

public class RightCommand extends Command {

    public RightCommand(String commandString) {
        super(commandString);
    }

    @Override
    public String execute(PlayerController playerController) {
        Directions dir = playerController.turnRight();
        return "You are now directed to the " + dir.toString();
    }

}
