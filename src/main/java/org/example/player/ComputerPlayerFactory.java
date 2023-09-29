package org.example.player;

import org.example.moveStrategy.NameBasedMoveStrategy;
import org.example.moveStrategy.RandomMoveStrategy;
import org.example.moveStrategy.TimeBasedMoveStrategy;

public class ComputerPlayerFactory {
  public Player createRandomComputerPlayer(String name, RandomMoveStrategy moveStrategy) {
    return new RandomComputerPlayer(name, moveStrategy);
  }

  public Player createTimeBasedComputerPlayer(String name, TimeBasedMoveStrategy moveStrategy) {
    return new TimeBasedComputerPlayer(name, moveStrategy);
  }

  public Player createNameBasedComputerPlayer(String name, NameBasedMoveStrategy moveStrategy) {
    return new NameBasedComputerPlayer(name, moveStrategy);
  }
}
