package visual;

public enum Colors {
  RED("\u001B[31m"),
  YELLOW("\u001B[33m"),
  PURPLE("\u001B[35m"),
  RESET("\u001B[0m");

  private final String color;

  Colors(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }
}
