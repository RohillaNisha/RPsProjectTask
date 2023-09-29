package org.example;

import java.util.Scanner;
import org.example.moveStrategy.HumanPlayerMoveStrategy;
import org.example.moveStrategy.NameBasedMoveStrategy;
import org.example.moveStrategy.RandomMoveStrategy;
import org.example.moveStrategy.TimeBasedMoveStrategy;
import org.example.player.ComputerPlayerFactory;
import org.example.player.HumanPlayer;
import org.example.player.Player;

public class RPSgameLogic {
  private static int selectedComputerPlayerType;
  private HumanPlayer humanPlayer;
  private Player computerPlayer;
  private int humanScore;
  private int computerScore;

  public RPSgameLogic(int selectedComputerPlayerType) {
    RPSgameLogic.selectedComputerPlayerType = selectedComputerPlayerType;
  }

  private static Player generateComputerPlayer(int selectedComputerPlayerType) {
    ComputerPlayerFactory factory = new ComputerPlayerFactory();
    return switch (selectedComputerPlayerType) {
      case 0 -> factory.createRandomComputerPlayer("Random Beast", new RandomMoveStrategy());
      case 1 -> factory.createTimeBasedComputerPlayer("Time Master", new TimeBasedMoveStrategy());
      case 2 -> factory.createNameBasedComputerPlayer(
          "Tactics Master", new NameBasedMoveStrategy());
      default -> factory.createRandomComputerPlayer("Random Beast", new RandomMoveStrategy());
    };
  }

  public void play(String playerName) {
    humanPlayer = new HumanPlayer(playerName, new HumanPlayerMoveStrategy());
    computerPlayer = generateComputerPlayer(selectedComputerPlayerType);

    int totalWinNeeded = getDesiredWinCount();

    while (!isGameOver(totalWinNeeded)) {
      playOneRound();
      displayCurrentScores();
    }

    String gameWinner = determineGameWinner();
    displayGameResult(gameWinner);
  }

  private void playOneRound() {
    String computerMove = computerPlayer.makeMove(humanPlayer);
    String humanMove = humanPlayer.makeMove(computerPlayer);
    String resultForOneRound = determineRoundWinner(humanMove, computerMove);
    updateScore(resultForOneRound);

    System.out.println(humanPlayer.getName() + " played: " + humanMove);
    System.out.println(computerPlayer.getName() + " played: " + computerMove);
    System.out.println("Result: " + resultForOneRound);
    System.out.println();
  }

  private int getDesiredWinCount() {
    System.out.println("Enter desired number of Wins to declare a Winner: ");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  private void displayCurrentScores() {
    System.out.println(
        "Current Score - "
            + humanPlayer.getName().toUpperCase()
            + ": "
            + humanScore
            + "     "
            + computerPlayer.getName().toUpperCase()
            + ": "
            + computerScore
            + "\n");
  }

  private void displayGameResult(String gameWinner) {
    System.out.println("....GAME OVER...");
    System.out.println(gameWinner + " is the winner!");
  }

  public String determineRoundWinner(String humanMove, String computerMove) {
    if (humanMove.equals(computerMove)) {
      return "TIE";
    } else if ((humanMove.equals("rock") && computerMove.equals("scissors"))
        || (humanMove.equals("paper") && computerMove.equals("rock"))
        || (humanMove.equals("scissors") && computerMove.equals("paper"))) {
      System.out.println("You win!");
      return humanPlayer.getName();
    } else {
      System.out.println(computerPlayer.getName() + " wins!");
      return computerPlayer.getName();
    }
  }

  public void updateScore(String roundWinner) {
    if (roundWinner.equals(computerPlayer.getName())) {
      computerScore++;
    } else if (roundWinner.equals(humanPlayer.getName())) {
      humanScore++;
    }
  }

  public boolean isGameOver(int totalWinNeeded) {
    return computerScore == totalWinNeeded || humanScore == totalWinNeeded;
  }

  public String determineGameWinner() {
    if (humanScore > computerScore) {
      return humanPlayer.getName();
    } else if (computerScore > humanScore) {
      return computerPlayer.getName();
    } else {
      return "TIE";
    }
  }
}
