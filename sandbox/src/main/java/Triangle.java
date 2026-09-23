import static java.lang.Math.sqrt;

public class Triangle {

    public static void main(String[] args) {
        printPerimetrTriangle(5.,4.,3.);
        printSquareTriangle (5.,4.,3.);
           }

    public static void printPerimetrTriangle(double a, double b, double c) {
        String text = String.format("Периметр треугольника со сторонами %f, %f и %f равен %f", a, b, c, calculatePerimeterTriangle(a, b, c) );
        System.out.println(text);
    }
    public static double calculatePerimeterTriangle(double a, double b, double c) {
        return a + b + c;
    }
    public static void printSquareTriangle(double a, double b, double c) {
        String text = String.format("Площадь треугольника по формуле Герона c полупериметром %f и сторонами %f, %f и %f равен %f",
                calculatePerimeterTriangle(a, b, c)/2, a, b, c, calculateSquareTriangle(a, b, c));
        System.out.println(text);
    }

    public static double calculateSquareTriangle(double a, double b, double c) {
        var semiPerimeter = calculatePerimeterTriangle(a, b, c)/2;
        return sqrt(semiPerimeter *(semiPerimeter-a)*(semiPerimeter-b)*(semiPerimeter-c));
    }

}
