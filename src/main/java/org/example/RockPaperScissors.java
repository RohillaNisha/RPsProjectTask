package org.example;

import org.example.Menu.MenuSystem;
import org.example.Tournament.BinaryTreeTournament;
import org.example.Tournament.Node;
import org.example.moveStrategy.HumanPlayerMoveStrategy;
import org.example.moveStrategy.NameBasedMoveStrategy;
import org.example.moveStrategy.RandomMoveStrategy;
import org.example.moveStrategy.TimeBasedMoveStrategy;
import org.example.player.ComputerPlayerFactory;
import org.example.player.HumanPlayer;
import org.example.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RockPaperScissors {

  public static void main(String[] args) {

    System.out.println("\n \n........ROCK PAPER SCISSORS........ \n \n");

    MenuSystem menuSystem = MenuSystem.getInstance();
    while (true) {
      menuSystem.execute();
    }

  }
}
