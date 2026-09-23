import static java.lang.Math.sqrt;

public class Triangle {

    public static void main(String[] args) {
        printPerimPerimetrTriangle(5.,4.,3);
        printSquareTriangle (5.,4.,3.);
           }

    private static void printPerimPerimetrTriangle(double a, double b, double c) {
        String text = String.format("Периметр треугольника со сторонами %f, %f и %f равен %f", a, b, c, calculatePerimetrTriangle(a, b, c) );
        System.out.println(text);
    }
    private static double calculatePerimetrTriangle(double a, double b, double c) {
        return a + b + c;
    }
    private static void printSquareTriangle(double a, double b, double c) {
        String text = String.format("Площадь треугольника по формуле Герона c полупериметром %f и сторонами %f, %f и %f равен %f",
                calculatePerimetrTriangle(a, b, c)/2, a, b, c, calculateSquareTriangle(a, b, c));
        System.out.println(text);
    }

    private static double calculateSquareTriangle(double a, double b, double c) {
        var semiPerimetr=calculatePerimetrTriangle(a, b, c)/2;
        return sqrt(semiPerimetr*(semiPerimetr-a)*(semiPerimetr-b)*(semiPerimetr-c));
    }

}
