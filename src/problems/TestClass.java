package problems;

import java.util.Date;

public class TestClass {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static void test() {
        System.out.println("Hello, World!");
    }

    private int calculateDayBetweenDates(Date date1, Date date2) {
        return date1 == null || date2 == null ? 0 : (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
    }

}
