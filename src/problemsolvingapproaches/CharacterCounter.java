package problemsolvingapproaches;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Write a function which takes in a string and returns counts of each character
 * in the string.
 * 
 * Examples:
 * 
 * countChar("aaaa") -> {a: 4}
 * countChar("hello") -> {h: 1, e: 1, l: 2, o: 1}
 * countChar("my phone number is 182763") -> what about spaces and numbers?
 * countChar("Hello hi") -> What about (upper/lower)casing?
 * countChar("") -> What should be returned?
 * countChar(11223) => What should be returned?
 * 
 */

public class CharacterCounter {
  /**
   * create an map which holds the strings
   * loop over the each char in the string
   * // if the char is a number/letter AND is a key in map, add one to count
   * // if the char is a number/letter AND is not in map, add it and set value to
   * 1
   * // if the character is something else (space, period, etc) don't do anything
   * return the map
   */
  public static Map<Character, Integer> countChar1(String str) {
    if (str.isEmpty())
      return null;
    Map<Character, Integer> result = new HashMap<>();
    int value;

    for (int i = 0; i < str.length(); i++) {
      char ch = Character.toLowerCase(str.charAt(i));

      if (result.containsKey(ch)) {
        value = result.get(ch);
        result.put(ch, ++value);
      } else {
        value = 1;
        result.put(ch, value);
      }
    }
    return result;
  }

  public static Map<Character, Integer> countChar2(String str) {
    if (str.isEmpty())
      return null;
    Map<Character, Integer> result = new HashMap<>();
    int value;

    for (int i = 0; i < str.length(); i++) {
      Character ch = Character.toLowerCase(str.charAt(i));

      if (Pattern.matches("[a-z\\d]", ch.toString())) {
        if (result.containsKey(ch)) {
          value = result.get(ch);
          result.put(ch, ++value);
        } else {
          value = 1;
          result.put(ch, value);
        }
      }
    }
    return result;
  }

  public static Map<Character, Integer> countChar3(String str) {
    Map<Character, Integer> result = new HashMap<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (isAlphaNumeric(ch)) {
        ch = Character.toLowerCase(ch);
        result.put(ch, result.getOrDefault(ch, 0) + 1);
      }
    }
    return result;
  }

  private static boolean isAlphaNumeric(char ch) {
    return ch > 47 && ch < 58 ||
        ch > 64 && ch < 91 ||
        ch > 96 && ch < 123;
  }

  public static void main(String[] args) {
    test("aaaa", 1); // {a: 4}
    test("hello", 2); // {h: 1, e: 1, l: 2, o: 1}
    test("my phone number is 182763", 3); // what about spaces and numbers?
    test("Hello hi", 4); // What about (upper/lower)casing?
    test("", 5); // What should be returned?

  }

  public static void test(String str, int caseNum) {
    var result = countChar3(str);

    System.out.print("Test Case #" + caseNum + ": ");
    result.entrySet().forEach(entry -> {
      System.out.print("{" + entry.getKey() + ": " + entry.getValue() + "}");
    });
    System.out.println();
  }
}
