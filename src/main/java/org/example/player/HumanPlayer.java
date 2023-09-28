package org.example.player;

import org.example.moveStrategy.MoveStrategy;

public class HumanPlayer extends Player {
  public HumanPlayer(String name, MoveStrategy<Player> moveStrategy) {
    super(name, moveStrategy);
  }
}
