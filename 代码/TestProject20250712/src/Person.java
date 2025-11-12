/**
 * @author pluchon
 * @create 2025-07-12-15:45
 * 作者代码水平一般，难免难看，请见谅
 */
public class Person{
    String name = "zhangsan";
    int age = 10;

    void func(String names,int ages) throws NameException ,AgeException{
        if(!names.equals(name)){
            throw new NameException();
        }

        if(age != ages){
            throw new AgeException();
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        try {
            person.func("sss", 8);
        }catch (NameException | AgeException e){
            System.out.println("身份核对失败");
        }
    }
}
