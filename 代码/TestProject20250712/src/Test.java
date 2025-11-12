import javax.print.attribute.standard.PrinterState;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @author pluchon
 * @create 2025-07-12-14:35
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {
    public void eaa() throws ArithmeticException{
        int ret = 0;
        int simple = 5 / ret;
    }

    public int ea(){
        Scanner sc = new Scanner(System.in);
        int simple = sc.nextInt();
        try {
            int a = 5;
            int ret = 10 / simple;
            return ret;
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("捕获到了除0异常");
        }finally {
            System.out.println("finally代码块执行");
            sc.close();
            return 1;
        }
    }

    public void func() {
        try {
            int a = 0;
            int ret = 6 / a;
            int [] arrays = new int[2];
            arrays [5] = 0;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("捕获到了数组越界异常");
        }catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("捕获到了除0异常");
        }
    }

    public static void main1(String[] args) {
        Test test = new Test();
        //test.func();
//        int ret = test.ea();
//        System.out.println(ret);
        test.eaa();
    }
}
