package texts;

/**
 * The MenuText enum contains text messages for various menu options in the application
 */
public enum MenuText {
  CHOICE("Choose the option: "),
  VOCABULARY("My vocabulary"),
  VOCAB_TRAININGS("Vocabulary training"),
  ACHIEVEMENTS("My achievements"),
  RANDOM_FACTS("Wanna get to know something new & cool about Spain!"),
  ADD_WORD("Add a word"),
  DELETE_WORD("Delete a word"),
  CHANGE_WORD("Change a word"),
  SHOW_VOCAB("Show me the last updates"),
  ESP_SORTING("Enable alphabetical order in the file by Spanish words"),
  RU_SORTING("Enable alphabetical order in the file by English words"),
  OPEN_FILE("Open my vocabulary file"),
  GET_FACT("Get some random fact"),
  SPANISH_TO_RUSSIAN_TRAINING("Wanna translate from English to Spanish"),
  RUSSIAN_TO_SPANISH_TRAINING("Wanna translate from Spanish to English"),
  BACK_TO_MENU("Back to the menu"),
  BYE("Bye!");

  private final String menuText;

  /**
   * Constructor for MenuText enum constant with the specified menu text
   *
   * @param menuText text associated with the menu option
   */
  MenuText(String menuText) {
    this.menuText = menuText;
  }

  /**
   * Getter for the menu text associated with the enum constant
   *
   * @return The menu text.
   */
  public String getMenuText() {
    return menuText;
  }
}

