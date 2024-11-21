package problems.w3.basic1;

public class Rectangle {
    public static void main(String[] args) {
        printPerimeterAndAreaOfRectangle();
    }

    public static void printPerimeterAndAreaOfRectangle() {
        double width = 5.5;
        double height = 8.5;

        System.out.println("Perimeter is: " + calculatePerimeter(width, height));
        System.out.println("Area is: " + calculateArea(width, height));
    }

    public static double calculateArea(double width, double height) {
        return width * height;
    }

    public static double calculatePerimeter(double width, double height) {
        return 2 * (width + height);
    }
}
