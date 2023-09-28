package org.example.moveStrategy;

import org.example.player.Player;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy<Player>{
    private final String[] moves = {"rock", "paper", "scissors"};
    private final Random random = new Random();
    @Override
    public String generateMove(Player player) {
        int randomIndex = random.nextInt(3);
        return moves[randomIndex];
    }
}
