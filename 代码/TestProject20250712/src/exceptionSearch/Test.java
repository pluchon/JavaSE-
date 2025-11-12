package exceptionSearch;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author pluchon
 * @create 2025-07-12-21:25
 * 作者代码水平一般，难免难看，请见谅
 */
public class Test {
    public static void main1(String[] args) {
        try {
            Object[] student = new Person[2];//此时student对象指向的是Person类
            student[0] = new Person();//此时第一个元素存放Person类的对象可以
            student[1] = new Teacher();//但是存储其他类对象就会抛出异常
        }catch (ArrayStoreException e){
            e.printStackTrace();
            System.out.println("抛出了数组引用异常");
        }
    }

    public static void main2(String[] args) {
        try{
            Person person = new Teacher();//此时的person指的是老师
            Student student = (Student) person;//此时你又把person原本指的是老师强转成学生
        }catch(ClassCastException e){
            e.printStackTrace();
            System.out.println("抛出了对象指向错误异常");
        }
    }

    public static void main3(String[] args) {
        try{
            LocalDate localDate = LocalDate.of(2023,13,1);
        }catch (DateTimeException e){
            e.printStackTrace();
            System.out.println("时间非法");
        }
        try {
            LocalTime localTime = LocalTime.of(25,25);
        }catch (DateTimeException e){
            e.printStackTrace();
            System.out.println("时间非法");
        }
        try {
            String time = "2025-1-32";
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
            LocalDate.parse(time, dateTimeFormatter);
        }catch (DateTimeException e){
            System.out.println("时间非法");
        }
    }

    public static void main4(String[] args) {
        try {
            int ret = -10;
            if (ret <0){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("数值有问题");
        }
        try {
            String name = null;
            if(name == null){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("名字异常");
        }
    }

    public static void main(String[] args) {
        try {
            int[] a = new int[]{0, 1};
            a [3] = 10;
        }catch (IndexOutOfBoundsException e){
            System.out.println("数组越界异常");
        }
        try{
            String str = "abcd";
            char ret = str.charAt(5);
        }catch (IndexOutOfBoundsException e){
            System.out.println("字符获取失败");
        }
    }
}
