package org.example.player;

import java.util.Random;


public class RandomComputerPlayer extends Player implements ComputerPlayer {
  private Random random;
  public RandomComputerPlayer(String name) {
    super(name);
    random = new Random();
  }

  @Override
  public String makeMove() {
    int randomNumber = random.nextInt(3);

    String[] moves = { "rock", "paper", "scissors"};
    String randomMove = moves[randomNumber];
    return randomMove;
  }
}
