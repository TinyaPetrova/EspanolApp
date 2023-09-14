package texts;

/**
 * The MenuText enum contains text messages for various menu options in the application
 */
public enum MenuText {
  CHOICE("Выбери действие: "),
  VOCABULARY("Мой словарик"),
  VOCAB_TRAININGS("Словарные тренировки"),
  ACHIEVEMENTS("Мои достижения"),
  RANDOM_FACTS("Хочу узнать что-нибудь интересное об Испании!"),
  ADD_WORD("Добавить слово"),
  DELETE_WORD("Удалить слово"),
  CHANGE_WORD("Заменить слово"),
  SHOW_VOCAB("Показать последние изменения"),
  ESP_SORTING("Включить алфавитный порядок в файле по испанским словам"),
  RU_SORTING("Включить алфавитный порядок в файле по русским словам"),
  OPEN_FILE("Открыть файл со словариком"),
  GET_FACT("Узнать случайный факт"),
  SPANISH_TO_RUSSIAN_TRAINING("Хочу перевести с испанского на русский"),
  RUSSIAN_TO_SPANISH_TRAINING("Хочу перевести с русского на испанский"),
  BACK_TO_MENU("Вернуться в меню"),
  BYE("Пока!");

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

