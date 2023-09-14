package visual;

public enum Separator {
  UPPER_LINE("╭────────────────────────ᘒ─────────────────────────╮"),
  DOWN_LINE("╰────────────────────────ᘒ─────────────────────────╯"),
  SIMPLE_LINE("─────────────────────────ᘒ───────────────────────────"),
  LONG_SIMPLE_LINE("───────────────────────────────────────ᘒ─────────────────────────────────────────"),
  DECORATION("❀❀❀❀❀❀❀❀❀❀❀❀");

  private final String separator;

  Separator(String separator) {
    this.separator = separator;
  }

  public String getSeparator() {
    return separator;
  }
}