import static java.lang.Math.sqrt;

    public record Triangle (double side1, double side2, double side3) {

        public Triangle {
            if (side1 < 0 || side2 < 0 || side3 < 0) {
                throw new IllegalArgumentException
                        ("Сторона у треугольника НЕ может быть отрицательной");
            }
            if ((side1 +side2 < side3) || (side2+side3 < side1) ||(side3 + side1< side2)) {
                throw new IllegalArgumentException
                        ("Нарушено неравенство треугольника");
            }

        }

    }

