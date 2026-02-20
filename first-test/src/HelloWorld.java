import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args){
        Scanner KeyboardScanner0 = new Scanner(System.in);


//        System.out.println(123);
//        System.out.println(0x123123);//0x HEX
//        System.out.println(0b101010100001);//0b BINARY
//        System.out.println(074);//0 OCT

        float testPara1 = 0.1F;
        float testPara3 = 0.1f;
        double testPara2 = 0.11111;
        int testPara0 = 0;

        System.out.println(testPara1);
        System.out.println(testPara2);
        System.out.println(testPara3);
        for(int i=0;i<4;i++){
            testPara0 = KeyboardScanner0.nextInt();
            System.out.println(testPara0);
        }

        System.out.println("Say Hello 2 my LITTLEFRIEND");//TODO: need to be deleted
    }
}
