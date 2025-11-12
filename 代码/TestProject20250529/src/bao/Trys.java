package bao;
import baobao.Persons;
import java.sql.SQLOutput;

/**
    @author pluchon
    @create 2025-05-29-10:34
    作者代码水平一般，难免难看，请见谅
*/public class Trys {
    public static void main(String[] args) {
        Students stu = new Students();
        System.out.println("在子类中访问同个包的学生类："+stu.money);
        Persons per = new Persons();
        //System.out.println(per.hands);
    }
}
