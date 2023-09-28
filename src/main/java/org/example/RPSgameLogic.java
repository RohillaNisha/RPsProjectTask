package org.example;

import org.example.moveStrategy.HumanPlayerMoveStrategy;
import org.example.moveStrategy.NameBasedMoveStrategy;
import org.example.moveStrategy.RandomMoveStrategy;
import org.example.moveStrategy.TimeBasedMoveStrategy;
import org.example.player.*;

import java.util.Scanner;

public class RPSgameLogic {
    private HumanPlayer humanPlayer;
    private Player computerPlayer;
    private static int selectedComputerPlayerType;
    private String humanMove;
    private String computerMove;
    private int humanScore;
    private int computerScore;
    private int totalWinNeeded;

    public RPSgameLogic(int selectedComputerPlayerType) {
    this.selectedComputerPlayerType = selectedComputerPlayerType;
    }

    public static Player generateComputerPlayer(int value){
       switch(value){
           case 0:
               return new RandomComputerPlayer("Random Beast", new RandomMoveStrategy());
           case 1:
               return new TimeBaseComputerPlayer("Time Master", new TimeBasedMoveStrategy());
           case 2:
               return new NameBasedComputerPlayer("Tactics Master", new NameBasedMoveStrategy());
           default:
               return new RandomComputerPlayer("Random Beast", new RandomMoveStrategy());

       }
    }



    public void play(String playerName){
        humanPlayer = new HumanPlayer(playerName, new HumanPlayerMoveStrategy());
        computerPlayer = generateComputerPlayer(selectedComputerPlayerType);
        System.out.println("GAME STARTED \n ");
        System.out.println("Enter desired number of Wins to declare a Winner: ");
        Scanner scanner = new Scanner(System.in);
        totalWinNeeded = scanner.nextInt();

        while(!isGameOver(totalWinNeeded)){
            String computerMove = computerPlayer.makeMove(humanPlayer);
            System.out.println("OPPONENT HAS MADE ITS MOVE. \n IT'S YOUR TURN NOW!");
            String humanMove = humanPlayer.makeMove(computerPlayer);
            String resultForOneRound = determineRoundWinner(humanMove, computerMove);
            System.out.println("You played: " + humanMove + " \n Computer played: " + computerMove + "\n");
            scoreUpdation(resultForOneRound, totalWinNeeded);
            System.out.println("Current Score - "+ humanPlayer.getName().toUpperCase()+ ": " + humanScore + "     " + computerPlayer.getName().toUpperCase() + ": " + computerScore);

        }

        String gameWinner = determineGameWinner(humanScore, computerScore);
        System.out.println("....GAME OVER...");
        System.out.println(gameWinner + " is the winner! ");


    }

    public static void  getComputerPlayerType(int selectedType){
        selectedComputerPlayerType = selectedType;
    }

    public String determineRoundWinner(String humanMove, String computerMove){
        if (humanMove.equals(computerMove)) {
            System.out.println("It's a tie! ");
            return "TIE";
        } else if (humanMove.equals("rock")) {
            if (computerMove.equals("paper")) {
                System.out.println("Computer wins!");
                 return computerPlayer.getName();
            } else {
                System.out.println("You win!");
                return humanPlayer.getName();
            }
        } else if (humanMove.equals("paper")) {
            if (computerMove.equals("scissors")) {
                System.out.println("Computer wins!");
                return computerPlayer.getName();
            } else {
                System.out.println("You win!");
                return humanPlayer.getName();
            }
        } else {
            // Player chose scissors
            if (computerMove.equals("rock")) {
                System.out.println("Computer wins!");
                return computerPlayer.getName();
            } else {
                System.out.println("You win!");
                return humanPlayer.getName();
            }
        }
    }

    public void scoreUpdation(String roundWinner, int totalWinNeeded){
        if(roundWinner == computerPlayer.getName()){
           if(! isGameOver(totalWinNeeded))
            computerScore++;

        }
        else if(roundWinner == humanPlayer.getName()){
            if(! isGameOver(totalWinNeeded))
            humanScore++;
        }

    }

    public boolean isGameOver (int totalWinNeeded){

            if( computerScore == totalWinNeeded || humanScore == totalWinNeeded){
                return true;
            }
            return false;
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
