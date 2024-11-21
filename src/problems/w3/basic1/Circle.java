package problems.w3.basic1;

public class Circle {
    public static void main(String[] args) {
        printPerimeterAndAreaOfCircle();
    }

    public static void printPerimeterAndAreaOfCircle() {
        double radius = 7.5;

        System.out.println("Perimeter is: " + calculatePerimeter(radius));
        System.out.println("Area is: " + calculateArea(radius));
    }

    public static double calculateArea(double radius) {
        return Math.PI * (radius * radius);
    }

    public static double calculatePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }
}
