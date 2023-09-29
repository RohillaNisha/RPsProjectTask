package org.example.player;

import org.example.moveStrategy.HumanPlayerMoveStrategy;
import org.example.moveStrategy.PlayerMoveStrategy;

public class HumanPlayer implements Player {
  private final String name;
  private final PlayerMoveStrategy<Player> moveStrategy;

  public HumanPlayer(String name, HumanPlayerMoveStrategy moveStrategy) {
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
