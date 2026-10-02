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
    @Test
    void TestEqaulity (){
        var t1 = new Triangle(1.,2.,3.);
        var t2 =  new Triangle (1.,2.,3.);
        Assertions.assertEquals (t1, t2);
    }


    @Test
    void TestEqaulity2 (){
        var a=1;
        var b=2;
        var c=3;
        var t1 = new Triangle(a,b,c);
        var t2 =  new Triangle (a,c,b);
        Assertions.assertEquals (t1, t2);
    }
    }









