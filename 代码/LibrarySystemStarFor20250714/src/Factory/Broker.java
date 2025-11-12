package Factory;

import Book.Library;

import Constant.Constant;//手动导包

import java.io.IOException;

/**
 * @author pluchon
 * @create 2025-07-14-17:50
 * 作者代码水平一般，难免难看，请见谅
 */
public class Broker {//代理类
    private User realName;//用来表示真正的用户名字
    private Library library = Library.getLibrary();//为对应用户类型操作进行服务，单例模式实现对象

    public Broker(User user) {
        realName = user;
    }//运用到了向上转型，因为User是所有用户类的父类

    public int display() {
        return realName.display();//通过对应的用户类型去调用对应的菜单
        //因为realName是User的实例化对象，运用到了向上转型
    }

    public User getRealUser() {//获取用户真实的信息
        return realName;
    }

    //查找图书，显⽰图书，退出系统是2个⻆⾊都有的⽅法，这些⽅法可以提出到Library当中，不需要区分
    private void checkRealUserWhetherAdminUser(String msg) throws PermissionException {
        if (!(realName instanceof ManagePerson)) {
            //⾃定义异常，⾃⼰定义即可
            throw new PermissionException(msg);
        }
    }

    //添加书籍操作
    public void addBook() throws PermissionException {
        //查看代理的对象是是不是管理员
        System.out.println("上架图书");
        checkRealUserWhetherAdminUser("普通用户无权限");
        //如果确实是管理员，就进不去上面异常
        ((ManagePerson) realName).addBook();
    }

    //更新书籍操作
    public void updateBook() throws PermissionException {
        checkRealUserWhetherAdminUser("普通⽤⼾没有权限更新图书");
        ((ManagePerson) realName).updateBook();
    }

    //移除图书
    public void removeBook() throws PermissionException {
        checkRealUserWhetherAdminUser("普通⽤⼾没有权限删除图书");//权限检查
        ((ManagePerson) realName).removeBook();
    }

    //查看图书的借阅次数
    public void borrowCount() throws PermissionException {
        checkRealUserWhetherAdminUser("普通⽤⼾没有权限查看图书的借阅次数");
        ((ManagePerson) realName).borrowCount();
    }

    //查看最受欢迎的前K本书
    public void generateBook() throws PermissionException {
        checkRealUserWhetherAdminUser("普通⽤⼾没有权限查看最受欢迎的前k本书");
        ((ManagePerson) realName).generateBook();
    }

    //查看库存状态
    public void checkInventoryStatus() throws PermissionException {
        checkRealUserWhetherAdminUser("普通⽤⼾没有权限查看库存状态");
        ((ManagePerson) realName).checkInventoryStatus();
    }

    //移除上架超过1年的书籍
    public void checkAndRemoveOldBooks() throws PermissionException {
        checkRealUserWhetherAdminUser("普通⽤⼾没有权限移除上架超过⼀年的图书");
        ((ManagePerson) realName).checkAndRemoveOldBooks();
    }

    //--------------------------------普通用户相关⽅法------------------------------//
    private void checkRealUserWhetherNormalUser(String exceptionMessage) throws PermissionException {
        if (!(realName instanceof OrdinaryPerson)) {
            throw new PermissionException(exceptionMessage);
        }
    }

    //归还图书
    public void returnBook() throws PermissionException, IOException {
        checkRealUserWhetherNormalUser("管理员请以普通⽤⼾的⽅式归还图书");
        ((OrdinaryPerson) realName).returnBook();
    }

    //查看个⼈借阅情况
    public void viewBorrowHistory() throws PermissionException {
        checkRealUserWhetherNormalUser("管理员请以普通⽤⼾的⽅式查看个⼈当前借阅情况");
        ((OrdinaryPerson) realName).viewBorrowBooks();
    }

    //再判断对象实例化过程中用户的类型，即检查对应权限
    //要把所有用户类型的所有可能的方法都写这
    public void borrowBook() throws PermissionException, IOException {
        checkRealUserWhetherNormalUser("管理员请以普通⽤⼾的⽅式借阅图书");
        ((OrdinaryPerson) realName).borrowBook();
        /*System.out.println("检查权限中......");
        if (realName instanceof OrdinaryPerson) {
            ((OrdinaryPerson) realName).borrowBook();
            //可以强转，因为类型以及判断，就是把realName转成对应类型
        } else if (realName instanceof ManagePerson) {
            System.out.println("管理员不用借书");
        } else {
            System.out.println("错误");
        }*/
    }

    //因为查找图书、显⽰图书、退出系统三种操作对于管理员和普通⽤⼾来说都是共⽤的，所以直接定义在Library当中
    //如果只是使⽤数字，别的程序员可能并不能读懂甚⾄过⼀段时间，自己也可能看不懂。所以定义为常量可以增加代码的可读性。
    public void handleOperation(int choice) throws PermissionException, IOException {
        //一切调用基础，跟管理类用户和普通类用户打通
        if (realName instanceof ManagePerson) {
            // 管理员操作
            switch (choice) {
                case Constant.SEARCH_BOOK:
                    library.searchBook();
                    break;
                case Constant.DISPLAY_BOOK:
                    library.displayBooks();
                    break;
                case Constant.EXIT:
                    library.exit();
                    break;
                case Constant.ADD_BOOK:
                    addBook();
                    break;
                case Constant.UPDATE_BOOK:
                    updateBook();
                    break;
                case Constant.REMOVE_BOOK:
                    removeBook();
                    break;
                case Constant.BORROWED_BOOK_COUNT:
                    borrowCount();
                    break;
                case Constant.GENERATE_BOOK:
                    generateBook();
                    break;
                case Constant.CHECK_INVENTORY_STATUS:
                    checkInventoryStatus();
                    break;
                case Constant.CHECK_AND_REMOVE_OLD_BOOK:
                    //10本为按类别统计书
                    checkAndRemoveOldBooks();
                    break;
                default:
                    System.out.println("⽆效的操作。");
            }
        } else if (realName instanceof OrdinaryPerson) {
            // 普通⽤⼾操作
            switch (choice) {
                case Constant.SEARCH_BOOK:
                    library.searchBook();
                    break;
                case Constant.DISPLAY_BOOK:
                    library.displayBooks();
                    break;
                case Constant.EXIT:
                    library.exit();
                case Constant.BORROWED_BOOK:
                    borrowBook();
                    break;
                case Constant.RETURN_BOOK:
                    returnBook();
                    break;
                case Constant.VIEW_BORROW_HISTORY_BOOK:
                    viewBorrowHistory();
                    break;
                default:
                    System.out.println("⽆效的操作。");
            }
        }
    }
}
