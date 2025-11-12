package Book;

import Constant.Constant;
import Utils.AnalyzingBook;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pluchon
 * @create 2025-07-15-15:50
 * 作者代码水平一般，难免难看，请见谅
 */

//为什么要把Library设置成单例模式？
//因为不可能有多个图书馆，而且如果对Scanner类设置也不现实，不能修改原码

public class Library {//把文件内容读取到内存中来
    private Book[] books;//当前图书数组
    private int bookCount;//实际存储的图书数量
    private Scanner scanner = new Scanner(System.in);

    private static Library library;

    public static Library getLibrary(){//单例模式创建对象方法
        if(library == null){
            library = new Library();
        }
        return library;
    }

    //书籍解析
    private AnalyzingBook analyzingBook = new AnalyzingBook();
    //analyzingBook：为成员变量AnalyzingBook的引⽤

    private Library() {//private为单例模式修饰
        System.out.println("DEBUG: Library constructor started.");
        //当调⽤该构造⽅法的时候，要加载⽂件当中的数据进⾏到books数组当中，先判断有没有书，再进行长度判断
        loadAllBook();//调用读取文件方法，作为构造对象的基础
        System.out.println("DEBUG: Library constructor finished.");
    }

    //我们可以给一个默认值，即常量
    //如果现有数组大小小于它，就读取实际存放的图书，修改bookCount，否则就更新默认长度
    private void loadAllBook() {
        System.out.println("DEBUG: loadAllBook started.");
        //1. 读取⽂件内容
        Book[] allBook = analyzingBook.loadObject(Constant.ALL_BOOK_FILE_NAME);
        //默认⼤⼩为5
        books = new Book[Constant.CAPACITY];
        //2. 是否有数据 没有数据 有效书籍个数为 0
        if (allBook == null) {
            bookCount = 0;
        } else {
            //3. 查看实际书籍⻓度是多少 是否⼤于默认的⻓度5
            int allBookLen = allBook.length;
            //3.1 ⼤于默认⻓度 books数组 分配实际的⼤⼩
            if (allBookLen > books.length) {
                //按照实际情况进⾏分配数组内存
                books = new Book[allBookLen];
            } //3.2 把读到的元素进⾏赋值
            for (int i = 0; i < allBookLen; i++) {
                books[i] = allBook[i];
            } //4.修改实际有效书籍个数
            bookCount = allBookLen;
        }
        System.out.println("DEBUG: loadAllBook finished. bookCount: " + bookCount);
    }

    //存储图书到⽂件中
    private void storeBook() {
        analyzingBook.storeObject(books,Constant.ALL_BOOK_FILE_NAME);
    }

    public void searchBook(){//找书
        //不要这一行代码，会占用空行：scanner.nextLine();
        System.out.println("请输⼊你要查找的图书的名称：");
        String title = scanner.nextLine();
        Book book = search(title);
        if(book == null) {
            System.out.println("没有你要找的这本书，你查找的书名为："+title);
        }else {
            System.out.println("找到了你要查找的书，书的详细信息如下：");
            System.out.println(book);
        }
    }

    private Book search(String title) {
        loadAllBook();
        for (int i = 0; i < getBookCount(); i++) {
            Book book = books[i];
            if(book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void displayBooks(){
        System.out.println("当前图书馆当中所有的图书：");
        //更新⼀次⽂件当中的新数据
        loadAllBook();
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            System.out.println(book);
        }
    }

    public void exit(){
        System.out.println("退出系统！");
        System.exit(0);
    }

    //删除图书
    public void removeBook(int bookId) {
        int index = searchByIdReturnIndex(bookId);
        //开始删除 从当前位置的后边往前移动
        for (int i = index; i < bookCount-1; i++) {
            books[i] = books[i+1];
        }
        books[bookCount-1] = null;
        storeBook();
        bookCount--;
    }

    //更新图书
    public void updateBook(Book book) {
    //先找到该书是哪个下标
        int index = searchByIdReturnIndex(book.getBookId());
        books[index] = book;
    //⼀定要进⾏存储
        storeBook();
    }

    //根据bookId 返回 书籍索引位置
    private int searchByIdReturnIndex(int bookId) {
        loadAllBook();
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if(book.getBookId()==bookId) {
                return i;
            }
        }
        return -1;
    }

    public void addBook(Book book){//注意参数
        if(bookCount >= books.length) {
            System.out.println("图书馆已满，⽆法上架更多图书！");
            return;
        }
        //修改bookId为⾃增
        //这里是新加的代码
        if (bookCount > 0) {
            book.setBookId(books[bookCount - 1].getBookId() + 1);
        } else {
            book.setBookId(1);
        }
        books[bookCount++] = book;
        //此时存储数据的时候会把书籍对象全部存储，虽然部分属性没有输⼊赋值
        storeBook();
        System.out.println("图书 "+book.getTitle()+"上架成功！");
    }

    public void borrowCount(){
        loadAllBook();
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            System.out.println("书名:"+book.getTitle()+
                    " 借阅次数："+book.getBorrowCount());
        }
    }

