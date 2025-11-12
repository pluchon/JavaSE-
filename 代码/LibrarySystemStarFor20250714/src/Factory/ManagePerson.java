package Factory;

import Book.Library;//不导这个包会报错
import Book.Book;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author pluchon
 * @create 2025-07-14-17:25
 * 作者代码水平一般，难免难看，请见谅
 */
public class ManagePerson extends User{
    public Scanner scanner = new Scanner(System.in);
    public Library library = Library.getLibrary();//上面导包的问题，单例模式实现图书馆对象

    public ManagePerson(String name, int id) {
        super(name, id,"管理员");
    }

    @Override
    public int display() {
        System.out.println("管理员 " + name + " 的操作菜单:");
        System.out.println("1. 查找图书");
        System.out.println("2. 打印所有的图书");
        System.out.println("3. 退出系统");
        System.out.println("4. 上架图书");
        System.out.println("5. 修改图书");
        System.out.println("6. 下架图书");
        System.out.println("7. 统计借阅次数");
        System.out.println("8. 查看最受到欢迎的前K本书");
        System.out.println("9. 查看库存状态");

        //这两个方法还没有实现
        //System.out.println("11. 按类别统计图书 ");
        //System.out.println("12. 按作者统计图书 ");

        System.out.println("10. 检查超过⼀年未下架的图书");
        System.out.println("请选择你的操作：");
        return scanner.nextInt();
    }

    //这里存在问题，每次上架图书Id都是5
    public void addBook() {
        scanner.nextLine();
        System.out.println("请输⼊书名：");
        String title = scanner.nextLine(); // 输⼊书名
        System.out.println("请输⼊作者：");
        String author = scanner.nextLine(); // 输⼊作者
        System.out.println("请输⼊类别：");
        String category = scanner.nextLine(); // 输⼊图书类别
        System.out.println("请输⼊出版年份：");
        int year = scanner.nextInt(); // 输⼊出版年份
        //scanner.nextLine(); // 吞掉换⾏符
        LocalDate shelfDate = LocalDate.now(); // 当前时间作为上架时间
        Book newBook = new Book(title, author, category, year, shelfDate);
        // 创建新书对象
        // 调⽤图书类 添加图书
        library.addBook(newBook);
    }

    //图书修改 ⽀持修改书名 作者 类别
    public void updateBook() {
        //1. 先展⽰⼀下⽬前的所有书籍
        library.displayBooks();
        System.out.println("请输⼊要修改的图书id：");
        int bookId = scanner.nextInt();
        // 吞掉换⾏符
        scanner.nextLine();
        // 获取对应的图书
        Book book = library.searchById(bookId);
        if(book == null) {
            System.out.println("没有ID为："+bookId+" 的书籍！");
            return;
        }
        System.out.println("当前书名：" + book.getTitle());
        System.out.println("请输⼊新的书名：");
        String newTitle = scanner.nextLine(); // 输⼊新的书名
        System.out.println("当前作者：" + book.getAuthor());
        System.out.println("请输⼊新的作者：");
        String newAuthor = scanner.nextLine(); // 输⼊新的作者
        System.out.println("当前类别：" + book.getCategory());
        System.out.println("请输⼊新的类别：");
        String newCategory = scanner.nextLine(); // 输⼊新的类别
        //更新对应书籍的信息
        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        book.setCategory(newCategory);
        library.updateBook(book);
    }

    //删除书籍
    public void removeBook() {
        //1.展⽰⼀下所有的图书
        library.displayBooks();
        System.out.println("请输⼊要删除的图书的ID：");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // 吞掉换⾏符
        //记录⼀下删除的图书对象
        Book removeBook =library.searchById(bookId);
        //开始删除
        library.removeBook(bookId);
        System.out.println("图书："+removeBook.getTitle()+" 已经被删除！");
    }

    //统计每本书的借阅次数
    public void borrowCount() {
        //不需要准备其他⼯作，直接调⽤具体的业务实现
        library.borrowCount();
    }

    //查询最受欢迎的前n本书
    public void generateBook() {
        System.out.println("请输⼊你要查看的最受欢迎的前K本书,注意k值不能超过："+library.getBookCount());
        int k = scanner.nextInt();
        if(k <= 0 || k > library.getBookCount()) {
            System.out.println("没有最受欢迎的前"+k+"本书！");
            return;
        }
        library.generateBook(k);
    }

    //查看库存状态
    public void checkInventoryStatus() {
        library.checkInventoryStatus();
    }

    //待实现
    //按照类别 统计图书
    public void categorizeBooksByCategory() {
    }

    //按照作者统计图书
    public void categorizeBooksByAuthor() {
    }

    //并移除上架超过⼀年的图书
    public void checkAndRemoveOldBooks() {
        library.checkAndRemoveOldBooks();
    }

    //退出系统方法，我们可以直接调用Library类中的退出系统方法就好
    /*public void exit() {
        library.exit();//共同代码无需重复编写
    }*/
}
