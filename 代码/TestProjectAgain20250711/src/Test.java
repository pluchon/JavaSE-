import java.rmi.Naming;
import java.util.Arrays;

/**
 * @author pluchon
 * @create 2025-07-11-17:07
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abc").append("def");
        stringBuilder.append("ssss");
        System.out.println(stringBuilder);
    }

    public static void main7(String[] args) {
        char [] ch = new char[]{'a','b','c'};
        String s1 = new String(ch);
        s1.intern();
        String s2 = "abc";
        System.out.println(s1 == s2);
        System.out.println(Integer.toHexString(System.identityHashCode(s1)));
        System.out.println(Integer.toHexString(System.identityHashCode(s2)));
    }

    public static void main6(String[] args) {
        String str = "hello world";
        String ret = str.substring(5);
        String rets = str.substring(1,5);
        System.out.println(ret+" "+rets);
    }

    public static void main5(String[] args) {
        String str = String.format("%d-%d-%d",2025,7,11);
        System.out.println(str);
        String str1 = "hello world";
        String ret1 = str1.replace('o','s');
        String ret2 = str1.replace("ll","sssss");
        System.out.println(ret1);
        System.out.println(ret2);
        String [] rets = str1.split(" ");
        System.out.println(Arrays.toString(rets));
        String str2 = "a b c d e";
        String [] ret3 = str2.split(" ",2);
        System.out.println(Arrays.toString(ret3));
    }

    public static void main4(String[] args) {
        String str = "123";
        int ret = Integer.parseInt(str);
        double rets = Double.parseDouble(str);
    }

    public static void main3(String[] args) {
        String str = String.valueOf(new Person(12,"张三"));
        System.out.println(str);
    }

    public static void main2(String[] args) {
        String str1 = "hello world";
        int ret = str1.indexOf('e');
        int ret2 = str1.indexOf('o',2);
        int ret3 = str1.indexOf("world");
        int ret4 = str1.indexOf("world",5);
        System.out.println(ret);
        System.out.println(ret2);
        System.out.println(ret3);
    }
    public static void main1(String[] args) {
        String str1 = "hello world";
        char ret = str1.charAt(2);
        System.out.println(ret);
        for (int i = 0; i < str1.length(); i++) {
            System.out.print(str1.charAt(i));
        }
    }
}
