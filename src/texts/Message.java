package texts;

/**
 * The Message enum contains text messages used for communication and feedback in the application
 */
public enum Message {
  INTRO("•*´¨`*•.¸¸.•*´¨`*HABLAMOS ESPAÑOL•.¸¸..•*´¨`*•.¸¸.•*"),
  CHEERS("Heeey!"),
  GREETING("Bienvenido to the app which can help you to learn spanish words"),
  ERROR("Wrong. Try again!"),
  GREAT("Well done! +1 point"),
  WRONG("Hmm... not exactly. The right answer is: "),
  SCORE_PREFIX("Wow! Here is your total score: ");
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
