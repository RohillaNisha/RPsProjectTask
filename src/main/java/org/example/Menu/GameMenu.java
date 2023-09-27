package org.example.Menu;


import org.example.player.*;

import java.util.List;

public class GameMenu extends Menu{

    private String playerName;
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;
    public GameMenu(String playerName) {
        super("Game Menu");
        this.playerName = playerName;
        this.humanPlayer = new HumanPlayer(playerName);
        System.out.println("Hello, " + playerName + " ! Choose Your Opponent ");
        menuOptions = List.of(
                new MenuOption(1, " Random Move Maker ", () -> {
                    computerPlayer = new RandomComputerPlayer("Random Beast");
                    playGame();
                }),
                new MenuOption(2, " Tactical Move Maker", () -> new NameBasedComputerPlayer("Trickster")),
                new MenuOption(3, " Time Based Move Maker", () -> new TimeBaseComputerPlayer("Time Runner")),
                new MenuOption(4, "Go back to Main Menu ", () -> MenuSystem.setState(new MainMenu()))

        );
    }

    private void playGame(){
        System.out.println("GAME STARTED AGAINST RANDOM BEAST");
        String computerMove = computerPlayer.makeMove();
        System.out.println("RANDOM BEAST HAS MADE ITS MOVE. \n IT'S YOUR TURN NOW!");
        String humanMove = humanPlayer.makeMove();
        if(humanMove.equals(computerMove)){
            System.out.println("Its a Tie! ");
        }
        else if (humanMove.equals("rock")) {
            if(computerMove.equals("paper")){
                System.out.println("You loose! ");
            } else if(computerMove.equals("scissors")){
                System.out.println("You win! ");
            }

        }
        else if(humanMove.equals("paper")){
            if(computerMove.equals("scissors")){
                System.out.println("You loose! ");
            } else if(computerMove.equals("rock")){
                System.out.println("You Win! ");
            }
        }
        else if(humanMove.equals("scissors")){
            if(computerMove.equals("rock")){
                System.out.println("You loose! ");
            }
            else if(computerMove.equals("paper")){
                System.out.println("You Win! ");
            }
        }
    }
}
