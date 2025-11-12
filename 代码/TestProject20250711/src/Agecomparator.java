import java.util.Comparator;

/**
    @author pluchon
    @create 2025-07-11-15:22
    作者代码水平一般，难免难看，请见谅
*/public class Agecomparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.age - o2.age;
    }
}
