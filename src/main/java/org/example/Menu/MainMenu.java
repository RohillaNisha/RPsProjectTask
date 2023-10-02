package org.example.Menu;

import org.example.statistics.GameStatistics;

import java.util.List;
import java.util.Scanner;

public class MainMenu extends Menu {

  private static final Scanner scanner = new Scanner(System.in);
  private final GameStatistics statistics = new GameStatistics();


  private static String playerName = "";

  public MainMenu() {
    super("Main Menu");
    menuOptions =
        List.of(
            new MenuOption(1, "Start a new Game", () -> startGame()),
            new MenuOption(2, "See Game statistics", () -> statistics.displayStatistics()),
            new MenuOption(3, "See Game Rules", () -> gameRules()),
            new MenuOption(4, "SAYONARA!! ", () -> System.exit(0)));
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
}
