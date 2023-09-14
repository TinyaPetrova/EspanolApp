package visual;

/**
 * The Colors enum defines ANSI codes for text colors to be used in console output
 */
public enum Colors {
  RED("\u001B[31m"),
  YELLOW("\u001B[33m"),
  PURPLE("\u001B[35m"),
  RESET("\u001B[0m");

  private final String color;

  /**
   * Constructor for Colors enum constant with the specified ANSI code for text color
   *
   * @param color ANSI code for the text color
   */
  Colors(String color) {
    this.color = color;
  }

  /**
   * Getter for ANSI code for the text color associated with the enum constant
   *
   * @return ANSI escape code for the text color
   */
  public String getColor() {
    return color;
  }
}
