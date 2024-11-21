package problemsolvingpatterns.frequencycounter.anagram;

import java.util.HashMap;
import java.util.Map;

public class Anagram2 {
  public static void main(String[] args) {
    String str1 = "cat";
    String str2 = "act";

    System.out.println(validAnagram(str1, str2));
  }
  public static boolean validAnagram(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    Map<Character, Integer> lookupMap = new HashMap<>();

    for (char ch : str1.toCharArray()) {
      lookupMap.put(ch, lookupMap.getOrDefault(ch, 0) + 1);
    }

    for (char ch : str2.toCharArray()) {
      if (!lookupMap.containsKey(ch) || lookupMap.get(ch) <= 0) {
        return false;
      }
      lookupMap.put(ch, lookupMap.get(ch) - 1);
    }
    return true;
  }
}
