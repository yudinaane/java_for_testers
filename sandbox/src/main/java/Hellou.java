public class Hellou {
    public static void main(String[] args){
        try{
            var x=1;
            var y=1;
            if (y==0){
                System.out.println("Деление на ноль запрещено");
            } else {
                var z = divide(x, y);
                System.out.println("Hello,word!");
            }

    } catch (ArithmeticException exeption){
        System.out.println("Деление на ноль запрещено");
    }
}

    private static int divide(int x, int y) {
    var z= x / y;
    return z;
}
    }

