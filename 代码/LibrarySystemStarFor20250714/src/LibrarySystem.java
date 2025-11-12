import Factory.*;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author pluchon
 * @create 2025-07-14-16:45
 * 作者代码水平一般，难免难看，请见谅
 */
public class LibrarySystem {
    public static void main(String[] args) throws PermissionException, IOException {
        //工厂模式
        PersonFactory personFactory = new ManagePersonFactory();
        User managePerson = personFactory.user ("张三",1);
        PersonFactory person2 = new OrdinaryPersonFactory();
        User ordinaryPerson1 = person2.user("李四",2);
        User ordinaryPerson2 = person2.user("王五",3);

        System.out.println("===以下是代理模式===");
        Broker brokerManage = new Broker(managePerson);
        Broker brokerOrdinary1 = new Broker(ordinaryPerson1);
        Broker brokerOrdinary2 = new Broker(ordinaryPerson2);

        //测试用户类型登录
        LibrarySystem librarySystem = new LibrarySystem();
        Broker currentUser = librarySystem.selectProxyRole(brokerManage,brokerOrdinary1,brokerOrdinary2);
        while (true) {//所有调用的基础
            int choice = currentUser.getRealUser().display();
            //此时⽆需关系是 管理员还是普通⽤⼾，代理类会做权限判断
            currentUser.handleOperation(choice);//仅需完善权限判断方法，在代理类中进行判断
        }
    }

    //目前我们还遗留了根据不同用户类型去调用不同业务逻辑的问题
    //选择对应⻆⾊进⾏登录
    //我们传了三个对应的用户类型
    public Broker selectProxyRole(Broker proxyUserAdmin, Broker proxyUserNormalW,Broker proxyUserNormalL) {
        System.out.println("选择⻆⾊进⾏登录：");
        System.out.println("1.管理员（张三）\n2.普通⽤⼾(李四)\n3.普通⽤⼾(王五)\n4.退出系统");
        Broker currentUser = null;//决定用户类型的指向
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                currentUser = proxyUserAdmin;
                break;
            case 2:
                currentUser = proxyUserNormalW;
                break;
            case 3:
                currentUser = proxyUserNormalL;
                break;
            case 4:
                System.exit(0);
                System.out.println("系统已退出..");
                break;
            default:
                break;
        }
        return currentUser;
    }
}
