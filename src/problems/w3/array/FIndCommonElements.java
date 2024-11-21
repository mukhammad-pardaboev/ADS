package problems.w3.array;

import java.util.*;
import java.util.stream.Collectors;

public class FIndCommonElements {
    public static void main(String[] args) {
        String[] str1 = {"cat", "dog", "cat", "bear", "cow", "bull", "chicken"};
        String[] str2 = {"cat", "dog", "cat", "cow", "sheep", "hen"};

        System.out.println("Commons: " + Arrays.toString(findCommons2(str1, str2)));
    }

    public static String[] findCommons1(String[] str1, String[] str2) {
        Set<String> unique1 = new HashSet<>(Arrays.asList(str1));
        Set<String> unique2 = new HashSet<>(Arrays.asList(str2));

        return unique1
                .stream()
                .filter(unique2::contains)
                .collect(Collectors.toList())
                .toArray(String[]::new);
    }

    public static String[] findCommons2(String[] str1, String[] str2) {
        String[] commons = new String[0];
        int counter = 0;

        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    boolean isIn = false;
                    for (int k = 0; k < commons.length; k++) {
                        if (commons[k] == str1[i]) {
                            isIn = true;
                        }
                    }
                    if (!isIn) {
                        commons = addElement(commons, str1[i]);
                    }
                }
            }
        }
        return commons;
    }

    private static String[] addElement(String[] str, String el) {
        String[] newStrArray = new String[str.length + 1];
        for (int i = 0; i < str.length; i++) {
            newStrArray[i] = str[i];
        }
        newStrArray[str.length] = el;
        return newStrArray;
    }
}
