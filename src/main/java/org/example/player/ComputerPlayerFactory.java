package org.example.player;

public class ComputerPlayerFactory {
  public ComputerPlayer createRandomComputerPlayer(String name) {
    return new RandomComputerPlayer(name);
  }

  public ComputerPlayer createTimeBasedComputerPlayer(String name) {
    return new TimeBaseComputerPlayer(name);
  }

  public ComputerPlayer createNameBasedComputerPlayer(String name) {
    return new NameBasedComputerPlayer(name);
  }
}
