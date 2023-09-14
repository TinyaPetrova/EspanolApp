package visual;

/**
 * The Emoji enum defines Unicode emoji characters for use in console output to add visual elements
 */
public enum Emoji {
  CHEERS("👋\uD83D\uDE3A"),
  DONE("\uD83D\uDE38✅"),
  WRONG("\uD83D\uDE3F❌"),
  IDEA("\uD83D\uDCA1"),
  GO_AHEAD("💪\uD83D\uDE3B"),
  WRITE_DOWN("✏️\uD83D\uDE3A"),
  ONE("1️⃣"),
  TWO("2️⃣"),
  THREE("3️⃣"),
  FOUR("4️⃣"),
  FIVE("5️⃣"),
  SIX("6️⃣"),
  SEVEN("7️⃣"),
  EIGHT("8️⃣");

  private final String emoji;

  /**
   * Constructor for Emoji enum constant with the specified Unicode emoji characters
   *
   * @param emoji Unicode emoji character
   */
  Emoji(String emoji) {
    this.emoji = emoji;
  }

  /**
   * Getter for Unicode emoji characters associated with the enum constant
   *
   * @return Unicode emoji character
   */
  public String getEmoji() {
    return emoji;
  }
}
