package demo2;

import java.sql.SQLOutput;

/**
 * @author pluchon
 * @create 2025-07-11-16:14
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {
    private int age = 8;
    public double high;
    static int month;

    static class InnerA{
        private String name = "ss";
        public double weight;

        Test test = new Test();

        void S(){
            System.out.println(test.age);
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        Test.InnerA a = new Test.InnerA();
    }
}
