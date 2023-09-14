package texts;

/**
 * The Message enum contains text messages used for communication and feedback in the application
 */
public enum Message {
  INTRO("•*´¨`*•.¸¸.•*´¨`*HABLAMOS ESPAÑOL•.¸¸..•*´¨`*•.¸¸.•*"),
  CHEERS("Привет!"),
  GREETING("Bienvenido в приложение для изучения испанских слов"),
  ERROR("Неверный выбор. Попробуй снова!"),
  GREAT("Отличная работа! +1 балл"),
  WRONG("Не совсем верно! Правильный ответ: "),
  SCORE_PREFIX("Молодец! Вот твои баллы: ");
  private final String message;

  /**
   * Constructor for Message enum constant with the specified message text
   *
   * @param message text of the message
   */
  Message(String message) {
    this.message = message;
  }

  /**
   * Getter for the message text associated with the enum constant
   *
   * @return message text
   */
  public String getMessage() {
    return message;
  }
}
