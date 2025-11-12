package demo3;

/**
    @author pluchon
    @create 2025-07-11-16:40
    作者代码水平一般，难免难看，请见谅
*/public class Test {
    public static void main(String[] args) {
        String str1 = "sss";
        String str2 = "sss";
        System.out.println(str1 == str2);
        String str3 = new String("aaa");
        String str4 = new String("aaa");
        System.out.println(str3 == str4);
    }
}
