package org.example.player;

import org.example.moveStrategy.RandomMoveStrategy;

public class RandomComputerPlayer implements Player {
  private final String name;
  private final RandomMoveStrategy moveStrategy;

  public RandomComputerPlayer(String name, RandomMoveStrategy moveStrategy) {
    this.name = name;
    this.moveStrategy = moveStrategy;
  }

  @Override
  public String getName() {
    return name;
  }
  @Override
  public String makeMove(Player opponentPlayer) {
    if (moveStrategy != null) {
      return moveStrategy.generateMove(opponentPlayer);
    } else {
      throw new RuntimeException("Move strategy not set for the player.");
    }
  }
}
