import Bot.Bot;
import Database.Database;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        try {
            //Database.connect();
            //start Bot.Bot
            Bot.start();
        } catch (LoginException |InterruptedException e) {
            e.printStackTrace();
        }

        //wait for console commands
        Scanner userInput = new Scanner(System.in);
        while(true) {
            System.out.println("Ready for a new command sir.");

            String input = userInput.nextLine();
            if(input.toLowerCase().equals("shutdown")){
                Bot.shutdown();
                Database.closeCon();
                System.exit(0);
            }
            else{
                System.out.println("No command found!");
            }
        }
    }
}
