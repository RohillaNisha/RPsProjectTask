package org.example;

import org.example.player.ComputerPlayer;
import org.example.player.HumanPlayer;
import org.example.player.RandomComputerPlayer;

public class RPSgameLogic {
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;
    private String humanMove;
    private String computerMove;
    private int humanScore;
    private int computerScore;

    public RPSgameLogic(ComputerPlayer computerPlayer) {
        this.computerPlayer = computerPlayer;
        this.humanScore = 0;
        this.computerScore = 0;
    }

    public void initializeGame(){
        humanScore = 0;
        computerScore = 0;
    }

    public void playGame(String playerName){
        humanPlayer = new HumanPlayer(playerName);
        System.out.println("GAME STARTED \n ");
        String computerMove = computerPlayer.makeMove();
        System.out.println("OPPONENT HAS MADE ITS MOVE. \n IT'S YOUR TURN NOW!");
        String humanMove = humanPlayer.makeMove();
        String result = determineRoundWinner(humanMove, computerMove);


    }

    public String determineRoundWinner(String humanMove, String computerMove){
        if (humanMove.equals(computerMove)) {
            System.out.println("It's a tie! ");
            return "TIE";
        } else if (humanMove.equals("rock")) {
            if (computerMove.equals("paper")) {
                System.out.println("Computer wins!");
                 return "COMPUTER";
            } else {
                System.out.println("You win!");
                return "HUMAN";
            }
        } else if (humanMove.equals("paper")) {
            if (computerMove.equals("scissors")) {
                System.out.println("Computer wins!");
                return "COMPUTER";
            } else {
                System.out.println("You win!");
                return "HUMAN";
            }
        } else {
            // Player chose scissors
            if (computerMove.equals("rock")) {
                System.out.println("Computer wins!");
                return "COMPUTER";
            } else {
                System.out.println("You win!");
                return "HUMAN";
            }
        }
    }

    public void scoreUpdation(String roundWinner){

    }

    public boolean isGameOver (int gameType){
        if(gameType == 3){
            if( computerScore == 3 || humanScore == 3){
                return true;
            }
        }
        else if(gameType == 5){
            if(computerScore == 5 || humanScore == 5){
                return true;
            }
        } return false;
    }

    public String determineGameWinner(int humanScore, int computerScore){
        if(humanScore > computerScore){
            return "YOU";
        } else if (computerScore > humanScore) {
            return "COMPUTER";
        }
        else if( computerScore == humanScore){
            return "TIE";
        }
        return null;
    }
}
