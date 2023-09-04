package texts;

public enum MenuText {
  CHOICE("Выбери действие: "),
  EXERCISES("Упражнения: грамматика и лексика"),
  VOCABULARY("Мой словарик"),
  VOCAB_TRAININGS("Словарные тренировки"),
  QUIZ("Тесты"),
  ACHIEVEMENTS("Мои достижения"),
  RANDOM_FACTS("Хочу узнать что-нибудь интересное об Испании!"),
  ADD_WORD("Добавить слово"),
  DELETE_WORD("Удалить слово"),
  CHANGE_WORD("Заменить слово"),
  SHOW_VOCAB("Показать словарик"),
  ESP_SORTING("Включить алфавитный порядок в файле по испанским словам"),
  RU_SORTING("Включить алфавитный порядок в файле по русским словам"),
  OPEN_FILE("Открыть файл со словариком"),
  GET_FACT("Узнать случайный факт"),
  SPANISH_TO_RUSSIAN_TRAINING("Хочу проверить испано-русские пары слов"),
  RUSSIAN_TO_SPANISH_TRAINING("Хочу проверить русско-испанские пары слов"),
  BACK_TO_MENU("Вернуться в меню"),
  BYE("Пока!");

  private final String menuText;

  MenuText(String menuText) {
    this.menuText = menuText;
  }

  public String getMenuText() {
    return menuText;
  }
}

