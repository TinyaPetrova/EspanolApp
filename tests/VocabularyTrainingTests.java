import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;

import app.VocabularyManager;
import app.VocabularyTraining;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * This class contains unit tests for the methods in the VocabularyTraining class
 */
public class VocabularyTrainingTests {

  private VocabularyManager vocabularyManager;
  private VocabularyTraining vocabularyTraining;

  /**
   * Test for the runEnglishToSpanishTraining method
   *
   * In this case, we cannot directly verify console interaction, but we can check that the method
   * completes without errors
   */
  @Test
  public void testRunRussianToSpanishTraining() {
    InputStream originalSystemIn = System.in;
    String input = "spoon\nno\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    try {
      VocabularyManager vocabularyManager = new VocabularyManager();
      VocabularyTraining training = new VocabularyTraining(vocabularyManager);

      assertDoesNotThrow(() -> training.runEnglishToSpanishTraining());
    } finally {
      System.setIn(originalSystemIn);
    }
  }

  /**
   * Test for the runSpanishToEnglishTraining method
   *
   * In this case, we cannot directly verify console interaction, but we can check that the method
   * completes without errors
   */
  @Test
  public void testRunSpanishToEnglishTraining() {
    InputStream originalSystemIn = System.in;
    String input = "cuchara\nno\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    try {
      VocabularyManager vocabularyManager = new VocabularyManager();
      VocabularyTraining training = new VocabularyTraining(vocabularyManager);

      assertDoesNotThrow(() -> training.runSpanishToEnglishTraining());
    } finally {
      System.setIn(originalSystemIn);
    }
  }

  /**
   * Test for continueTraining in case of positive user's input
   */
  @Test
  public void testContinueTrainingWithYes() {
    vocabularyTraining = new VocabularyTraining(vocabularyManager);
    String userInput = "yes";
    System.setIn(new ByteArrayInputStream(userInput.getBytes()));

    assertFalse(vocabularyTraining.continueTraining(new Scanner(System.in)));

    System.setIn(System.in);
  }

  /**
   * Test for continueTraining in case of negative user's input
   */
  @Test
  public void testContinueTrainingWithNo() {
    vocabularyManager = new VocabularyManager();
    VocabularyTraining vocabularyTraining = new VocabularyTraining(vocabularyManager);
    String userInput = "no";
    System.setIn(new ByteArrayInputStream(userInput.getBytes()));

    assertFalse(vocabularyTraining.continueTraining(new Scanner(System.in)));

    System.setIn(System.in);
  }
}
