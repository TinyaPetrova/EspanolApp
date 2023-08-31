package appMenu;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import visual.Colors;

public class VocabularyManager {

  private Map<String, String> vocabulary;
  private final String filePath = "res/MyVocabulary";

  public VocabularyManager() {
    vocabulary = new HashMap<>();
  }

  public void addWord(String russian, String spanish) {
    vocabulary.put(russian, spanish);
    saveToFile();
  }

  public void removeWord(String russian) {
    vocabulary.remove(russian);
    saveToFile();
  }

  public void replaceWord(String russian, String newSpanish) {
    vocabulary.put(russian, newSpanish);
    saveToFile();
  }

  public void printVocabulary() {
    System.out.println(Colors.YELLOW.getColor() + "Вот твой словарик:" + Colors.RESET.getColor());
    for (Map.Entry<String, String> entry : vocabulary.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }
  }

  public void saveToFile() {
    List<Map.Entry<String, String>> sortedVocabulary = new ArrayList<>(vocabulary.entrySet());
    sortedVocabulary.sort(Comparator.comparing(Map.Entry::getKey));
    try (FileWriter writer = new FileWriter(filePath)) {
      for (Map.Entry<String, String> entry : sortedVocabulary) {
        writer.write(entry.getKey() + " - " + entry.getValue() + "\n");
      }
      System.out.println(Colors.GREEN.getColor() + "Словарик сохранен в файл " + filePath
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
          Colors.GREEN.getColor() + "Слово удалено из словаря!" + Colors.RESET.getColor());
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
    replaceWord(russianWord, newSpanishWord);
    System.out.println(
        Colors.GREEN.getColor() + "Слово заменено в словаре!" + Colors.RESET.getColor());
  }
}
