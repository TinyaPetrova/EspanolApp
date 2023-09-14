package texts;

public enum Message {
  INTRO("•*´¨`*•.¸¸.•*´¨`*HABLAMOS ESPAÑOL•.¸¸..•*´¨`*•.¸¸.•*"),
  CHEERS("Привет!"),
  GREETING("Bienvenido в приложение для изучения испанских слов"),
  ERROR("Неверный выбор. Попробуй снова!"),
  GREAT("Отличная работа! +1 балл"),
  WRONG("Не совсем верно! Правильный ответ: "),
  SCORE_PREFIX("Молодец! Вот твои баллы: ");
  private final String message;

  Message(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
