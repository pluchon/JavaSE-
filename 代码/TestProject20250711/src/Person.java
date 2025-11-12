/**
 * @author pluchon
 * @create 2025-07-11-14:28
 * 作者代码水平一般，难免难看，请见谅
 */
public class Person implements Comparable<Person> {
    public int age;
    public String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
//        if(this.age >o.age){
//            return 1;
//        }else if(this.age == o.age){
//            return 0;
//        }else{
//            return -1;
//        }
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
