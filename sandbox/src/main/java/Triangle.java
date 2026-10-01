import java.util.Objects;

import static java.lang.Math.sqrt;

    public record Triangle (double side1, double side2, double side3) {
        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Triangle triangle = (Triangle) o;
            return (Double.compare(side1, triangle.side1) == 0 && Double.compare(side2, triangle.side2) == 0
                    && Double.compare(side3, triangle.side3) == 0)
            || (Double.compare(side1, triangle.side2) == 0 && Double.compare(side2, triangle.side1) == 0
                    && Double.compare(side3, triangle.side3) == 0)
            || (Double.compare(side1, triangle.side3) == 0 && Double.compare(side2, triangle.side1) == 0
                    && Double.compare(side3, triangle.side2) == 0)
            || (Double.compare(side3, triangle.side1) == 0 && Double.compare(side1, triangle.side2) == 0
                    && Double.compare(side2, triangle.side3) == 0)
            || (Double.compare(side3, triangle.side1) == 0 && Double.compare(side2, triangle.side2) == 0
                    && Double.compare(side1, triangle.side3) == 0)
            ;
        }

        @Override
        public int hashCode() {
            return Objects.hash(side1, side2, side3);
        }

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

