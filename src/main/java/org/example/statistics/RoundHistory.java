package org.example.statistics;

public class RoundHistory {
  private final String HumanPlayerName;
  private final String humanPlayerMove;
  private final String computerPlayerName;
  private final String computerPlayerMove;
  private final int humanPlayerScore;
  private final int computerPlayerScore;

  public RoundHistory(
      String humanPlayerName,
      String humanPlayerMove,
      String computerPlayerName,
      String computerPlayerMove,
      int humanPlayerScore,
      int computerPlayerScore) {
    HumanPlayerName = humanPlayerName;
    this.humanPlayerMove = humanPlayerMove;
    this.computerPlayerName = computerPlayerName;
    this.computerPlayerMove = computerPlayerMove;
    this.humanPlayerScore = humanPlayerScore;
    this.computerPlayerScore = computerPlayerScore;
  }

  public String getHumanPlayerName() {
    return HumanPlayerName;
  }

  public String getHumanPlayerMove() {
    return humanPlayerMove;
  }

  public String getComputerPlayerName() {
    return computerPlayerName;
  }

  public String getComputerPlayerMove() {
    return computerPlayerMove;
  }

  public int getHumanPlayerScore() {
    return humanPlayerScore;
  }

  public int getComputerPlayerScore() {
    return computerPlayerScore;
  }
}
