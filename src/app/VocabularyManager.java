package app;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import visual.Colors;
import visual.Separator;

public class VocabularyManager {

  private Map<String, String> vocabulary;
  private final String filePath = "res/MyVocabulary";

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

  public void saveToFile() {
    List<Map.Entry<String, String>> sortedVocabulary = new ArrayList<>(vocabulary.entrySet());
    sortedVocabulary.sort(Comparator.comparing(Map.Entry::getKey));
    try (FileWriter writer = new FileWriter(filePath)) {
      for (Map.Entry<String, String> entry : sortedVocabulary) {
        writer.write(entry.getKey() + " - " + entry.getValue() + "\n");
      }
      System.out.println(Colors.PURPLE.getColor() + "Словарик сохранен в файл " + filePath
          + Colors.RESET.getColor());
    } catch (IOException e) {
      System.out.println(Colors.RED.getColor() + "Ошибка при записи в файл: " + e.getMessage()
          + Colors.RESET.getColor());
    }
  }

  void addWordToVocabulary(Scanner scanner) {
    scanner.nextLine();
    System.out.print("Введи слово на русском: ");
    String russianWord = scanner.nextLine();
    System.out.print("Введи перевод: ");
    String spanishWord = scanner.nextLine();
    addWord(russianWord, spanishWord);
    saveToFile();
  }

  public void removeWordFromVocabulary(Scanner scanner) {
    scanner.nextLine();
    System.out.print("Введи слово на русском, которое хочешь удалить: ");
    String russianWord = scanner.nextLine();
    if (vocabulary.containsKey(russianWord)) {
      removeWord(russianWord);
      saveToFile();
      System.out.println(
          Colors.PURPLE.getColor() + "Слово удалено из словаря!" + Colors.RESET.getColor());
    } else {
      System.out.println(Colors.RED.getColor() + "Такого слова нет!" + Colors.RESET.getColor());
    }
  }


  public void replaceWordInVocabulary(Scanner scanner) {
    System.out.print("Введите слово на русском, которое хотите заменить: ");
    scanner.nextLine();
    String russianWord = scanner.nextLine();
    if (!vocabulary.containsKey(russianWord)) {
      System.out.println("Слово не найдено в словаре.");
      return;
    }
    System.out.print("Введите новое испанское слово: ");
    String newSpanishWord = scanner.nextLine();
    vocabulary.put(russianWord, newSpanishWord);
    saveToFile();
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
}
