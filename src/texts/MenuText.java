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

