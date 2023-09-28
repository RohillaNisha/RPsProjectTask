package org.example.player;

import org.example.moveStrategy.MoveStrategy;

public class NameBasedComputerPlayer extends Player {
  public NameBasedComputerPlayer(String name, MoveStrategy<Player> moveStrategy) {
    super(name, moveStrategy);
  }
}
