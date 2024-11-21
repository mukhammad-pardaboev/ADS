package problemsolvingpatterns.frequencycounter.anagram;

import java.util.HashMap;
import java.util.Map;

public class Anagram4 {
  public static void main(String[] args) {
    System.out.println(isAnagram("cinema", "iceman"));  // true
    System.out.println(isAnagram("red", "deer"));  // false
    System.out.println(isAnagram("hello", "olleh"));  // true
  }

  public static boolean isAnagram(String first, String second) {
    if (first.length() != second.length()) {
      return false;
    }

    Map<Character, Integer> count = new HashMap<>();

    for (int i = 0; i < first.length(); i++) {
      count.put(first.charAt(i), count.getOrDefault(first.charAt(i), 0) + 1);
      count.put(second.charAt(i), count.getOrDefault(second.charAt(i), 0) - 1);
    }

    for (int val : count.values()) {
      if (val != 0) {
        return false;
      }
    }

    return true;
  }
}
