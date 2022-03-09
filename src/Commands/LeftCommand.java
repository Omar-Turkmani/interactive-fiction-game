package Commands;

import Components.Directions;
import Components.PlayerController;

public class LeftCommand extends Command {

    public LeftCommand(String commandString) {
        super(commandString);
    }

    @Override
    public String execute(PlayerController playerController) {
        Directions dir = playerController.turnLeft();
        return "You are now directed to the " + dir.toString();
    }
}
