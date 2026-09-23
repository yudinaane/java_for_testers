import static java.lang.Math.sqrt;

public class Triangle {

    public static void main(String[] args) {
        printPerimPerimetrTriangle(5.,4.,3);
        printSquareTriangle (5.,4.,3.);
           }

    private static void printPerimPerimetrTriangle(double a, double b, double c) {
        System.out.println("Периметр треугольника со сторонами " + a + ", " + b + ", " + c + " равен " + calculatePerimetrTriangle(a, b, c));
    }

    private static double calculatePerimetrTriangle(double a, double b, double c) {
        return a + b + c;
    }
    private static void printSquareTriangle(double a, double b, double c) {
        System.out.println("Площадь треугольника по формуле Герона c полупериметром " + calculatePerimetrTriangle(a, b, c)/2 + " и сторонами " + a + ", " + b + ", " + c + " равен " + calculateSquareTriangle(a, b, c));
    }

    private static double calculateSquareTriangle(double a, double b, double c) {
        var semiPerimetr=calculatePerimetrTriangle(a, b, c)/2;
        return sqrt(semiPerimetr*(semiPerimetr-a)*(semiPerimetr-b)*(semiPerimetr-c));
    }

}
