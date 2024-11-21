package problemsolvingpatterns.frequencycounter.anagram;

public class Anagram1 {
  public static void main(String[] args) {
    String str1 = "cat";
    String str2 = "act";

    System.out.println(validAnagram(str1, str2));
  }
  public static boolean validAnagram(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    for (char ch : str1.toCharArray()) {
      int correctIndex = str2.indexOf(ch);
      if (correctIndex == - 1) {
        return false;
      }
      str2 = str2.substring(0, correctIndex) + str2.substring(correctIndex + 1);
    }
    return true;
  }
}
