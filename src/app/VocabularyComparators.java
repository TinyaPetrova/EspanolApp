package app;

import java.util.Comparator;
import java.util.Map;

public class VocabularyComparators {
  public static Comparator<Map.Entry<String, String>> byRussian() {
    return Comparator.comparing(entry -> entry.getKey());
  }

  public static Comparator<Map.Entry<String, String>> bySpanish() {
    return Comparator.comparing(entry -> entry.getValue());
  }
}

