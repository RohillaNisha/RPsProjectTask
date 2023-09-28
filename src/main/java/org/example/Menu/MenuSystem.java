package org.example.Menu;

public class MenuSystem implements MenuState{

    private static MenuState activeMenu;
    private final static MenuSystem menuSystem = new MenuSystem();

    public MenuSystem() {

        activeMenu = new MainMenu();
    }

    public static MenuSystem getInstance(){
        return menuSystem;
    }

    public static void setState(MenuState selectedMenu){
        activeMenu = selectedMenu;
    }

    public static String getCurrentState(){
        return activeMenu.getClass().getSimpleName();
    }

    @Override
    public void execute() {
        activeMenu.execute();

    }
}
