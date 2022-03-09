package Commands;

import Components.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class TradeCommand extends Command {
    public TradeCommand(String commandString) {
        super(commandString);
    }

    @Override
    String execute(PlayerController playerController) throws IOException {
        Validation v = validate(playerController);
        if (v.isValid) {
            Master master = (Master) playerController.getFacingElement();
            printResult("You are in trade mode..");
            printResult(listItems(master));
            String s;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                if (bufferedReader.ready()) {
                    s = bufferedReader.readLine();
                    switch (s.split(" ")[0]) {
                        case "buy":
                            printResult(buyItem(playerController, master, s));
                            break;
                        case "sell":
                            printResult(sellItem(playerController, master, s));
                            break;
                        case "list":
                            printResult(listItems(master));
                            break;
                        case "finish":
                            return "Exiting trade mode..";
                        default:
                            printResult("Invalid arguments, valid arguments are (buy <item name>, sell <item name>, list , finish trade)");
                            break;
                    }
                }
            }
        } else return v.message;

    }

    @Override
    Validation validate(PlayerController playerController) {
        Element e = playerController.getFacingElement();
        if (e instanceof Master) {
            return new Validation(true, null);
        } else return new Validation(false, "You are not facing a master");
    }

    private String buyItem(PlayerController playerController, Master master, String commandString) {
        Validation v = validateBuyAndSellCommand(playerController, master, commandString);
        if (v.isValid) {
            String[] args = commandString.split(" ");
            String itemName = args[1];
            Item item = master.getMasterItems().get(itemName);
            if (!playerController.canBuyItem(item)) return "Return when you have enough gold";
            playerController.buyItem(item, master);
            return item.getClass().getSimpleName() + " " + item.getName() + " has been added to your items";
        } else return v.message;
    }

    private String sellItem(PlayerController playerController, Master master, String commandString) {
        Validation v = validateBuyAndSellCommand(playerController, master, commandString);
        if (v.isValid) {
            String[] args = commandString.split(" ");
            String itemName = args[1];
            Item item = playerController.getItemByName(itemName);
            playerController.sellItem(item, master);
            return item.getClass().getSimpleName() + " " + item.getName() + " has been sold successfully";
        } else return v.message;
    }

    private Validation validateBuyAndSellCommand(PlayerController playerController, Master master, String commandString) {
        String[] args = commandString.split(" ");
        if (args.length <= 1) return new Validation(false, "Needs argument, valid arguments are master items names");
        String itemName = args[1];
        if (args[0].equals("buy") && !master.hasItem(itemName))
            return new Validation(false, "Invalid argument, master doesn't have this item");
        else if (args[0].equals("sell") && !playerController.hasItem(itemName))
            return new Validation(false, "Invalid argument, master doesn't have this item");
        else return new Validation(true, "");
    }

    private String listItems(Master master) {
        Map<String, Item> items = master.getMasterItems();
        if (items != null) {
            StringBuilder message = new StringBuilder();
            message.append("Master have the following items:\n");
            for (Map.Entry<String, Item> entry : items.entrySet()) {
                message.append("Type: " + entry.getValue().getClass().getSimpleName() + "\tName: " + entry.getKey() + "\tPrice: " + entry.getValue().getPrice() + "\n");
            }
            return message.toString();
        } else return "Master items list is empty";
    }

    private void printResult(String result) {
        System.out.println(result);
    }
}
