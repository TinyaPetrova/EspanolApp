package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import visual.Colors;
import visual.Emoji;

public class InterestingFacts {

  private List<String> facts;

  public InterestingFacts(String filePath) {
    facts = loadFactsFromFile(filePath);
  }

  private List<String> loadFactsFromFile(String filePath) {
    List<String> loadedFacts = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        loadedFacts.add(line);
      }
    } catch (IOException e) {
      System.out.println(Colors.RED.getColor() + "Ошибка при загрузке фактов: " + e.getMessage() + Colors.RESET.getColor());
    }
    return loadedFacts;
  }

  public String getRandomFact() {
    if (facts.isEmpty()) {
      return Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " На этом всё! Ты уже знаешь все факты, которые мы собрали для тебя" + Colors.RESET.getColor();
    }
    Random random = new Random();
    int randomIndex = random.nextInt(facts.size());
    String randomFact = facts.remove(randomIndex);
    return randomFact;
  }
}

