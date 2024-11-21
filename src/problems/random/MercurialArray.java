package problems.random;

/**
 * Define an array to be a Mercurial array if a 3 does not occur between any two 1s.
 * Write a function named isMercurial that returns 1 if its array argument is a Mercurial array, otherways it return 0.
 *
 * Hint: if you encounter a 3 that is preceded by a 1, then there can be no more 1q in the array after the 3.
 */
/*
    {1, 2, 10, 3, 15, 1, 2, 2};  // Not Mercurial (3 between two 1s)
    {5, 1, 10, 7, 1};  // Mercurial (no 3 between two 1s)
    {3, 5, 1, 10, 3, 7, 1, 3}; // Not Mercurial (3 between two 1s)
    {1, 2, 10, 3, 5};  // Mercurial (no 1 after 3)
 */
public class MercurialArray {
    public static void main(String[] args) {
        System.out.println("Case 1: " + isMercurial(new int[]{1, 2, 10, 3, 15, 1, 2, 2})); // Expected output: 0
        System.out.println("Case 2: " + isMercurial(new int[]{5, 1, 10, 7, 1})); // Expected output: 1
        System.out.println("Case 3: " + isMercurial(new int[]{3, 5, 1, 10, 3, 7, 1, 3})); // Expected output: 0
        System.out.println("Case 4: " + isMercurial(new int[]{1, 2, 10, 3, 5})); // Expected output: 1
        System.out.println("Case 5: " + isMercurial(new int[]{3, 1, 2, 3, 1})); // Expected output: 0
    }
    public static int isMercurial(int[] arr) {
        // 1 should come before and after 3.
        boolean foundOne = false;
        boolean foundThreeAfterOne = false;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            if (val == 1) {
                if (foundOne && foundThreeAfterOne) {
                    return 0;
                }
                foundOne = true;
            }
            if (val == 3 && foundOne) {
                foundThreeAfterOne = true;
            }
        }
        return 1;
    }
}
