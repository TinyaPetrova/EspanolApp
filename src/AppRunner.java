import Visual.Emoji;
import Visual.Message;
import Visual.Separator;

public class AppRunner {

  public static void main(String[] args) {
    System.out.println(Emoji.CHEERS.getEmoji());
    System.out.println(Message.GREETING.getMessage());
    System.out.println(Separator.UPPER_LINE.getSeparator());
    System.out.println("\u001B[33m•*´¨`*•.¸¸..•*´¨`*HABLAMOS ESPAÑOL•.¸¸..•*´¨`*•.¸¸.•*\u001B[0m");
    System.out.println(Separator.DOWN_LINE.getSeparator());
    System.out.println(Emoji.GREAT.getEmoji());
    System.out.println(Emoji.DONE.getEmoji());
    System.out.println(Emoji.WRONG.getEmoji());
    System.out.println(Emoji.GO_AHEAD.getEmoji());
    System.out.println(Emoji.WRITE_DOWN.getEmoji());
  }
}