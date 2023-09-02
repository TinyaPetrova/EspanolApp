package app;

public class AppRunner {

  public static void main(String[] args) {
    MenuManager menuManager = new MenuManager("res/RandomFacts.txt");
    menuManager.runMainMenu();
  }
}