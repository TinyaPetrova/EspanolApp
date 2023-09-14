package app;

import java.util.Comparator;
import java.util.Map;

/**
 * The VocabularyComparators class provides static methods to create comparators for sorting
 * vocabulary entries based on Russian and Spanish words.
 */
public class VocabularyComparators {

  /**
   * Method creates a comparator for sorting vocabulary entries by Russian words (keys)
   *
   * @return comparator that compares entries based on their Russian words
   */
  public static Comparator<Map.Entry<String, String>> byRussian() {
    return Comparator.comparing(entry -> entry.getKey());
  }

  /**
   * Method creates a comparator for sorting vocabulary entries by Spanish words (values).
   *
   * @return comparator that compares entries based on their Spanish words.
   */
  public static Comparator<Map.Entry<String, String>> bySpanish() {
    return Comparator.comparing(entry -> entry.getValue());
  }
}

