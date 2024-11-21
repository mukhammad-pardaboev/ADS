package problems.w3.basic1;

public class ReverseString {
    public static void main(String[] args) {
        String st = "The quick brown fox";
        solution3(st);
    }

    public static void solution1(String st) {
        for (int i = st.length() - 1; i >= 0; i--) {
            System.out.print("Reverse: " + st.charAt(i));
        }
    }

    public static void solution2(String st) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = st.length() - 1; i >= 0; i--) {
            stringBuilder.append(st.charAt(i));
        }
        System.out.println("Reverse: " + stringBuilder);
    }
    public static void solution3(String st) {
        StringBuilder stringBuilder = new StringBuilder(st).reverse();
        System.out.println("Reverse: " + stringBuilder);
    }
}
