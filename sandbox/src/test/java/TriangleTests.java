import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TriangleTests {

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(3, 4, 8);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }

    @Test
        void cannotCreateTriangleInequality (){
        try {
            new Triangle(1, 2, 10);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }

    }








