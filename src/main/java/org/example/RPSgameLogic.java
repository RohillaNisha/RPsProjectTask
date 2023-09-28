package org.example;

public class RPSgameLogic {
    private String humanMove;
    private String computerMove;

    public RPSgameLogic(String humanMove, String computerMove) {
        this.humanMove = humanMove;
        this.computerMove = computerMove;
    }

    public String determineRoundWinner(){
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
}
