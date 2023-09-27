package org.example.player;

import java.util.Scanner;

public class HumanPlayer extends Player {
  public HumanPlayer(String name) {
    super(name);
  }

  public String makeMove() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please choose your move (rock, paper, or scissors):");

    String move = scanner.next().toLowerCase();

    while (!(move.equals("rock") || move.equals("paper") || move.equals("scissors"))) {
      System.out.println("Please choose a valid move (rock, paper, or scissors):");
      move = scanner.next().toLowerCase();
    }
    return move;
  }
}
