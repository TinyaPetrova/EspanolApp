import app.VocabularyComparators;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VocabularyComparatorsTests {

  VocabularyComparators vocabularyComparators;

  /**
   * Test case to verify the functionality of the byRussian comparator
   * It checks if the comparator correctly sorts vocabulary entries by Russian words (keys)
   */
  @Test
  public void testByRussianComparator() {
    Map<String, String> vocabulary = new HashMap<>();
    vocabulary.put("ложка", "cuchara");
    vocabulary.put("мир", "paz");
    vocabulary.put("галстук", "corbata");
    Comparator<Map.Entry<String, String>> russianComparator = VocabularyComparators.byRussian();
    Map<String, String> sortedVocabulary = new HashMap<>(vocabulary);
    sortedVocabulary.entrySet().stream()
        .sorted(russianComparator)
        .collect(
            java.util.stream.Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            )
        );
    Map<String, String> expectedVocabulary = new HashMap<>();
    expectedVocabulary.put("ложка", "cuchara");
    expectedVocabulary.put("мир", "paz");
    expectedVocabulary.put("галстук", "corbata");

    assertEquals(expectedVocabulary, sortedVocabulary);
  }

  /**
   * Test case to verify the functionality of the bySpanish comparator
   * It checks if the comparator correctly sorts vocabulary entries by Spanish words (keys)
   */
  @Test
  public void testBySpanishComparator() {
    Map<String, String> vocabulary = new HashMap<>();
    vocabulary.put("cuchara", "ложка");
    vocabulary.put("paz", "мир");
    vocabulary.put("corbata", "галстук");
    Comparator<Map.Entry<String, String>> spanishComparator = VocabularyComparators.bySpanish();
    Map<String, String> sortedVocabulary = new HashMap<>(vocabulary);
    sortedVocabulary.entrySet().stream()
        .sorted(spanishComparator)
        .collect(
            java.util.stream.Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            )
        );
    Map<String, String> expectedVocabulary = new HashMap<>();
    expectedVocabulary.put("cuchara", "ложка");
    expectedVocabulary.put("paz", "мир");
    expectedVocabulary.put("corbata", "галстук");

    assertEquals(expectedVocabulary, sortedVocabulary);
  }
}

