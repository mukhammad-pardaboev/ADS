package problems.w3.basic1;

public class CountCharactersInString {
    public static void main(String[] args) {
        String input = "Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33";
        solution2(input);
    }

    public static void solution1(String input) {
        int letter = 0;
        int space = 0;
        int number = 0;
        int other = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isLetter(c)) {
                letter++;
            } else if (isDigit(c)) {
                number++;
            } else if (isSpace(c)) {
                space++;
            } else {
                other++;
            }
        }

        System.out.println("letter: " + letter);
        System.out.println("space: " + space);
        System.out.println("number: " + number);
        System.out.println("other: " + other);
    }

    public static void solution2(String input) {
        // Convert the input string to a character array
        char[] ch = input.toCharArray();

        // Initialize counters for letters, spaces, numbers, and other characters
        int letter = 0;
        int space = 0;
        int num = 0;
        int other = 0;

        // Iterate through the character array to categorize characters
        for (int i = 0; i < input.length(); i++) {
            // Check if the character is a letter
            if (Character.isLetter(ch[i])) {
                letter++;
            }
            // Check if the character is a digit (number)
            else if (Character.isDigit(ch[i])) {
                num++;
            }
            // Check if the character is a space
            else if (Character.isSpaceChar(ch[i])) {
                space++;
            }
            // Character falls into the "other" category if none of the above conditions are met
            else {
                other++;
            }
        }

        // Display the original string
        System.out.println("The string is : Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33");

        // Display the counts of letters, spaces, numbers, and other characters
        System.out.println("letter: " + letter);
        System.out.println("space: " + space);
        System.out.println("number: " + num);
        System.out.println("other: " + other);
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    private static boolean isSpace(char c) {
        return c == ' ';
    }
}
