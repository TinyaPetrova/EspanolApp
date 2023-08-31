package visual;

public enum Separator {
  UPPER_LINE("╭────────────────────────ᘒ──────────────────────────╮"),
  DOWN_LINE("╰────────────────────────ᘒ──────────────────────────╯");

  private final String separator;

  Separator(String separator) {
    this.separator = separator;
  }

  public String getSeparator() {
    return separator;
  }
}