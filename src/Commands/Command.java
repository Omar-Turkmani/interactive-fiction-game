package Commands;

import Components.PlayerController;

import java.io.IOException;

public abstract class Command {
    protected String commandString;

    public Command(String commandString) {
        this.commandString = commandString;
    }

    protected class Validation{
        protected boolean isValid;
        protected String message;

        protected Validation(boolean isValid, String message) {
            this.isValid = isValid;
            this.message = message;
        }
    }
    String execute(PlayerController playerController) throws IOException {
        return null;
    }
    Validation validate(PlayerController playerController){
        return null;
    }
}
