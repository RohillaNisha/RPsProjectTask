package org.example.player;

import org.example.moveStrategy.PlayerMoveStrategy;
import org.example.moveStrategy.TimeBasedMoveStrategy;

public class TimeBasedComputerPlayer implements Player {
  private final String name;
  private final PlayerMoveStrategy<Player> moveStrategy;
  public TimeBasedComputerPlayer(String name, TimeBasedMoveStrategy moveStrategy) {
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
