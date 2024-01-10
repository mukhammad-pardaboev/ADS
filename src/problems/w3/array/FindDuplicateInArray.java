package problems.w3.array;

import java.util.*;

public class FindDuplicateInArray {
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 7, 7, 5, 4, 2, 2, 2, 4, 4, 4, 4};

        System.out.println("Duplicates: " + Arrays.toString(findDuplicates3(arr1)));
    }

    public static int[] findDuplicates1(int[] arr) {
        Map<Integer, Integer> lookup = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            Integer value = lookup.get(element);
            if (value != null) {
                if (value == 1) {
                    sb.append(element);
                }
                lookup.put(element, ++value);
            } else {
                lookup.put(element, 1);
            }
        }
        return sb.chars().map(Character::getNumericValue).toArray();
    }

    public static int[] findDuplicates2(int[] arr) {
        int[][] uniques = new int[arr.length][2];
        int[] duplicates = new int[arr.length / 2];
        int uniqueCount = 0;
        int duplicateCount = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < uniques.length; j++) {
                if (uniques[j][0] == arr[i]) {
                    if (uniques[j][1] == 1) {
                        duplicates[duplicateCount++] = arr[i];
                    }
                    uniques[j][1] += 1;
                    isUnique = false;
                }
            }
            if (isUnique) {
                uniques[uniqueCount][0] = arr[i];
                uniques[uniqueCount][1] = 1;
                uniqueCount++;
            }
        }
        return duplicates;
    }

    // ChatGPT suggested option: #1
    public static int[] findDuplicates3(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : arr) {
            if (seen.contains(num)) {
                duplicates.add(num);
            } else {
                seen.add(num);
            }
        }
        return duplicates.stream().mapToInt(Integer::intValue).toArray();
    }
}
