import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculatePerimeterTriangle(){
        Assertions.assertEquals(12., Triangle.calculatePerimeterTriangle(5., 4., 3.));
    }
    @Test
    void canCalculateSquareTriangle(){
        Assertions.assertEquals(6., Triangle.calculateSquareTriangle(5., 4., 3.));
    }

}
