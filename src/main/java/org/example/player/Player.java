package org.example.player;

public class Player {
  private String name;
  private int score;
  private int totalRounds;

  public Player(String name) {
    this.name = name;
    this.score = 0;
    this.totalRounds = 0;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getTotalRounds() {
    return totalRounds;
  }

  public void setTotalRounds(int totalRounds) {
    this.totalRounds = totalRounds;
  }
}
