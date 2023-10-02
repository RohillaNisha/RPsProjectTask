package org.example.moveStrategy;

import org.example.player.Player;

public class NameBasedMoveStrategy implements PlayerMoveStrategy<Player> {
  @Override
  public String generateMove(Player opponentPlayer) {
    String playerName = opponentPlayer.getName();
    int hash = playerName.hashCode();
    int mappedValue = mapHashToRange(hash);
    return chooseMove(mappedValue);
  }

  private int mapHashToRange(int hash) {
    return Math.floorMod(hash, 3);
  }

  private String chooseMove(int value) {
    switch (value) {
      case 0:
        return "rock";

      case 1:
        return "paper";

      case 2:
        return "scissors";

      default:
        return "rock";
    }
  }
}
