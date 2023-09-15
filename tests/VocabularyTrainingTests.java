import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import app.VocabularyManager;
import app.VocabularyTraining;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class VocabularyTrainingTests {

  /**
   * Test for continueTraining in case of positive user's input
   */
  @Test
  public void testContinueTrainingWithYes() {
    app.VocabularyManager vocabularyManager = new app.VocabularyManager();
    VocabularyTraining vocabularyTraining = new VocabularyTraining(vocabularyManager);
    String userInput = "да";
    System.setIn(new ByteArrayInputStream(userInput.getBytes()));

    assertFalse(vocabularyTraining.continueTraining(new Scanner(System.in)));

    System.setIn(System.in);
  }

  /**
   * Test for continueTraining in case of negative user's input
   */
  @Test
  public void testContinueTrainingWithNo() {
    app.VocabularyManager vocabularyManager = new app.VocabularyManager();
    VocabularyTraining vocabularyTraining = new VocabularyTraining(vocabularyManager);
    String userInput = "нет";
    System.setIn(new ByteArrayInputStream(userInput.getBytes()));

    assertFalse(vocabularyTraining.continueTraining(new Scanner(System.in)));

    System.setIn(System.in);
  }
}