    public Book searchById(int bookId) {
        loadAllBook();
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if(book.getBookId()==bookId) {
                return book;
            }
        }
        return null;
    }

    public int getBookCount(){
        return  bookCount;
    }

    //查询最受欢迎的前n本书
    public void generateBook(int k) {
        //1. 加载已有的全部的书籍
        loadAllBook();
        //2.把所有书籍放在 临时数据 进⾏排序
        Book[] tmp = new Book[getBookCount()];
        for (int i = 0; i < getBookCount(); i++) {
            tmp[i] = books[i];
        }
        //2.1 开始排序
        Arrays.sort(tmp);
        //3. 把前k本书拷⻉到新数组 可以不定义临时数组，直接输出前K个就⾏
        Book[] generateBooks = new Book[k];
        for (int i = 0; i < k; i++) {
            generateBooks[i] = tmp[i];
        }
        //4.打印新数组
        System.out.println("最受欢迎书籍如下：");
        for (int i = 0; i < generateBooks.length; i++) {
            Book book = generateBooks[i];
            System.out.println("索引: "+i+" 书名："+ book.getTitle()+" 作者："+
                    book.getTitle()+" 借阅次数："+book.getBorrowCount());
        }
    }

    //查看库存状态
    public void checkInventoryStatus() {
        loadAllBook();
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            String status = book.isBorrowed() ? "已借出" : "在馆";
            System.out.println("书名："+book.getTitle()+" ⽬前状态："+status);
        }
    }

    //移除上架超过⼀年的图书
    public void checkAndRemoveOldBooks() {
        loadAllBook();
        // 获取当前时间戳
        long currentTimestamp = System.currentTimeMillis();
        // 将当前时间戳转换为 LocalDate
        LocalDate currentDate = Instant.ofEpochMilli(currentTimestamp)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        boolean flg = false;
        for (int i = 0; i < getBookCount(); i++) {
            Book book = books[i];
            //获取当前书籍的上架时间
            LocalDate specifiedDate = book.getShelfDate();
            // 计算两个⽇期之间的差值（以年为单位）
            long yearsBetween = ChronoUnit.YEARS.between(specifiedDate,
                    currentDate);
            if (yearsBetween >= 1) {
                System.out.print("图书 " + book.getTitle() + " 已经上架超过⼀年，是否移除？ (y/n)：");
                scanner.nextLine();
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("y")) {
                    //确认删除调⽤remove⽅法进⾏删除
                    removeBook(i);
                    i--; // 因为后⾯的书已经向前移动，所以要重新检查当前索引位置
                }
                flg = true;
            }
        }
        if (!flg) {
            System.out.println("没有上架超过⼀年的图书！");
        }
    }

    //借阅图书
    public void borrowBook(int bookId) {
        loadAllBook();
        for (int i = 0; i < getBookCount(); i++) {
            Book book = books[i];
            if(book.getBookId()== bookId) {
                book.setBorrowed(true);
                book.incrementBorrowCount();
            }
        }
        storeBook();
    }

    //归还图书
    public void returnBook(int bookId) {
        loadAllBook();
        for (int i = 0; i < getBookCount(); i++) {
            Book book = books[i];
            if(book.getBookId()==bookId) {
                book.setBorrowed(false);
                book.decreaseBorrowCount();
            }
        }
        storeBook();
    }
}
