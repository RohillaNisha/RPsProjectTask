package org.example.player;

import org.example.moveStrategy.MoveStrategy;

public class TimeBaseComputerPlayer extends Player {
  public TimeBaseComputerPlayer(String name, MoveStrategy<Player> moveStrategy) {
    super(name, moveStrategy);
  }
}
