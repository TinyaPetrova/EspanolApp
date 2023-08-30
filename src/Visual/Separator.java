package Visual;

public enum Separator {
  UPPER_LINE("\u001B[31m╭────────────────────────ᘒ──────────────────────────╮\u001B[0m"),
  DOWN_LINE("\u001B[31m╰────────────────────────ᘒ──────────────────────────╯\u001B[0m");

  private final String separator;

  Separator(String separator) {
    this.separator = separator;
  }

  public String getSeparator() {
    return separator;
  }
}