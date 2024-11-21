package problems.random;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function named equivalentArrays that has two array arguments and returns 1
 * if the two arrays contain the same values (but not necessarily in the same order),
 * otherwise it returns 0. Your solution must not sort either array or a copy of either array!
 * Also you must not modify either array, i.e., the values in the arrays upon return from
 * the function must be the same as when the function was called.
 * Note that the arrays do not have to have the same number of elements,
 * they just have to have one of more copies of the same values.
 */
/*
    {1, 2, 0}, {0, 1, 2} -> 1
    {1, 2, 0}, {0, 1, 2, 1} -> 1
    {1, 2, 0}, {0, 1, 2, 3} -> 0
 */
public class EquivalentArrays {
    public static void main(String[] args) {
        System.out.println("Case 1: " + equivalentArrays2(new int[]{1, 2, 0}, new int[]{0, 1, 2})); // expected: 1
        System.out.println("Case 2: " + equivalentArrays2(new int[]{1, 2, 0}, new int[]{0, 1, 2, 1})); // expected: 1
        System.out.println("Case 3: " + equivalentArrays2(new int[]{0, 5, 5, 1, 2, 1}, new int[]{5, 2, 0, 1})); // expected: 1
        System.out.println("Case 4: " + equivalentArrays2(new int[]{0, 2, 1, 2}, new int[]{3, 2, 0, 1})); // expected: 0
        System.out.println("Case 5: " + equivalentArrays2(new int[]{}, new int[]{3, 2, 0, 1})); // expected: 0
        System.out.println("Case 6: " + equivalentArrays2(new int[]{}, new int[]{})); // expected: 1
    }

    public static int equivalentArrays1(int[] a1, int[] a2) {
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int val : a1) {
            lookup.put(val, val);
        }

        for (int val : a2) {
            if (!lookup.containsKey(val)) {
                return 0;
            }
        }
        return 1;
    }

    public static int equivalentArrays2(int[] a1, int[] a2) {
        int minLen = a1.length > a2.length ? a2.length : a1.length;
        int[] unique = new int[minLen];
        int uniqueCount = 0;

        for (int i = 0; i < a1.length; i++) {
            int val = a1[i];
            if (!hasItem(unique, val)) {
                unique[uniqueCount++] = val;
            }
        }

        for (int i = 0; i < a2.length; i++) {
            int val = a2[i];
            if (!hasItem(unique, val)) {
                return 0;
            }
        }
        return 1;
    }

    public static int equivalentArrays3(int[] a1, int[] a2) {
        boolean[] matchedA2 = new boolean[a2.length];

        // Check every element in array a1
        for (int i = 0; i < a1.length; i++) {
            boolean matched = false;
            for (int j = 0; j < a2.length; j++) {
                if (a1[i] == a2[j] && !matchedA2[j]) {
                    // We have a match that hasn't been used before
                    matchedA2[j] = true;
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                // No match was found for a1[i]
                return 0;
            }
        }

        // Check if all elements in a2 were matched
        for (boolean wasMatched : matchedA2) {
            if (!wasMatched) {
                // If any value in a2 was not matched, the arrays aren't equivalent
                return 0;
            }
        }

        // All elements were matched
        return 1;
    }

    private static boolean hasItem(int[] arr, int item) {
        boolean inside = false;
        for (int j = 0; j < arr.length; j++) {
            if (item == arr[j]) {
                inside = true;
            }
        }
        return inside;
    }
}
