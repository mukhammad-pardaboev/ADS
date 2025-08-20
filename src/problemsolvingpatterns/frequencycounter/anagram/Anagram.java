package problemsolvingpatterns.frequencycounter.anagram;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, write a function to determine if the second string is 
 * an anagram of the first. An anagram is a word, phrase, or name formed by rearranging 
 * the letters of another, such as cinema, formed from iceman.
 * 
 * Examples:
 * 
 * validAnagram('', '') -> true
 * validAnagram('aaz', 'zza') // false
 * validAnagram('anagram', 'nagaram') // true
 * validAnagram("rat","car") // false) // false
 * validAnagram('awesome', 'awesom') // false
 * validAnagram('qwerty', 'qeywrt') // true
 * validAnagram('texttwisttime', 'timetwisttext') // true
 */
public class Anagram {
  /**
   * Approach #1: Complexity O(n^2)
   * 
   * loop over the each character in the first string
   *  if current char exists i the second string, remove it
   *  else return false
   * return true;
   * 
   * @param str1
   * @param str2
   * @return
   */
  public static boolean validAnagram1(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
      int index = str2.indexOf(str1.charAt(i));
      if (index == -1) {
        return false;
      }
      str2 = str2.substring(0, index) + str2.substring(index + 1);
    }
    return true;
  }

  /**
   * Approach #2: Complexity O(n)
   * 
   * declare map variable to store the frequency of each character in the second string
   * loop over each char in second string
   *  if char exists in the map, increase the value by one
   *  else put it with value 1
   * loop over the second string
   *  if current char doesn't exist in the map or the value is less than or equal to nol, then return false
   *  else decrease the value by one
   * return true
   * 
   * @param str1
   * @param str2
   * @return
   */
  public static boolean validAnagram2(String str1, String str2) {
    if (str1.length() != str2.length()) return false;

    Map<Character, Integer> lookup = new HashMap<>();
    for (int i = 0; i < str2.length(); i++) {
      char ch = str2.charAt(i);
      lookup.put(ch, lookup.getOrDefault(ch, 0) + 1);
    }
    for (int i = 0; i < str1.length(); i++) {
      char ch = str1.charAt(i);
      int count = lookup.getOrDefault(ch, 0);
      if (count <= 0) {
        return false;
      }

      lookup.put(ch, count - 1);
    }
    return true;
  }

  public static void main(String[] args) {
    test("", "", 1);
    test("aaz", "zza", 2);
    test("anagram", "nagaram", 3);
    test("rat", "car", 4);
    test("awesome", "awesom", 5);
    test("qwerty", "qeywrt", 6);
    test("texttwisttime", "timetwisttext", 7);
  }

  public static void test(String str1, String str2, int caseNumber) {
    System.out.println("Case #" + caseNumber);
    System.out.println("'" + str1 + "'" + " and " + "'" + str2 + "'" + ": " + validAnagram2(str1, str2));
  }
}
