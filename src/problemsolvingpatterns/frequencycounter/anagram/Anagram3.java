package problemsolvingpatterns.frequencycounter.anagram;

import java.util.Arrays;

public class Anagram3 {
  public static boolean isAnagram(String str1, String str2) {
    // Remove whitespace and convert strings to lowercase
    str1 = str1.replaceAll("\\s", "").toLowerCase();
    str2 = str2.replaceAll("\\s", "").toLowerCase();

    // If the lengths are different, they can't be anagrams
    if (str1.length() != str2.length()) {
      return false;
    }

    // Convert strings to char arrays and sort them
    char[] arr1 = str1.toCharArray();
    char[] arr2 = str2.toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);

    // Compare the sorted char arrays
    return Arrays.equals(arr1, arr2);
  }

  public static void main(String[] args) {
    String str1 = "cinema";
    String str2 = "iceman";
    System.out.println(isAnagram(str1, str2)); // Output: true

    String str3 = "listen";
    String str4 = "silent";
    System.out.println(isAnagram(str3, str4)); // Output: true

    String str5 = "hello";
    String str6 = "world";
    System.out.println(isAnagram(str5, str6)); // Output: false
  }
}
