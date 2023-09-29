package org.example.moveStrategy;

import org.example.player.Player;

import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

public class TimeBasedMoveStrategy implements PlayerMoveStrategy<Player> {
  @Override
  public String generateMove(Player player) {
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);

    long seed = hour * 3600000 + minute * 60000 + second * 1000;
    Random random = new Random(seed);
    int randomMove = random.nextInt(3);
    return chooseMove(randomMove);
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
