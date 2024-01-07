package problems.w3.basic1;

public class SwapTwoVariables {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c;

        c = a;
        a = b;
        b = c;

        System.out.println("a=" + a + "\nb=" + b);
    }
}
