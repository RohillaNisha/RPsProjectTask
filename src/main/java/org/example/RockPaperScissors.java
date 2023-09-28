package org.example;

import org.example.Menu.MainMenu;
import org.example.Menu.MenuSystem;
import org.example.player.Player;

public class RockPaperScissors {

    public static void main(String[] args) {

        System.out.println("\n \n");
        System.out.println("........ROCK PAPER SCISSORS........ \n \n");
        MainMenu menu = new MainMenu();

        MenuSystem menuSystem = MenuSystem.getInstance();
        while(true){
            menuSystem.execute();
        }



    }
}
