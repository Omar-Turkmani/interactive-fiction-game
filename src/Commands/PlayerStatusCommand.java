package Commands;

import Components.PlayerController;

import java.util.Map;

public class PlayerStatusCommand extends Command {

    public PlayerStatusCommand(String commandString) {
        super(commandString);
    }

    @Override
    public String execute(PlayerController playerController) {
        Map<String,String> playerStatus = playerController.getPlayerStatus();
    StringBuilder stringBuilder = new StringBuilder();
    for(Map.Entry entry : playerStatus.entrySet()){
        stringBuilder.append(entry.getKey() + " : " + entry.getValue()+"\n");
    }
    return stringBuilder.toString();
    }

}
