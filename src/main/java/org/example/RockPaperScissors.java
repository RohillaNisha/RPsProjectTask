package org.example;

import org.example.Menu.MainMenu;
import org.example.Menu.MenuSystem;

public class RockPaperScissors {

    public static void main(String[] args) {

        System.out.println("\n \n");
        System.out.println("........ROCK PAPER SCISSORS........ \n \n");

        MenuSystem menuSystem = MenuSystem.getInstance();
        while(true){
            menuSystem.execute();
        }



    }
}
