package problems.w3.basic1;

public class PrintJava {
    public static void main(String[] args) {
        String[] jPattern = {
                "   J",
                "   J",
                "J  J",
                " JJ "
        };

        String[] aPattern = {
                "   a   ",
                "  a a  ",
                " aaaaa ",
                "a     a"
        };

        String[] vPattern = {
                "V     V",
                " V   V ",
                "  V V  ",
                "   V   "
        };

        for (int i = 0; i < 4; i++) {
            System.out.println(jPattern[i] + aPattern[i] + vPattern[i] + aPattern[i]);
        }
    }
}
