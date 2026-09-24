import static java.lang.Math.sqrt;

public record Triangle (double side1, double side2, double side3) {
    public static void main(String[] args) {
        printTrianglePerimeter(new Triangle(5.,4.,3.));
        printTriangleArea (new Triangle(5.,4.,3.));
    }

    public static void printTrianglePerimeter(Triangle p) {
        String text = String.format("Периметр треугольника со сторонами %f, %f и %f равен %f",
                p.side1, p.side2, p.side3, p.Perimeter() );
        System.out.println(text);
    }

    public static void printTriangleArea(Triangle s) {
        String text = String.format("Площадь треугольника по формуле Герона c полупериметром %f и сторонами " +
                        "%f, %f и %f равен %f", s.Perimeter()/2, s.side1, s.side1, s.side1, s.area());
        System.out.println(text);
    }


    public double Perimeter() {
        return this.side1+this.side2+this.side3;
    }

    public double area() {
        var semiPerimeter = Perimeter()/2;
        return sqrt(semiPerimeter *(semiPerimeter-this.side1)*(semiPerimeter-this.side2)*(semiPerimeter-this.side3));
    }
}
