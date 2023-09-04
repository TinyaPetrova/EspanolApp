package app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import texts.Message;
import visual.Colors;
import visual.Emoji;

public class VocabularyTraining {

  private final VocabularyManager vocabularyManager;

  public VocabularyTraining(VocabularyManager vocabularyManager) {
    this.vocabularyManager = vocabularyManager;
  }

  private static final Set<String> POSITIVE_ANSWERS = new HashSet<>();
  private static final Set<String> NEGATIVE_ANSWERS = new HashSet<>();

  static {
    POSITIVE_ANSWERS.add("да");
    POSITIVE_ANSWERS.add("д");
    POSITIVE_ANSWERS.add("yes");
    POSITIVE_ANSWERS.add("y");

    NEGATIVE_ANSWERS.add("нет");
    NEGATIVE_ANSWERS.add("н");
    NEGATIVE_ANSWERS.add("no");
    NEGATIVE_ANSWERS.add("n");
  }

  public void runRussianToSpanishTraining() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String russianWord = vocabularyManager.getRandomWord(VocabularyManager.WordType.RUSSIAN);
      String correctSpanishTranslation = vocabularyManager.getTranslation(russianWord, VocabularyManager.WordType.RUSSIAN);
      System.out.println(Colors.PURPLE.getColor() + "Переведи слово " + Colors.RESET.getColor() + "'" + russianWord + "'" + Colors.PURPLE.getColor() + " на испанский: " + Colors.RESET.getColor());
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

  public void runSpanishToRussianTraining() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String spanishWord = vocabularyManager.getRandomWord(VocabularyManager.WordType.SPANISH);
      String correctRussianTranslation = vocabularyManager.getTranslation(spanishWord, VocabularyManager.WordType.SPANISH);
      System.out.println(Colors.PURPLE.getColor() + "Переведи слово " + Colors.RESET.getColor() + "'" + spanishWord + "'" + Colors.PURPLE.getColor() + " на русский: " + Colors.RESET.getColor());
      String userTranslation = scanner.nextLine().trim().toLowerCase();
      if (userTranslation.equals(correctRussianTranslation)) {
        System.out.println(Emoji.DONE.getEmoji() + Colors.PURPLE.getColor() + " " + Message.GREAT.getMessage() + Colors.RESET.getColor());
        vocabularyManager.incrementScore();
      } else {
        System.out.println(Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " " + Message.WRONG.getMessage() + correctRussianTranslation + Colors.RESET.getColor());
      }
      if (!continueTraining(scanner)) {
        break;
      }
    }
  }

  private boolean continueTraining(Scanner scanner) {
    System.out.println("Продолжим тренировку? [Да/Нет]");
    String continueTraining = scanner.nextLine().toLowerCase();
    return POSITIVE_ANSWERS.contains(continueTraining) && NEGATIVE_ANSWERS.contains(continueTraining);
  }
}
