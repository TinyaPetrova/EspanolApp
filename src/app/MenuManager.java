package app;

import texts.MenuText;
import visual.Colors;
import visual.Emoji;
import texts.Message;
import java.util.Scanner;
import visual.Separator;

public class MenuManager {

  private VocabularyManager vocabularyManager;
  private InterestingFacts interestingFacts;
  private VocabularyTraining vocabularyTraining;
  private Scanner scanner;

  public MenuManager(String factsFilePath) {
    vocabularyManager = new VocabularyManager();
    interestingFacts = new InterestingFacts(factsFilePath);
    vocabularyTraining = new VocabularyTraining(vocabularyManager);
    scanner = new Scanner(System.in);
  }

  public void runMainMenu() {
    System.out.println(Emoji.CHEERS.getEmoji() + " " + Message.CHEERS.getMessage());
    System.out.println(Message.GREETING.getMessage());
    System.out.println(
        Colors.YELLOW.getColor() + Separator.UPPER_LINE.getSeparator() + Colors.RESET.getColor());
    System.out.println(
        Colors.YELLOW.getColor() + Message.INTRO.getMessage() + Colors.RESET.getColor());
    System.out.println(
        Colors.YELLOW.getColor() + Separator.DOWN_LINE.getSeparator() + Colors.RESET.getColor());

    while (true) {
      System.out.println(Emoji.ONE.getEmoji() + " " + MenuText.QUIZ.getMenuText());
      System.out.println(Emoji.TWO.getEmoji() + " " + MenuText.VOCABULARY.getMenuText());
      System.out.println(
          Emoji.THREE.getEmoji() + " " + MenuText.VOCAB_TRAININGS.getMenuText());
      System.out.println(Emoji.FOUR.getEmoji() + " " + MenuText.ACHIEVEMENTS.getMenuText());
      System.out.println(Emoji.FIVE.getEmoji() + " " + MenuText.RANDOM_FACTS.getMenuText());
      System.out.println(Emoji.SIX.getEmoji() + " " + MenuText.BYE.getMenuText());
      System.out.println(
          Colors.YELLOW.getColor() + MenuText.CHOICE.getMenuText() + Colors.RESET.getColor());

      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          // тесты
          break;
        case 2:
          // словарик
          runVocabularySubMenu();
          break;
        case 3:
          // словарные тренировки
          runVocabularyTrainingSubMenu();
          break;
        case 4:
          // достижения
          vocabularyManager.loadScoreFromFile();
          break;
        case 5:
          // факты об Испании
          runRandomFactsSubMenu();
          break;
        case 6:
          System.exit(0);
          System.out.println(Emoji.CHEERS.getEmoji() + Colors.YELLOW.getColor() + MenuText.BYE.getMenuText() + Colors.RESET.getColor());
        default:
          System.out.println(
              Colors.RED.getColor() + Message.ERROR.getMessage() + Colors.RESET.getColor());
          break;
      }
    }
  }

  private void runVocabularySubMenu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(
        Colors.YELLOW.getColor() + Separator.UPPER_LINE.getSeparator() + Colors.RESET.getColor());
    System.out.println(
        Emoji.WRITE_DOWN.getEmoji() + "Здесь хранятся записанные тобой слова с переводом!");
    System.out.println(
        Colors.YELLOW.getColor() + Separator.DOWN_LINE.getSeparator() + Colors.RESET.getColor());

    while (true) {
      System.out.println(Emoji.ONE.getEmoji() + " " + MenuText.ADD_WORD.getMenuText());
      System.out.println(Emoji.TWO.getEmoji() + " " + MenuText.DELETE_WORD.getMenuText());
      System.out.println(Emoji.THREE.getEmoji() + " " + MenuText.CHANGE_WORD.getMenuText());
      System.out.println(Emoji.FOUR.getEmoji() + " " + MenuText.SHOW_VOCAB.getMenuText());
      System.out.println(Emoji.FIVE.getEmoji() + " " + MenuText.RU_SORTING.getMenuText());
      System.out.println(Emoji.SIX.getEmoji() + " " + MenuText.ESP_SORTING.getMenuText());
      System.out.println(Emoji.SEVEN.getEmoji() + " " + MenuText.OPEN_FILE.getMenuText());
      System.out.println(Emoji.EIGHT.getEmoji() + " " + MenuText.BACK_TO_MENU.getMenuText());
      System.out.println(
          Colors.YELLOW.getColor() + MenuText.CHOICE.getMenuText() + Colors.RESET.getColor());
      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          vocabularyManager.addWordToVocabulary(
              scanner);
          break;
        case 2:
          vocabularyManager.removeWordFromVocabulary(
              scanner);
          break;
        case 3:
          vocabularyManager.replaceWordInVocabulary(
              scanner);
          break;
        case 4:
          vocabularyManager.printVocabulary();
          break;
        case 5:
          vocabularyManager.saveToFileByRussian();
          break;
        case 6:
          vocabularyManager.saveToFileBySpanish();
          break;
        case 7:
          vocabularyManager.openVocabulary();
          break;
        case 8:
          System.out.println(Colors.YELLOW.getColor() + Separator.SIMPLE_LINE.getSeparator()
              + Colors.RESET.getColor());
          return;
        default:
          System.out.println(
              Emoji.WRONG.getEmoji() + Colors.RED.getColor() + Message.ERROR.getMessage()
                  + Colors.RESET.getColor());
          break;
      }
    }
  }

  private void runRandomFactsSubMenu() {
    scanner = new Scanner(System.in);
    System.out.println(
        Colors.YELLOW.getColor() + Separator.UPPER_LINE.getSeparator() + Colors.RESET.getColor());
    System.out.println(
        Emoji.IDEA.getEmoji() + " Держи любопытный факт об Испании - у нас их много!");
    System.out.println(
        Colors.YELLOW.getColor() + Separator.DOWN_LINE.getSeparator() + Colors.RESET.getColor());

    while (true) {
      System.out.println(Emoji.ONE.getEmoji() + " " + MenuText.GET_FACT.getMenuText());
      System.out.println(Emoji.TWO.getEmoji() + " " + MenuText.BACK_TO_MENU.getMenuText());
      System.out.println(
          Colors.YELLOW.getColor() + MenuText.CHOICE.getMenuText() + Colors.RESET.getColor());
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          String randomFact = interestingFacts.getRandomFact();
          System.out.println(Colors.YELLOW.getColor() + Separator.LONG_SIMPLE_LINE.getSeparator()
              + Colors.RESET.getColor());
          System.out.println(randomFact);
          System.out.println(Colors.YELLOW.getColor() + Separator.LONG_SIMPLE_LINE.getSeparator()
              + Colors.RESET.getColor());
          break;
        case 2:
          System.out.println(Colors.YELLOW.getColor() + Separator.SIMPLE_LINE.getSeparator()
              + Colors.RESET.getColor());
          return;
        default:
          System.out.println(
              Emoji.WRONG.getEmoji() + " " + Colors.RED.getColor() + Message.ERROR.getMessage()
                  + Colors.RESET.getColor());
          break;
      }
    }
  }

  private void runVocabularyTrainingSubMenu() {
    scanner = new Scanner(System.in);
    System.out.println(
        Colors.YELLOW.getColor() + Separator.UPPER_LINE.getSeparator() + Colors.RESET.getColor());
    System.out.println(Emoji.GO_AHEAD.getEmoji() + " Давай проверим твои знания слов из словарика!");
    System.out.println(
        Colors.YELLOW.getColor() + Separator.DOWN_LINE.getSeparator() + Colors.RESET.getColor());

    while (true) {
      System.out.println(
          Emoji.ONE.getEmoji() + " " + MenuText.SPANISH_TO_RUSSIAN_TRAINING.getMenuText());
      System.out.println(
          Emoji.TWO.getEmoji() + " " + MenuText.RUSSIAN_TO_SPANISH_TRAINING.getMenuText());
      System.out.println(Emoji.THREE.getEmoji() + " " + MenuText.BACK_TO_MENU.getMenuText());
      System.out.println(
          Colors.YELLOW.getColor() + MenuText.CHOICE.getMenuText() + Colors.RESET.getColor());
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          vocabularyTraining.runSpanishToRussianTraining();
          break;
        case 2:
          vocabularyTraining.runRussianToSpanishTraining();
          break;
        case 3:
          System.out.println(Colors.YELLOW.getColor() + Separator.SIMPLE_LINE.getSeparator()
              + Colors.RESET.getColor());
          return;
        default:
          System.out.println(
              Emoji.WRONG.getEmoji() + " " + Colors.RED.getColor() + Message.ERROR.getMessage()
                  + Colors.RESET.getColor());
          break;
      }
    }
  }
}
