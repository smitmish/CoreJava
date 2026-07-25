public class CastingCoversionExample {
    void main(){
        byte b = 127;
        System.out.println("b="+b);
        // byte b1 = 256;
        // error: cannot convert from int to byte
        int a = b; //type conversion happening implicitly.
        System.out.println("a="+a);
        int a1 = 256;
        byte b1 = (byte) a1; //casting conversion happening explicitly, output=0, 256%256=0.
        System.out.println("b1="+b1);
        int a2 = 257;
        byte b2 = (byte) a2; //casting conversion happening explicitly, output=1, 257%256=1.
        System.out.println("b2="+b2);
        float f = 5.6f;
        System.out.println("f="+f);
        int a3 = (int) f; //casting conversion happening explicitly, output=5, 
        // decimal part is truncated.
        System.out.println("a3="+a3);

        //type promotion example
        byte b3 = 10;
        byte b4 = 30;
        //byte b5 = b3 * b4; //error: cannot convert from int to byte, 
        // because b3 and b4 are promoted to int before multiplication.
        int result = b3 * b4; //type promotion happening implicitly, 
        // as result of multiplication is int.
        System.out.println("result="+result);
    }

}
