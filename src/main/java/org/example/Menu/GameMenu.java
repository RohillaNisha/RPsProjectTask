package org.example.Menu;


import org.example.RPSgameLogic;
import org.example.player.*;

import java.util.List;

public class GameMenu extends Menu{

    private String playerName;

    public GameMenu(String playerName) {
        super("Game Menu");
        this.playerName = playerName;
        System.out.println("Hello, " + playerName + " ! Choose Your Opponent ");
        menuOptions = List.of(
                new MenuOption(1, " Random Move Maker ", () -> startRandomGame(playerName) ),
                new MenuOption(2, " Tactical Move Maker", () -> new NameBasedComputerPlayer("Trickster")),
                new MenuOption(3, " Time Based Move Maker", () -> new TimeBaseComputerPlayer("Time Runner")),
                new MenuOption(4, "Go back to Main Menu ", () -> MenuSystem.setState(new MainMenu()))

        );
    }

    private void startRandomGame( String playerName) {
        RPSgameLogic game = new RPSgameLogic(new RandomComputerPlayer("Random Beast") );
        game.playGame(playerName);
    }


}
