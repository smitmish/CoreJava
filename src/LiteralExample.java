public class LiteralExample {
    void main(){
        System.out.println("Hello, World!");
        int num = 0b101;
        System.out.println("num="+num);
        int num2 = 0x7e;
        System.out.println("num2="+num2);
        int num3 = 10_00_00_000;
        System.out.println("num3="+num3);
        double num4 = 12e10;
        System.out.println("num4="+num4);   
        boolean bool = true;
        System.out.println("bool="+bool);
        char ch = 'c';
        System.out.println("ch="+ch);   
        ch = (char)(ch + 1);
        System.out.println("ch="+ch);
        ch++;
        System.out.println("ch="+ch);
    }
}
