package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import visual.Colors;
import visual.Emoji;

/**
 * The InterestingFacts class represents a collection of interesting facts loaded from a file.
 * It allows users to retrieve random facts and keeps track of facts that have been already displayed.
 */
public class InterestingFacts {

  private List<String> facts;

  /**
   * Constructor for InterestingFacts with loading facts from a specified file
   *
   * @param filePath path to the file containing interesting facts
   */
  public InterestingFacts(String filePath) {
    facts = loadFactsFromFile(filePath);
  }

  /**
   * Method loads interesting facts from a file located at the specified path
   *
   * @param filePath path to the file containing interesting facts
   * @return list of loaded facts
   */
  private List<String> loadFactsFromFile(String filePath) {
    List<String> loadedFacts = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        loadedFacts.add(line);
      }
    } catch (IOException e) {
      System.out.println(Colors.RED.getColor() + "Couldn't get the fact: " + e.getMessage() + Colors.RESET.getColor());
    }
    return loadedFacts;
  }

  /**
   * Method gets a random fact from the collection of interesting facts
   *
   * @return random fact
   */
  public String getRandomFact() {
    if (facts.isEmpty()) {
      return Emoji.WRONG.getEmoji() + Colors.RED.getColor() + " That's it! You have already learned all the facts!" + Colors.RESET.getColor();
    }
    Random random = new Random();
    int randomIndex = random.nextInt(facts.size());
    String randomFact = facts.remove(randomIndex);
    return randomFact;
  }
}

