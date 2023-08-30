package AppMenu;

import java.util.ArrayList;
import java.util.List;

public class Vocabulary {
  private List<Word> words;

  public Vocabulary() {
    words = new ArrayList<>();
  }

  public void addWord(Word word) {
    words.add(word);
  }

  public List<Word> getWords() {
    return words;
  }
}
