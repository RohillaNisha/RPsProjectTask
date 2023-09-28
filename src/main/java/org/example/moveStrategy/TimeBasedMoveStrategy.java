package org.example.moveStrategy;

import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import org.example.player.Player;

public class TimeBasedMoveStrategy implements MoveStrategy<Player> {
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
