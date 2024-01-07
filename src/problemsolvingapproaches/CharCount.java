package problemsolvingapproaches;

import java.util.HashMap;
import java.util.Map;

/*
 * Write a function which takes in a string and returns counts of each character in the string
 */
public class CharCount {
    public static void main(String[] args) {
        Map<Character, Integer> characterIntegerMap = countChar("Hi there !! 121");

        System.out.println("Result: " + characterIntegerMap.toString());
    }

    public static Map<Character, Integer> countChar(String str) {
        if (str.isEmpty())
            return null;
        Map<Character, Integer> result = new HashMap<>();
        int value;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (isAlphaNumeric(ch)) {
                ch = Character.toLowerCase(ch);
                value = result.containsKey(ch) ? result.get(ch) + 1 : 1;
                result.put(ch, value);
            }
        }
        return result;
    }

    private static boolean isAlphaNumeric(char ch) {
        return ch > 47 && ch < 58 ||
                ch > 64 && ch < 91 ||
                ch > 96 && ch < 123;
    }
}
