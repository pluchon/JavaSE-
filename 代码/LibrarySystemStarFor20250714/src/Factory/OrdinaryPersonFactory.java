package Factory;

/**
 * @author pluchon
 * @create 2025-07-14-16:44
 * 作者代码水平一般，难免难看，请见谅
 */
public class OrdinaryPersonFactory implements PersonFactory {
    @Override
    public User user(String name, int id) {
        return new OrdinaryPerson(name,id);
    }
}
