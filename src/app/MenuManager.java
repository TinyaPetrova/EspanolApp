package app;

import texts.MenuText;
import visual.Colors;
import visual.Emoji;
import texts.Message;
import java.util.Scanner;
import visual.Separator;

/**
 * The MenuManager class manages the main menu and submenus of the Spanish learning application
 * It provides options to access vocabulary, vocabulary training, achievements, and random facts about Spain
 * Users can navigate through these options and interact with the application's features
 */
public class MenuManager {

  private VocabularyManager vocabularyManager;
  private InterestingFacts interestingFacts;
  private VocabularyTraining vocabularyTraining;
  private Scanner scanner;

  /**
   * Constructor for MenuManager with the specified facts file path
   *
   * @param factsFilePath the path to the file containing interesting facts about Spain
   */
  public MenuManager(String factsFilePath) {
    vocabularyManager = new VocabularyManager();
    interestingFacts = new InterestingFacts(factsFilePath);
    vocabularyTraining = new VocabularyTraining(vocabularyManager);
    scanner = new Scanner(System.in);
  }

  /**
   * Method runs the main menu of the application
   * Users can choose options to access different features of the application
   */
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
      System.out.println(Emoji.ONE.getEmoji() + " " + MenuText.VOCABULARY.getMenuText());
      System.out.println(
          Emoji.TWO.getEmoji() + " " + MenuText.VOCAB_TRAININGS.getMenuText());
      System.out.println(Emoji.THREE.getEmoji() + " " + MenuText.ACHIEVEMENTS.getMenuText());
      System.out.println(Emoji.FOUR.getEmoji() + " " + MenuText.RANDOM_FACTS.getMenuText());
      System.out.println(Emoji.FIVE.getEmoji() + " " + MenuText.BYE.getMenuText());
      System.out.println(
          Colors.YELLOW.getColor() + MenuText.CHOICE.getMenuText() + Colors.RESET.getColor());

      if (scanner.hasNextInt()) {
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= 5) {
          switch (choice) {
            case 1:
              // Vocabulary
              runVocabularySubMenu();
              break;
            case 2:
              // Vocabulary training
              runVocabularyTrainingSubMenu();
              break;
            case 3:
              // Achievements
              vocabularyManager.loadScoreFromFile();
              break;
            case 4:
              // Facts about Spain
              runRandomFactsSubMenu();
              break;
            case 5:
              // Exit
              System.out.println(
                  Emoji.CHEERS.getEmoji() + Colors.YELLOW.getColor() + " " + MenuText.BYE.getMenuText()
                      + Colors.RESET.getColor());
              System.exit(0);
          }
        } else {
          System.out.println(
              Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " You can choose only from 1 to 5!"
                  + Colors.RESET.getColor());
        }
      } else {
        System.out.println(
            Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " Enter the number from 1 to 5"
                + Colors.RESET.getColor());
        scanner.next();
      }
    }
  }

  /**
   * Method runs the submenu for managing vocabulary
   * Users can add, delete, modify, and view vocabulary words and perform sorting operations
   */
  private void runVocabularySubMenu() {
    System.out.println(
        Colors.YELLOW.getColor() + Separator.UPPER_LINE.getSeparator() + Colors.RESET.getColor());
    System.out.println(
        Emoji.WRITE_DOWN.getEmoji() + "Here all your words + translations are stored!");
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

      if (scanner.hasNextInt()) {
        int choice = scanner.nextInt();
        switch (choice) {
          // Add words
          case 1:
            vocabularyManager.addWordToVocabulary(
                scanner);
            break;
            // Remove words
          case 2:
            vocabularyManager.removeWordFromVocabulary(
                scanner);
            break;
            // Replace words
          case 3:
            vocabularyManager.replaceWordInVocabulary(
                scanner);
            break;
          case 4:
            // Show recent changes in the vocabulary
            vocabularyManager.printVocabulary();
            break;
          case 5:
            // Turn on alphabet order for English words
            vocabularyManager.saveToFileByEnglish();
            break;
            // Turn on alphabet order for Spanish words
          case 6:
            vocabularyManager.saveToFileBySpanish();
            break;
            // Open vocabulary file (including all changes history)
          case 7:
            vocabularyManager.openVocabulary();
            break;
            // Return to main menu
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
      } else {
        System.out.println(
            Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " Enter the number from 1 to 8!"
                + Colors.RESET.getColor());
        scanner.next();
      }
    }
  }

  /**
   * Runs the submenu for accessing random facts about Spain
   * Users can get random facts and after that return to the main menu
   */
  private void runRandomFactsSubMenu() {
    System.out.println(
        Colors.YELLOW.getColor() + Separator.UPPER_LINE.getSeparator() + Colors.RESET.getColor());
    System.out.println(
        Emoji.IDEA.getEmoji() + " Here you are! One of the most exciting facts is already here :)");
    System.out.println(
        Colors.YELLOW.getColor() + Separator.DOWN_LINE.getSeparator() + Colors.RESET.getColor());

    while (true) {
      System.out.println(Emoji.ONE.getEmoji() + " " + MenuText.GET_FACT.getMenuText());
      System.out.println(Emoji.TWO.getEmoji() + " " + MenuText.BACK_TO_MENU.getMenuText());
      System.out.println(
          Colors.YELLOW.getColor() + MenuText.CHOICE.getMenuText() + Colors.RESET.getColor());

      if (scanner.hasNextInt()) {
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
          // Get some random fact
          case 1:
            String randomFact = interestingFacts.getRandomFact();
            System.out.println(Colors.YELLOW.getColor() + Separator.LONG_SIMPLE_LINE.getSeparator()
                + Colors.RESET.getColor());
            System.out.println(randomFact);
            System.out.println(Colors.YELLOW.getColor() + Separator.LONG_SIMPLE_LINE.getSeparator()
                + Colors.RESET.getColor());
            break;
            // Return to main menu
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
      } else {
        System.out.println(
            Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " Enter 1 or 2"
                + Colors.RESET.getColor());
        scanner.next();
      }
    }
  }

  /**
   * Runs the submenu for vocabulary training
   * Users can choose between Spanish-to-English and English-to-Spanish training modes
   */
  private void runVocabularyTrainingSubMenu() {
    System.out.println(
        Colors.YELLOW.getColor() + Separator.UPPER_LINE.getSeparator() + Colors.RESET.getColor());
    System.out.println(Emoji.GO_AHEAD.getEmoji() + " Let's check if you remember how to translate the words from your vocabulary");
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

      if (scanner.hasNextInt()) {
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
          // Choose Spanish-to-English training mode
          case 1:
            vocabularyTraining.runSpanishToEnglishTraining();
            break;
            // Choose English-to-Spanish training mode
          case 2:
            vocabularyTraining.runEnglishToSpanishTraining();
            break;
            // Return to main menu
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
      } else {
        System.out.println(
            Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " Enter 1, 2 or 3"
                + Colors.RESET.getColor());
        scanner.next();
      }
    }
  }
}
