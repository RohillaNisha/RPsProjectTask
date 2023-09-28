package org.example.player;

import org.example.moveStrategy.MoveStrategy;

public class Player {
  private String name;
  private int score;
  private int totalRounds;

  private MoveStrategy<Player> moveStrategy;

  public Player(String name, MoveStrategy<Player> moveStrategy) {
    this.name = name;
    this.moveStrategy = moveStrategy;
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

  public MoveStrategy<Player> getMoveStrategy() {
    return moveStrategy;
  }

  public void setMoveStrategy(MoveStrategy<Player> moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  public String makeMove(Player player) {
    return moveStrategy.generateMove(player);
  }
}
