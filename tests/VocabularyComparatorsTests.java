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
   * Test case to verify the functionality of the byEnglish comparator
   * It checks if the comparator correctly sorts vocabulary entries by English words (keys)
   */
  @Test
  public void testByEnglishComparator() {
    Map<String, String> vocabulary = new HashMap<>();
    vocabulary.put("spoon", "cuchara");
    vocabulary.put("peace", "paz");
    vocabulary.put("tie", "corbata");
    Comparator<Map.Entry<String, String>> englishComparator = VocabularyComparators.byEnglish();
    Map<String, String> sortedVocabulary = new HashMap<>(vocabulary);
    sortedVocabulary.entrySet().stream()
        .sorted(englishComparator)
        .collect(
            java.util.stream.Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            )
        );
    Map<String, String> expectedVocabulary = new HashMap<>();
    expectedVocabulary.put("spoon", "cuchara");
    expectedVocabulary.put("peace", "paz");
    expectedVocabulary.put("tie", "corbata");

    assertEquals(expectedVocabulary, sortedVocabulary);
  }

  /**
   * Test case to verify the functionality of the bySpanish comparator
   * It checks if the comparator correctly sorts vocabulary entries by Spanish words (keys)
   */
  @Test
  public void testBySpanishComparator() {
    Map<String, String> vocabulary = new HashMap<>();
    vocabulary.put("cuchara", "spoon");
    vocabulary.put("paz", "peace");
    vocabulary.put("corbata", "tie");
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
    expectedVocabulary.put("cuchara", "spoon");
    expectedVocabulary.put("paz", "peace");
    expectedVocabulary.put("corbata", "tie");

    assertEquals(expectedVocabulary, sortedVocabulary);
  }
}

