import com.sun.tools.javac.Main;

import java.util.Arrays;

/**
 * @author pluchon
 * @create 2025-05-25-21:19
 * 作者代码水平一般，难免难看，请见谅
 */
public class Try {
    //只写关键的代码，不写简单冗余的代码
    public static void main1(String[] args) {
        //二维数组补充
        int [] [] array = new int [] []{{1,2,3},{4,5,6}};
        for(int [] tmp:array){
            for(int x:tmp){
                System.out.print(x+" ");
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.deepToString(array));
        int [] [] array1 = new int [2] [];
        array1[0] = new int [3];
        array1[1] = new int [3];
        System.out.println(Arrays.deepToString(array1));
    }

    public static void swap (MyValue myValue1,MyValue myValue2){
        int tmp = myValue1.val;
        myValue1.val = myValue2.val;
        myValue2.val = tmp;
    }

    public static void main(String[] args) {
        Student stu1 = new Student(19,180,"zlh");
        System.out.println(stu1);
        //MyValue myValue1 = new MyValue();
        //myValue1.val = 10;
        //MyValue myValue2 = new MyValue();
        //myValue2.val = 20;
        //System.out.println();
        //System.out.println("调换前："+myValue1.val+" "+myValue2.val);
        //System.out.println("---------------");
        //swap(myValue1,myValue2);//传两个对象，即引用传值
        //System.out.println("调换后："+myValue1.val+" "+myValue2.val);
    }
}
