package Visual;

public enum Message {
  CHEERS("Привет!"),
  GREETING("Bienvenido в приложение для изучения испанского языка"),
  GREAT("Отличная работа!"),
  DONE("Готово!"),
  WRONG("Не совсем верно!"),
  GO_AHEAD("Вперёд!"),
  WRITE_DOWN("Записываем!");

  private final String message;

  Message(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
