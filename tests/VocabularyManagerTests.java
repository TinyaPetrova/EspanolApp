import static org.junit.jupiter.api.Assertions.assertEquals;

import app.VocabularyManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class VocabularyManagerTests {

  /**
   * Test incrementing the score
   */
  @Test
  public void testIncrementScore() {
    VocabularyManager vocabularyManager = new VocabularyManager();
    int initialScore = vocabularyManager.score;
    vocabularyManager.incrementScore();
    int updatedScore = vocabularyManager.score;

    assertEquals(initialScore + 1, updatedScore);
  }

  /**
   * Test loading the score from a file
   */
  @Test
  public void testLoadScoreFromFile() {
    VocabularyManager vocabularyManager = new VocabularyManager();
    InputStream mockInput = new ByteArrayInputStream("5".getBytes());
    System.setIn(mockInput);
    vocabularyManager.loadScoreFromFile();
    int loadedScore = vocabularyManager.score;

    assertEquals(1, loadedScore);

    System.setIn(System.in);
  }

  /**
   * Test loading the score from a file with invalid data
   */
  @Test
  public void testLoadScoreFromFileInvalidData() {
    VocabularyManager vocabularyManager = new VocabularyManager();
    InputStream mockInput = new ByteArrayInputStream("-1".getBytes());
    System.setIn(mockInput);
    vocabularyManager.loadScoreFromFile();
    int loadedScore = vocabularyManager.score;

    assertEquals(1, loadedScore);

    System.setIn(System.in);
  }
}
