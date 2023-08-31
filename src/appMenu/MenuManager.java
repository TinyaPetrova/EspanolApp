package appMenu;

import texts.MenuText;
import visual.Colors;
import visual.Emoji;
import texts.Message;
import java.util.Scanner;
import visual.Separator;

public class MenuManager {

  private VocabularyManager vocabularyManager = new VocabularyManager();
  private Scanner scanner;

  public MenuManager() {
    vocabularyManager = new VocabularyManager();
    scanner = new Scanner(System.in);
  }

  public void runMainMenu() {
    System.out.println(Emoji.CHEERS.getEmoji() + " Привет!");
    System.out.println(Message.GREETING.getMessage());
    System.out.println(
        Colors.YELLOW.getColor() + Separator.UPPER_LINE.getSeparator() + Colors.RESET.getColor());
    System.out.println(
        Colors.YELLOW.getColor() + Message.INTRO.getMessage() + Colors.RESET.getColor());
    System.out.println(
        Colors.YELLOW.getColor() + Separator.DOWN_LINE.getSeparator() + Colors.RESET.getColor());

    while (true) {
      System.out.println(Emoji.ONE.getEmoji() + " " + MenuText.EXERCISES.getMenuText());
      System.out.println(Emoji.TWO.getEmoji() + " " + MenuText.VOCABULARY.getMenuText());
      System.out.println(
          Emoji.THREE.getEmoji() + " " + MenuText.VOCAB_TRAININGS.getMenuText());
      System.out.println(Emoji.FOUR.getEmoji() + " " + MenuText.QUIZ.getMenuText());
      System.out.println(Emoji.FIVE.getEmoji() + " " + MenuText.ACHIEVEMENTS.getMenuText());
      System.out.println(Emoji.SIX.getEmoji() + " " + MenuText.RANDOM_FACTS.getMenuText());
      System.out.println(Emoji.SEVEN.getEmoji() + " " + MenuText.BYE.getMenuText());
      System.out.println(
          Colors.YELLOW.getColor() + MenuText.CHOICE.getMenuText() + Colors.RESET.getColor());

      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          // упражнения
          break;
        case 2:
          // словарик
          runVocabularySubMenu();
          break;
        case 3:
          // словарные тренировки
          break;
        case 4:
          // тесты
          break;
        case 5:
          // достижения
          break;
        case 6:
          // факты об Испании
          break;
        case 7:
          System.exit(0);
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
      System.out.println(MenuText.CHOICE.getMenuText());
      System.out.println(Emoji.ONE.getEmoji() + " " + MenuText.ADD_WORD.getMenuText());
      System.out.println(Emoji.TWO.getEmoji() + " " + MenuText.DELETE_WORD.getMenuText());
      System.out.println(Emoji.THREE.getEmoji() + " " + MenuText.CHANGE_WORD.getMenuText());
      System.out.println(Emoji.FOUR.getEmoji() + " " + MenuText.SHOW_VOCAB.getMenuText());
      System.out.println(Emoji.FIVE.getEmoji() + " " + MenuText.BACK_TO_MENU.getMenuText());
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
          return;
        default:
          System.out.println(Emoji.WRONG.getEmoji() + Message.ERROR);
          break;
      }
    }
  }
}

