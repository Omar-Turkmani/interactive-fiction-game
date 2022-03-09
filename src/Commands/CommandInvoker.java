package Commands;

import Components.Item;
import Components.PlayerController;
import MapCreator.MapCreator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class CommandInvoker {
    private boolean isTimeout;

    public CommandInvoker() {
        this.isTimeout = false;
    }

    class Task extends TimerTask {

        Timer timer;
        public Task(Timer timer) {
            this.timer = timer;
        }

        @Override
        public void run() {
            System.out.println("Timeout !!");
            isTimeout = true;
            timer.cancel();
        }

    }

    public void runCommand(PlayerController playerController) throws IOException {
        String s;
        CommandsFactory cFactory = new CommandsFactory();
        Timer timer = new Timer();
        timer.schedule(new Task(timer), 10*60*10 * 1000);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            if (isTimeout) break;
            if (bufferedReader.ready()) {
                s = bufferedReader.readLine();
                if (s.equals("exit")) {
                    System.out.println("Exiting..");
                    System.exit(0);
                    bufferedReader.close();
                    break;
                } else if (s.equals("restart")) {
                    System.out.println("Restarting..");
                    playerController = new PlayerController(new Item[0]);
                    MapCreator c = new MapCreator();
                    c.create();
                    playerController.changeRoom(c.getStartingRoom());
                    System.out.println("New game has been started");
                } else {
                    Command c = cFactory.createCommand(s);
                    String message = c.execute(playerController);
                    System.out.println(message);
                    if (playerController.isWon()) {
                        System.exit(0);
                        bufferedReader.close();
                        break;
                    }
                }
            }
//        }
        }
    }
}
