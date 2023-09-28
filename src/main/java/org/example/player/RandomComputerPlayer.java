package org.example.player;

import org.example.moveStrategy.MoveStrategy;

public class RandomComputerPlayer extends Player {
  public RandomComputerPlayer(String name, MoveStrategy<Player> moveStrategy) {
    super(name, moveStrategy);
  }
}
