package visual;

/**
 * The Separator enum defines various separator strings that can be used to visually separate
 * content in console output
 */
public enum Separator {
  UPPER_LINE("╭────────────────────────ᘒ─────────────────────────╮"),
  DOWN_LINE("╰────────────────────────ᘒ─────────────────────────╯"),
  SIMPLE_LINE("─────────────────────────ᘒ───────────────────────────"),
  LONG_SIMPLE_LINE("───────────────────────────────────────ᘒ─────────────────────────────────────────"),
  DECORATION("❀❀❀❀❀❀❀❀❀❀❀❀");

  private final String separator;

  /**
   * Constructor for Separator enum constant with the specified separator
   *
   * @param separator separator
   */
  Separator(String separator) {
    this.separator = separator;
  }

  /**
   * Getter for separator associated with the enum constant
   *
   * @return separator
   */
  public String getSeparator() {
    return separator;
  }
}