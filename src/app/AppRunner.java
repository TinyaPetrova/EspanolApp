package app;

/**
 * The AppRunner class is the entry point of the application
 * It initializes the MenuManager and runs the main menu of the Spanish learning application
 */
public class AppRunner {

  public static void main(String[] args) {
    MenuManager menuManager = new MenuManager("res/RandomFacts.txt");
    menuManager.runMainMenu();
  }
}