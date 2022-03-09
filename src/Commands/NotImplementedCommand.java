package Commands;

import Components.PlayerController;

public class NotImplementedCommand extends Command {
    public NotImplementedCommand(String commandString) {
        super(commandString);
    }

    @Override
    public String execute(PlayerController playerController) {
        return "Unknown command !";

    }

}
