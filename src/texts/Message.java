package texts;

public enum Message {
  INTRO("•*´¨`*•.¸¸..•*´¨`*HABLAMOS ESPAÑOL•.¸¸..•*´¨`*•.¸¸.•*"),
  CHEERS("Привет!"),
  GREETING("Bienvenido в приложение для изучения испанского языка"),
  ERROR("Неверный выбор. Попробуй снова!"),
  GREAT("Отличная работа!"),
  WRONG("Не совсем верно!"),
  GO_AHEAD("Вперёд!");

  private final String message;

  Message(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
