package appMenu;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Vocabulary {
  private Map<String, String> rusToEsp;
  private Map<String, String> espToRus;

  public Vocabulary() {
    rusToEsp = new HashMap<>();
    espToRus = new HashMap<>();
  }

  public void addWordRusToEsp(String russian, String spanish) {
    rusToEsp.put(russian, spanish);
  }

  public void addWordEspToRus(String spanish, String russian) {
    espToRus.put(spanish, russian);
  }

  public void printRusToEsp() {
    System.out.println("Русско-испанский словарь:");
    for (Map.Entry<String, String> entry : rusToEsp.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }
  }

  public void printEspToRus() {
    System.out.println("Испано-русский словарь:");
    for (Map.Entry<String, String> entry : espToRus.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }
  }

  public void saveToFile(String fileName) {
    try (FileWriter writer = new FileWriter(fileName)) {
      for (Map.Entry<String, String> entry : rusToEsp.entrySet()) {
        writer.write(entry.getKey() + " - " + entry.getValue() + "\n");
      }
      for (Map.Entry<String, String> entry : espToRus.entrySet()) {
        writer.write(entry.getKey() + " - " + entry.getValue() + "\n");
      }
    } catch (IOException e) {
      System.out.println("Ошибка при записи в файл: " + e.getMessage());
    }
  }
}

