package problems.strings;

/**
 * Given a string of size n, write functions to perform the following operations on a string-
 * Left (Or anticlockwise) rotate the given string by d elements (where d <= n)
 * Right (Or clockwise) rotate the given string by d elements (where d <= n).
 * <br>
 * <br>
 * Examples:
 *
 * <p>
 *   Input : s = "GeeksforGeeks"
 *           d = 2
 *   Output : Left Rotation  : "eksforGeeksGe"
 *            Right Rotation : "ksGeeksforGee"
 *   Input : s = "qwertyu"
 *           d = 2
 *   Output : Left rotation : "ertyuqw"
 *            Right rotation : "yuqwert"
 * </p>
 *
 */
public class StringRotation {
    public static void main(String[] args) {
        String input = "INNOVATION";

        System.out.println("Rotate right: " + rotateRight1(input, 2));
        System.out.println("Rotate left: " + rotateLeft1(input, 2));
    }

    public static String rotateRight1(String input, int n) {
        String[] letters = input.split("");
        String rotated = "";

        for (int i = 0; i < letters.length; i++) {
            if (i < n) {
                rotated += letters[letters.length - n + i];
                continue;
            }
            rotated += letters[i - n];
        }
        return rotated;
    }

    public static String rotateLeft1(String input, int n) {
        String[] letters = input.split("");
        String rotated = "";

        for (int i = 0; i < letters.length; i++) {
            System.out.println(i);
            if ((n + i) < letters.length) {
                rotated += letters[n + i];
                continue;
            }
            rotated += letters[i - letters.length + n];
        }
        return rotated;
    }
}
