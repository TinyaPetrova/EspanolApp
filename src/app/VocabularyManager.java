package app;

import static texts.Message.SCORE_PREFIX;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import visual.Colors;
import visual.Emoji;
import visual.Separator;

/**
 * The VocabularyManager class represents a manager for a user's vocabulary in the application
 * It allows users to add, remove, replace, and view words and their translations (including opening
 * the vocabulary file), as well as manage scores
 */
public class VocabularyManager {

  private Map<String, String> vocabulary;
  private List<String> wordOrder;
  private final String filePath = "res/MyVocabulary.txt";
  public int score = 0;

  /**
   * Constructor for VocabularyManager, initializing the vocabulary and loading data from a file if available.
   */
  public VocabularyManager() {
    vocabulary = new HashMap<>();
    wordOrder = new ArrayList<>();
    loadFromFile();
  }

  /**
   * Enum for the word types (English and Spanish) for vocabulary operations
   */
  public enum WordType {
    ENGLISH,
    SPANISH
  }

  /**
   * Method adds a word and its translation to the vocabulary
   *
   * @param english English word
   * @param spanish Spanish word
   */
  public void addWord(String english, String spanish) {
    vocabulary.put(english, spanish);
    wordOrder.add(english);
  }

  /**
   * Method removes a word pair from the vocabulary by its English word
   *
   * @param english English word to be removed
   */
  public void removeWord(String english) {
    vocabulary.remove(english);
  }

  /**
   * Method replaces the translation of an English word in the vocabulary.
   *
   * @param english English word to be replaced
   * @param newSpanish new translation in Spanish
   */
  public void replaceWord(String english, String newSpanish) {
    vocabulary.put(english, newSpanish);
  }

  /**
   * Method prints the vocabulary, displaying the English words and their Spanish translations
   */
  public void printVocabulary() {
    System.out.println(Colors.YELLOW.getColor() + "Here are the last words you put into your vocabulary:" + Colors.RESET.getColor());
    System.out.println(Colors.PURPLE.getColor() + Separator.DECORATION.getSeparator() + Colors.RESET.getColor());
    for (String english : wordOrder) {
      String spanish = vocabulary.get(english);
      System.out.println(english + " - " + spanish);
    }
    System.out.println(Colors.PURPLE.getColor() + Separator.DECORATION.getSeparator() + Colors.RESET.getColor());
  }

  /**
   * Method saves the vocabulary to a file, sorted by English words
   */
  public void saveToFileByEnglish() {
    List<Entry<String, String>> sortedVocabulary = new ArrayList<>(vocabulary.entrySet());
    sortedVocabulary.sort(VocabularyComparators.byEnglish());
    try (FileWriter writer = new FileWriter(filePath)) {
      for (Map.Entry<String, String> entry : sortedVocabulary) {
        writer.write(entry.getKey() + " - " + entry.getValue() + "\n");
      }
      System.out.println(Emoji.GO_AHEAD.getEmoji() + Colors.PURPLE.getColor() + " Updated! Enabled alphabetical order for English words: see in file " + filePath + Colors.RESET.getColor());
    } catch (IOException e) {
      System.out.println(Colors.RED.getColor() + "Couldn't write the word into file: " + e.getMessage() + Colors.RESET.getColor());
    }
  }

  /**
   * Method saves the vocabulary to a file, sorted by Spanish words
   */
  public void saveToFileBySpanish() {
    List<Map.Entry<String, String>> sortedVocabulary = new ArrayList<>(vocabulary.entrySet());
    sortedVocabulary.sort(VocabularyComparators.bySpanish());
    try (FileWriter writer = new FileWriter(filePath)) {
      for (Map.Entry<String, String> entry : sortedVocabulary) {
        writer.write(entry.getKey() + " - " + entry.getValue() + "\n");
      }
      System.out.println(Emoji.GO_AHEAD.getEmoji() + Colors.PURPLE.getColor() + " Updated! Enabled alphabetical order for Spanish words: see in file " + filePath + Colors.RESET.getColor());
    } catch (IOException e) {
      System.out.println(Colors.RED.getColor() + "Couldn't write the word into file: " + e.getMessage() + Colors.RESET.getColor());
    }
  }

  /**
   * Method adds a word and its translation to the vocabulary
   *
   * @param scanner scanner for user's input
   */
  void addWordToVocabulary(Scanner scanner) {
    scanner.nextLine();
    String englishWord;
    do {
      System.out.print("Enter an English word: ");
      englishWord = scanner.nextLine();
    } while (englishWord.isEmpty());

    String spanishWord;
    do {
      System.out.print("Enter the translation: ");
      spanishWord = scanner.nextLine();
    } while (spanishWord.isEmpty());

    addWord(englishWord, spanishWord);
    saveToFileByEnglish();
  }

  /**
   * Method removes a word and its translation from the vocabulary by its English word
   *
   * @param scanner scanner for user's input
   */
  public void removeWordFromVocabulary(Scanner scanner) {
    scanner.nextLine();
    System.out.print("Enter an English word, which you want to delete: ");
    String englishWord = scanner.nextLine();
    if (vocabulary.containsKey(englishWord)) {
      removeWord(englishWord);
      saveToFileByEnglish();
      wordOrder.remove(englishWord);
      System.out.println(Colors.PURPLE.getColor() + "Deleted successfully!" + Colors.RESET.getColor());
    } else {
      System.out.println(Colors.RED.getColor() + "Didn't find this word :(" + Colors.RESET.getColor());
    }
  }

