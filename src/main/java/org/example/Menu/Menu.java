package org.example.Menu;

import java.util.List;
import java.util.Scanner;

public class Menu implements MenuState{

    protected String menuName;
    protected List<MenuOption> menuOptions;

    public Menu(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public void execute() {
        displayMenuOptions();
        Scanner input = new Scanner(System.in);
        int optionSelected = input.nextInt();
        for(MenuOption menuOption: menuOptions){
            if(menuOption.getOptionNumber() == optionSelected){
                menuOption.run();
            }
        }

    }

    private void displayMenuOptions() {
        String menuText = menuName;
        for(MenuOption menuOption: menuOptions){
            menuText = menuText.concat(
                    "\n"+ menuOption.getOptionNumber() +
                            ".) " + menuOption.getText()
            );
        }
        System.out.println(menuText);
    }
}
