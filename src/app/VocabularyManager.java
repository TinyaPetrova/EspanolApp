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
  private int score = 0;

  /**
   * Constructor for VocabularyManager, initializing the vocabulary and loading data from a file if available.
   */
  public VocabularyManager() {
    vocabulary = new HashMap<>();
    wordOrder = new ArrayList<>();
    loadFromFile();
  }

  /**
   * Enum for the word types (Russian and Spanish) for vocabulary operations
   */
  public enum WordType {
    RUSSIAN,
    SPANISH
  }

  /**
   * Method adds a word and its translation to the vocabulary
   *
   * @param russian Russian word
   * @param spanish Spanish word
   */
  public void addWord(String russian, String spanish) {
    vocabulary.put(russian, spanish);
    wordOrder.add(russian);
  }

  /**
   * Method removes a word pair from the vocabulary by its Russian word
   *
   * @param russian Russian word to be removed
   */
  public void removeWord(String russian) {
    vocabulary.remove(russian);
  }

  /**
   * Method replaces the translation of a Russian word in the vocabulary.
   *
   * @param russian Russian word to be replaced
   * @param newSpanish new translation in Spanish
   */
  public void replaceWord(String russian, String newSpanish) {
    vocabulary.put(russian, newSpanish);
  }

  /**
   * Method prints the vocabulary, displaying the Russian words and their Spanish translations
   */
  public void printVocabulary() {
    System.out.println(Colors.YELLOW.getColor() + "Вот последние записанные тобой слова:" + Colors.RESET.getColor());
    System.out.println(Colors.PURPLE.getColor() + Separator.DECORATION.getSeparator() + Colors.RESET.getColor());
    for (String russian : wordOrder) {
      String spanish = vocabulary.get(russian);
      System.out.println(russian + " - " + spanish);
    }
    System.out.println(Colors.PURPLE.getColor() + Separator.DECORATION.getSeparator() + Colors.RESET.getColor());
  }

  /**
   * Method saves the vocabulary to a file, sorted by Russian words
   */
  public void saveToFileByRussian() {
    List<Entry<String, String>> sortedVocabulary = new ArrayList<>(vocabulary.entrySet());
    sortedVocabulary.sort(VocabularyComparators.byRussian());
    try (FileWriter writer = new FileWriter(filePath)) {
      for (Map.Entry<String, String> entry : sortedVocabulary) {
        writer.write(entry.getKey() + " - " + entry.getValue() + "\n");
      }
      System.out.println(Emoji.GO_AHEAD.getEmoji() + Colors.PURPLE.getColor() + " Обновили! Включён алфавитный порядок для русских слов: см. в файле " + filePath + Colors.RESET.getColor());
    } catch (IOException e) {
      System.out.println(Colors.RED.getColor() + "Ошибка при записи в файл: " + e.getMessage() + Colors.RESET.getColor());
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
      System.out.println(Emoji.GO_AHEAD.getEmoji() + Colors.PURPLE.getColor() + " Обновили! Включён алфавитный порядок для испанских слов: см. в файле " + filePath + Colors.RESET.getColor());
    } catch (IOException e) {
      System.out.println(Colors.RED.getColor() + "Ошибка при записи в файл: " + e.getMessage() + Colors.RESET.getColor());
    }
  }

  /**
   * Method adds a word and its translation to the vocabulary
   *
   * @param scanner scanner for user's input
   */
  void addWordToVocabulary(Scanner scanner) {
    scanner.nextLine();
    String russianWord;
    do {
      System.out.print("Введи слово на русском: ");
      russianWord = scanner.nextLine();
      if (!containsCyrillic(russianWord)) {
        System.out.println(Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " Ошибка: поменяй раскладку на клавиатуре!" + Colors.RESET.getColor());
      }
    } while (!containsCyrillic(russianWord));
    String spanishWord;
    do {
      System.out.print("Введи перевод: ");
      spanishWord = scanner.nextLine();
      if (!containsLatin(spanishWord)) {
        System.out.println(Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " Ошибка: поменяй раскладку на клавиатуре!" + Colors.RESET.getColor());
      }
    } while (!containsLatin(spanishWord));
    addWord(russianWord, spanishWord);
    saveToFileByRussian();
  }

  /**
   * Method removes a word and its translation from the vocabulary by its Russian word
   *
   * @param scanner scanner for user's input
   */
  public void removeWordFromVocabulary(Scanner scanner) {
    scanner.nextLine();
    System.out.print("Введи слово на русском, пару с которым хочешь удалить: ");
    String russianWord = scanner.nextLine();
    if (vocabulary.containsKey(russianWord)) {
      removeWord(russianWord);
      saveToFileByRussian();
      wordOrder.remove(russianWord);
      System.out.println(Colors.PURPLE.getColor() + "Удалено из словаря!" + Colors.RESET.getColor());
    } else {
      System.out.println(Colors.RED.getColor() + "Такого слова нет!" + Colors.RESET.getColor());
    }
  }

  /**
   * Method replaces the translation of a Russian word in the vocabulary
   *
   * @param scanner scanner for user's input
   */
  public void replaceWordInVocabulary(Scanner scanner) {
    System.out.print("Введи слово на русском, перевод которого хочешь заменить: ");
    scanner.nextLine();
    String russianWord = scanner.nextLine();
    if (!vocabulary.containsKey(russianWord)) {
      System.out.println(Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " Слово не найдено в словаре" + Colors.RESET.getColor());
      return;
    }
    System.out.print("Введи новое испанское слово: ");
    String newSpanishWord = scanner.nextLine();
    replaceWord(russianWord, newSpanishWord);
    saveToFileByRussian();
    System.out.println(
        Colors.PURPLE.getColor() + "Слово заменено в словаре!" + Colors.RESET.getColor());
  }

  /**
   * Method checks if a given text contains Cyrillic characters
   *
   * @param text text to be checked
   * @return true if the text contains Cyrillic characters, otherwise false
   */
  public boolean containsCyrillic(String text) {
    for (char c : text.toCharArray()) {
      if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC) {
        return true;
      }
    }
    return false;
  }

  /**
   * Method checks if a given text contains Latin characters
   *
   * @param text text to be checked
   * @return true if the text contains Latin characters, otherwise false
   */
  public boolean containsLatin(String text) {
    for (char c : text.toCharArray()) {
      if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.BASIC_LATIN) {
        return true;
      }
    }
    return false;
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
      System.out.println(Colors.RED.getColor() + "Не получилось загрузить данные!" + Colors.RESET.getColor());
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
        System.out.println("Файл не найден.");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Method gets a random word from the vocabulary of the specified word type (Russian or Spanish)
   *
   * @param wordType type of word for training (Russian or Spanish).
   * @return random word of the specified type
   */
  public String getRandomWord(WordType wordType) {
    if (vocabulary.isEmpty()) {
      System.out.println(Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " В словаре нет слов!" + Colors.RESET.getColor());
      return null;
    }
    List<String> words = wordType.equals(WordType.RUSSIAN) ? new ArrayList<>(vocabulary.keySet()) : new ArrayList<>(vocabulary.values());
    Random random = new Random();
    int randomIndex = random.nextInt(words.size());
    return words.get(randomIndex);
  }

  /**
   * Method gets the translation of a word in the specified word type (Russian or Spanish)
   *
   * @param word translation for training
   * @param wordType type of word (Russian or Spanish) translation
   * @return translation of the word in the specified type
   */
  public String getTranslation(String word, WordType wordType) {
    if (wordType.equals(WordType.RUSSIAN)) {
      return vocabulary.get(word);
    } else if (wordType.equals(WordType.SPANISH) && vocabulary.containsValue(word)) {
      return getKeyByValue(vocabulary, word);
    }
    return "Перевод не найден";
  }

  /**
   * Method gets the key (Russian word) associated with a given value (Spanish word) in the map
   *
   * @param map map containing words pairs
   * @param value value (Spanish word) which helps to find the corresponding key
   * @return key (Russian word) associated with the specified value
   */
  private String getKeyByValue(Map<String, String> map, String value) {
    for (Map.Entry<String, String> entry : map.entrySet()) {
      if (entry.getValue().equals(value)) {
        return entry.getKey();
      }
    }
    return "Перевод не найден";
  }

  /**
   * Method saves the current score to a file
   *
   * @param score score to be saved
   */
  private void saveScore(int score) {
    try (FileWriter writer = new FileWriter("res/MyScore.txt")) {
      writer.write(Integer.toString(score));
      System.out.println(Emoji.GO_AHEAD.getEmoji() + Colors.PURPLE.getColor() + " Сохранили баллы: " + score + Colors.RESET.getColor());
    } catch (IOException e) {
      System.out.println(Colors.RED.getColor() + "Ошибка при записи баллов в файл: " + e.getMessage() + Colors.RESET.getColor());
    }
  }

  /**
   * Increments the user's score and saves it to a file
   */
  void incrementScore() {
    score++;
    saveScore(score);
    try (FileWriter writer = new FileWriter("res/MyScore.txt")) {
      writer.write(SCORE_PREFIX.getMessage());
      writer.write(Integer.toString(score));
    } catch (IOException e) {
      System.out.println(Colors.RED.getColor() + "Ошибка при записи баллов в файл: " + e.getMessage() + Colors.RESET.getColor());
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
            System.out.println(Colors.RED.getColor() + "Ошибка при загрузке баллов из файла: неверный формат данных" + Colors.RESET.getColor());
          }
        }
      }
      ProcessBuilder pb = new ProcessBuilder("notepad.exe", "res/MyScore.txt");
      pb.start();
    } catch (IOException e) {
      System.out.println(Colors.RED.getColor() + "Ошибка при загрузке баллов из файла: " + e.getMessage() + Colors.RESET.getColor());
    }
  }
}