  /**
   * Method replaces the translation of an English word in the vocabulary
   *
   * @param scanner scanner for user's input
   */
  public void replaceWordInVocabulary(Scanner scanner) {
    System.out.print("Enter the word in English the translation of which you want to replace: ");
    scanner.nextLine();
    String englishWord = scanner.nextLine();
    if (!vocabulary.containsKey(englishWord)) {
      System.out.println(Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " Didn't find this word" + Colors.RESET.getColor());
      return;
    }
    System.out.print("Enter new Spanish word: ");
    String newSpanishWord = scanner.nextLine();
    replaceWord(englishWord, newSpanishWord);
    saveToFileByEnglish();
    System.out.println(
        Colors.PURPLE.getColor() + "Success!" + Colors.RESET.getColor());
  }

  /**
   * Method loads data from a file to initialize the vocabulary
   */
  private void loadFromFile() {
    try {
      List<String> lines = Files.readAllLines(Paths.get(filePath));
      for (String line : lines) {
        String[] parts = line.split(" - ");
        if (parts.length == 2) {
          vocabulary.put(parts[0], parts[1]);
        }
      }
    } catch (IOException e) {
      System.out.println(Colors.RED.getColor() + "Unable to load the data!" + Colors.RESET.getColor());
    }
  }

  /**
   * Method opens the vocabulary file in the text editor
   */
  void openVocabulary() {
    try {
      File file = new File("res/MyVocabulary.txt");
      if (file.exists()) {
        ProcessBuilder pb = new ProcessBuilder("notepad.exe", file.getAbsolutePath());
        pb.start();
      } else {
        System.out.println("File wasn't found");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Method gets a random word from the vocabulary of the specified word type (English or Spanish)
   *
   * @param wordType type of word for training (English or Spanish).
   * @return random word of the specified type
   */
  public String getRandomWord(WordType wordType) {
    if (vocabulary.isEmpty()) {
      System.out.println(Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " Vocabulary is empty!" + Colors.RESET.getColor());
      return null;
    }
    List<String> words = wordType.equals(WordType.ENGLISH) ? new ArrayList<>(vocabulary.keySet()) : new ArrayList<>(vocabulary.values());
    Random random = new Random();
    int randomIndex = random.nextInt(words.size());
    return words.get(randomIndex);
  }

  /**
   * Method gets the translation of a word in the specified word type (Russian or Spanish)
   *
   * @param word translation for training
   * @param wordType type of word (English or Spanish) translation
   * @return translation of the word in the specified type
   */
  public String getTranslation(String word, WordType wordType) {
    if (wordType.equals(WordType.ENGLISH)) {
      return vocabulary.get(word);
    } else if (wordType.equals(WordType.SPANISH) && vocabulary.containsValue(word)) {
      return getKeyByValue(vocabulary, word);
    }
    return "Translation wasn't found";
  }

  /**
   * Method gets the key (English word) associated with a given value (Spanish word) in the map
   *
   * @param map map containing words pairs
   * @param value value (Spanish word) which helps to find the corresponding key
   * @return key (English word) associated with the specified value
   */
  private String getKeyByValue(Map<String, String> map, String value) {
    for (Map.Entry<String, String> entry : map.entrySet()) {
      if (entry.getValue().equals(value)) {
        return entry.getKey();
      }
    }
    return "Translation wasn't found";
  }

  /**
   * Method saves the current score to a file
   *
   * @param score score to be saved
   */
  private void saveScore(int score) {
    try (FileWriter writer = new FileWriter("res/MyScore.txt")) {
      writer.write(Integer.toString(score));
      System.out.println(Emoji.GO_AHEAD.getEmoji() + Colors.PURPLE.getColor() + " Your score is saved: " + score + Colors.RESET.getColor());
    } catch (IOException e) {
      System.out.println(Colors.RED.getColor() + "Error when writing the score to a file: " + e.getMessage() + Colors.RESET.getColor());
    }
  }

  /**
   * Increments the user's score and saves it to a file
   */
  public void incrementScore() {
    score++;
    saveScore(score);
    try (FileWriter writer = new FileWriter("res/MyScore.txt")) {
      writer.write(SCORE_PREFIX.getMessage());
      writer.write(Integer.toString(score));
    } catch (IOException e) {
      System.out.println(Colors.RED.getColor() + "Error when writing the score to a file: " + e.getMessage() + Colors.RESET.getColor());
    }
  }

  /**
   * Loads the user's score from a file
   */
  public void loadScoreFromFile() {
    try {
      List<String> lines = Files.readAllLines(Paths.get("res/MyScore.txt"));
      if (!lines.isEmpty()) {
        String scoreLine = lines.get(0);
        String[] parts = scoreLine.split(":");
        if (parts.length == 2) {
          try {
            score = Integer.parseInt(parts[1].trim());
          } catch (NumberFormatException e) {
            System.out.println(Colors.RED.getColor() + "Error when loading score from file: wrong data format" + Colors.RESET.getColor());
          }
        }
      }
      ProcessBuilder pb = new ProcessBuilder("notepad.exe", "res/MyScore.txt");
      pb.start();
    } catch (IOException e) {
      System.out.println(Colors.RED.getColor() + "Error when loading the score from a file: " + e.getMessage() + Colors.RESET.getColor());
    }
  }
}
