package Visual;

public enum Emoji {
  CHEERS("👋\uD83D\uDE3A"),
  GREAT("\uD83D\uDE3B✊"),
  DONE("\uD83D\uDE38✅"),
  WRONG("\uD83D\uDE3F❌"),
  GO_AHEAD("💪\uD83D\uDE3B"),
  WRITE_DOWN("✏️\uD83D\uDE3A"),
  ONE("1️⃣"),
  TWO("2️⃣"),
  THREE("3️⃣"),
  FOUR("4️⃣"),
  FIVE("5️⃣");

  private final String emoji;

  Emoji(String emoji) {
    this.emoji = emoji;
  }

  public String getEmoji() {
    return emoji;
  }
}
