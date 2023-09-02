package app;

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
import java.util.Scanner;
import visual.Colors;
import visual.Emoji;
import visual.Separator;
import vocabulary.VocabularyComparators;

public class VocabularyManager {

  private Map<String, String> vocabulary;
  private final String filePath = "res/MyVocabulary.txt";

  public VocabularyManager() {
    vocabulary = new HashMap<>();
    loadFromFile();
  }

  public void addWord(String russian, String spanish) {
    vocabulary.put(russian, spanish);
  }

  public void removeWord(String russian) {
    vocabulary.remove(russian);
  }

  public void replaceWord(String russian, String newSpanish) {
    vocabulary.put(russian, newSpanish);
  }

  public void printVocabulary() {
    System.out.println(Colors.YELLOW.getColor() + "Вот твой словарик:" + Colors.RESET.getColor());
    System.out.println(Colors.PURPLE.getColor() + Separator.DECORATION.getSeparator() + Colors.RESET.getColor());
    for (Map.Entry<String, String> entry : vocabulary.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }
    System.out.println(Colors.PURPLE.getColor() + Separator.DECORATION.getSeparator() + Colors.RESET.getColor());
  }

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

  void addWordToVocabulary(Scanner scanner) {
    scanner.nextLine();
    System.out.print("Введи слово на русском: ");
    String russianWord = scanner.nextLine();
    System.out.print("Введи перевод: ");
    String spanishWord = scanner.nextLine();
    addWord(russianWord, spanishWord);
    saveToFileByRussian();
  }

  public void removeWordFromVocabulary(Scanner scanner) {
    scanner.nextLine();
    System.out.print("Введи слово на русском, которое хочешь удалить: ");
    String russianWord = scanner.nextLine();
    if (vocabulary.containsKey(russianWord)) {
      removeWord(russianWord);
      saveToFileByRussian();
      System.out.println(
          Colors.PURPLE.getColor() + "Слово удалено из словаря!" + Colors.RESET.getColor());
    } else {
      System.out.println(Colors.RED.getColor() + "Такого слова нет!" + Colors.RESET.getColor());
    }
  }


  public void replaceWordInVocabulary(Scanner scanner) {
    System.out.print("Введи слово на русском, которое хочешь заменить: ");
    scanner.nextLine();
    String russianWord = scanner.nextLine();
    if (!vocabulary.containsKey(russianWord)) {
      System.out.println("Слово не найдено в словаре.");
      return;
    }
    System.out.print("Введи новое испанское слово: ");
    String newSpanishWord = scanner.nextLine();
    vocabulary.put(russianWord, newSpanishWord);
    saveToFileByRussian();
    System.out.println(
        Colors.PURPLE.getColor() + "Слово заменено в словаре!" + Colors.RESET.getColor());
  }

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
}