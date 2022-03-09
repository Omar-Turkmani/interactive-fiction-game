package Commands;

public class CommandsFactory {
    public Command createCommand(String command) {
        switch (command.split(" ")[0]) {
            case "forward":
                return new ForwardCommand(command);
            case "backward":
                return new BackwardCommand(command);
            case "left":
                return new LeftCommand(command);
            case "right":
                return new RightCommand(command);
            case "status":
                return new PlayerStatusCommand(command);
            case "check":
                return new CheckCommand(command);
            case "look":
                return new LookCommand(command);
            case "open":
                return new OpenCommand(command);
            case "swLights":
                return new SwitchLightsCommand(command);
            case "use":
                return new UseItemCommand(command);
            case "trade":
                return new TradeCommand(command);
            default:
                return new NotImplementedCommand(command);
        }
    }
}

