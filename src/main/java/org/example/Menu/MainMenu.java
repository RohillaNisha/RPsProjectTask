package org.example.Menu;

import org.example.Tournament.BinaryTreeTournament;
import org.example.Tournament.Node;
import org.example.moveStrategy.HumanPlayerMoveStrategy;
import org.example.moveStrategy.NameBasedMoveStrategy;
import org.example.moveStrategy.RandomMoveStrategy;
import org.example.moveStrategy.TimeBasedMoveStrategy;
import org.example.player.ComputerPlayerFactory;
import org.example.player.HumanPlayer;
import org.example.player.Player;
import org.example.statistics.GameStatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu extends Menu {

  private static final Scanner scanner = new Scanner(System.in);
  private static final GameStatistics statistics = new GameStatistics();


  private static String playerName = "";

  public MainMenu() {
    super("Main Menu");
    menuOptions =
        List.of(
            new MenuOption(1, "Start a new Game", () -> startGame()),
            new MenuOption(2, "See Game statistics", () -> statistics.displayStatistics()),
            new MenuOption(3, "See Game Rules", () -> gameRules()),
            new MenuOption(4, "SAYONARA!! ", () -> System.exit(0)),
            new MenuOption(5, "Start a tournament", () -> startTournament()));

  }



  private void gameRules() {
    System.out.println("***********************************************");
    System.out.println(" 1. Rock wins against scissors.");
    System.out.println(" 2. Scissors wins against paper.");
    System.out.println(" 3. Paper wins against rock.");
    System.out.println("*********************************************** \n");
    System.out.println(
        " Note:  If both players throw the same hand signal, it is considered a tie, and play resumes until there is a clear winner.\n");
  }

  public void startGame() {
    while (playerName.isEmpty()) {
      System.out.println("Enter Your Name: ");
      playerName = scanner.nextLine();
    }

    MenuSystem.setState(new GameMenu(playerName, statistics));
  }

  public void startTournament(){

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter you name.");
    String humanPlayerName = scanner.nextLine();

    List<Player> players = new ArrayList<>();
    players.add(new HumanPlayer(humanPlayerName, new HumanPlayerMoveStrategy()));
    players.add(new ComputerPlayerFactory().createRandomComputerPlayer("Random Beast", new RandomMoveStrategy()));
    players.add(new ComputerPlayerFactory().createTimeBasedComputerPlayer("Time Master", new TimeBasedMoveStrategy()));
    players.add(new ComputerPlayerFactory().createNameBasedComputerPlayer("Tactics Master", new NameBasedMoveStrategy()));

    Node tournamentTree = BinaryTreeTournament.createTournamentTree(players);

    BinaryTreeTournament.inOrderTransversal(tournamentTree);
    Player winner = BinaryTreeTournament.runGame(tournamentTree);
    System.out.println("Tournament Winner: " + winner.getName());
  }
}
