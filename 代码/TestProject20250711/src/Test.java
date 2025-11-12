import java.util.Arrays;

/**
 * @author pluchon
 * @create 2025-07-11-14:25
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {
    public static void main(String[] args) {
        Person person1 = new Person(15,"张三");
        Person person2 = new Person(12,"李四");

//        int ret = person1.compareTo(person2);
//
        Namecomparator namecomparator = new Namecomparator();
//        int rets = namecomparator.compare(person1,person2);
//        if(rets>0){
//            System.out.println("person1>person2");
//        }
        Person person3 = new Person(10,"王五");
        Person [] person = new Person[3];
        person[0] = person1;
        person[1] = person2;
        person[2] = person3;

        System.out.println("这是排序前"+Arrays.toString(person));
        Arrays.sort(person);
        //System.out.println(Arrays.toString(person));
        Arrays.sort(person,namecomparator);
        System.out.println(Arrays.toString(person));
    }
}
