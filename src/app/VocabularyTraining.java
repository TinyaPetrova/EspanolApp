package app;

import app.VocabularyManager.WordType;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import texts.Message;
import visual.Colors;
import visual.Emoji;

/**
 * The VocabularyTraining class manages vocabulary training sessions. It provides methods for
 * practicing translation between English and Spanish words
 */
public class VocabularyTraining {

  private final VocabularyManager vocabularyManager;

  /**
   * Constructor for VocabularyTraining with a reference to a VocabularyManager
   *
   * @param vocabularyManager VocabularyManager instance used for vocabulary access
   */
  public VocabularyTraining(VocabularyManager vocabularyManager) {
    this.vocabularyManager = vocabularyManager;
  }

  /**
   * Static sets of positive and negative answers commonly used for user's input confirmation
   */
  private static final Set<String> POSITIVE_ANSWERS = new HashSet<>();
  private static final Set<String> NEGATIVE_ANSWERS = new HashSet<>();

  static {
    POSITIVE_ANSWERS.add("si");
    POSITIVE_ANSWERS.add("s");
    POSITIVE_ANSWERS.add("yes");
    POSITIVE_ANSWERS.add("y");

    NEGATIVE_ANSWERS.add("no");
    NEGATIVE_ANSWERS.add("n");
  }

  /**
   * Method runs a training session where the user translates English words to Spanish
   */
  public void runEnglishToSpanishTraining() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String englishWord = vocabularyManager.getRandomWord(WordType.ENGLISH);
      String correctSpanishTranslation = vocabularyManager.getTranslation(englishWord, WordType.ENGLISH);
      System.out.println(Colors.PURPLE.getColor() + "Translate the word " + Colors.RESET.getColor() + "'" + englishWord + "'" + Colors.PURPLE.getColor() + " to Spanish: " + Colors.RESET.getColor());
      String userTranslation = scanner.nextLine().trim().toLowerCase();
      if (userTranslation.equals(correctSpanishTranslation)) {
        System.out.println(Emoji.DONE.getEmoji() + Colors.PURPLE.getColor() + " " + Message.GREAT.getMessage() + Colors.RESET.getColor());
        vocabularyManager.incrementScore();
      } else {
        System.out.println(Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " " + Message.WRONG.getMessage() + correctSpanishTranslation + Colors.RESET.getColor());
      }
      if (!continueTraining(scanner)) {
        break;
      }
    }
  }

  /**
   * Method runs a training session where the user translates Spanish words to English
   */
  public void runSpanishToEnglishTraining() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String spanishWord = vocabularyManager.getRandomWord(WordType.SPANISH);
      String correctEnglishTranslation = vocabularyManager.getTranslation(spanishWord, VocabularyManager.WordType.SPANISH);
      System.out.println(Colors.PURPLE.getColor() + "Translate the word " + Colors.RESET.getColor() + "'" + spanishWord + "'" + Colors.PURPLE.getColor() + " to English: " + Colors.RESET.getColor());
      String userTranslation = scanner.nextLine().trim().toLowerCase();
      if (userTranslation.equals(correctEnglishTranslation)) {
        System.out.println(Emoji.DONE.getEmoji() + Colors.PURPLE.getColor() + " " + Message.GREAT.getMessage() + Colors.RESET.getColor());
        vocabularyManager.incrementScore();
      } else {
        System.out.println(Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " " + Message.WRONG.getMessage() + correctEnglishTranslation + Colors.RESET.getColor());
      }
      if (!continueTraining(scanner)) {
        break;
      }
    }
  }

  /**
   * Method for asking the user if they want to continue the vocabulary training
   *
   * @param scanner scanner for user's input
   * @return true if the user wants to continue training, otherwise false
   */
  public boolean continueTraining(Scanner scanner) {
    System.out.println("Let's continue? [Yes/No]");
    String continueTraining = scanner.nextLine().toLowerCase();
    return POSITIVE_ANSWERS.contains(continueTraining) || NEGATIVE_ANSWERS.contains(continueTraining);
  }
}
