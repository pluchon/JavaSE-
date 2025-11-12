package demo4;

import java.util.Arrays;

/**
 * @author pluchon
 * @create 2025-07-11-22:37
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {
    public static void bubbleSort(Comparable [] comparables){
        for (int i = 0; i < comparables.length-1; i++) {
            for (int j = i; j <comparables.length-1-i; j++) {
                //判断交换
                if(comparables[j].compareTo(comparables[j+1])>0){
                    Comparable comparable = comparables[j];
                    comparables[j] = comparables [j+1];
                    comparables [j+1] = comparable;
                }
            }
        }
    }

    interface Ss{
        void abc();
    }

    public static void main(String[] args) {
        String str = "abc=bbc,hjk=xyz";
        String [] ret = str.split(",");
        for(String rets : ret){
            String [] retss = rets.split("=");
            for (String retsss :retss){
                System.out.println(retsss);
            }
        }
    }

    public static void main1(String[] args) throws CloneNotSupportedException {
        Ss ss = new Ss(){
            @Override
            public void abc(){
                System.out.println("abc");
            }
        };
        ss.abc();

        Person person1 = new Person(15,"abc");
        Person person2 = (Person) person1.clone();
        System.out.println(person1.highs.high);
        System.out.println(person2.highs.high);
        person2.highs.high = 180.0;
        System.out.println(person1.highs.high);
        System.out.println("我们不难发现上面的high是一样的，而且person2改动person1也会变");
    }
}
