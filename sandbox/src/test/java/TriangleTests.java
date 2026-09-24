import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculatePerimeterTriangle(){
        var p = new Triangle(5., 4., 3.);
        double result = p.Perimeter();
        Assertions.assertEquals(12., result);
    }
    @Test
    void canCalculateSquareTriangle(){
        Assertions.assertEquals(6., new Triangle(5., 4., 3.).area());
    }

}
