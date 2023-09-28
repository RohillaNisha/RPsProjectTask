package org.example.player;

import org.example.moveStrategy.MoveStrategy;

public class ComputerPlayerFactory {
  public Player createRandomComputerPlayer(String name, MoveStrategy<Player> moveStrategy) {
    return new RandomComputerPlayer(name, moveStrategy);
  }

  public Player createTimeBasedComputerPlayer(String name, MoveStrategy<Player> moveStrategy) {
    return new TimeBaseComputerPlayer(name, moveStrategy);
  }

  public Player createNameBasedComputerPlayer(String name, MoveStrategy<Player> moveStrategy) {
    return new NameBasedComputerPlayer(name, moveStrategy);
  }
}
