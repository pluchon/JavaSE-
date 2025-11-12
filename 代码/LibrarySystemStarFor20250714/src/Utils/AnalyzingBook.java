package Utils;

import Book.Book;
import Constant.Constant;
import com.bit.utils.FileUtils;

import java.time.LocalDate;
/**
 * @author pluchon
 * @create 2025-07-15-15:50
 * 作者代码水平一般，难免难看，请见谅
 */
public class AnalyzingBook {//专门管理文件写入即图书存放

    public void storeObject(Book[] books, String filename) {
        //先遍历books数组当中不为空的数据多少个?
        //在Books数组对中，其长度并不代表书籍个数，可能存在存不满情况
        int booksUseLen = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                booksUseLen++;
            }
        }

        StringBuilder jsonArray = new StringBuilder();
        for (int i = 0; i < booksUseLen; i++) {
            if (books[i] != null) {
                jsonArray.append(books[i].toJSON());
                if (i != booksUseLen - 1) {
                    //⼀本书籍完成后以\n进⾏分割，直到最后一本书籍分割完毕
                    jsonArray.append("\n");
                }
            }
        }

        //数据写⼊⽂件
        FileUtils.writeFile(jsonArray.toString(), filename);
    }

    public Book[] loadObject(String filename) {
        System.out.println("DEBUG: loadObject started for file: " + filename);
        //从⽂件读取数据
        //怎么存的就怎么读，我们先把\n作为一个个书籍的对象进行切割，得到一个个字符串

        //先判断有没有书籍
        String content = FileUtils.readFile(filename);
        if (content == null || content.isEmpty()) {
            System.out.println("File is empty or does not exist: " + filename);
            return null;
        }

        //2. 使⽤\n作为分隔符进⾏字符串分割
        //当我们去读取时候发现最后一行有系统自带的\n
        //我们通过\n分隔来遍历，
        String[] bookJsonStrings = content.split("\n");//临时读取功能的数组

        //3. 把对应字符串“组装”成书籍对象
        Book[] bookList = new Book[bookJsonStrings.length];//有几本书对应几个数组元素，其长度就是多少
        //使得bookJsonStrings数组中每个元素都等于一个book对象
        for (int i = 0; i < bookJsonStrings.length; i++) {
            Book book = parseBookJson(bookJsonStrings[i]);
            bookList[i] = book;
        }

        System.out.println("DEBUG: loadObject finished for file: " + filename);
        return bookList;
    }

    private Book parseBookJson(String json) {
        System.out.println("DEBUG: parseBookJson started for json: " + json);
        //解析数据
        //之前我们把文件中每一行作为一个book对象，现在我们需要针对book对象中各个属性进行归位
        //以“，”分隔，逐个去读取信息

        //1. 检查json是否是空的
        if (json.isEmpty()) {
            return null;
        }

        //2. 使⽤逗号分割出每个属性的值
        String[] pairs = json.split(",");

        //3. 每个属性进⾏转化赋值，对应Book类中的成员变量，因为方法返回值是Book类
        int bookId = Integer.parseInt(pairs[0]);
        String title = pairs[1];
        String author = pairs[2];
        String category = pairs[3];
        int publishYear = Integer.parseInt(pairs[4]);
        boolean isBorrowed = Boolean.parseBoolean(pairs[5]);
        int borrowCount = Integer.parseInt(pairs[6]);
        LocalDate shelfDate = LocalDate.parse(pairs[7]);

        //构造书籍对象，针对每一本书籍的对象
        if (title != null && author != null && category != null && shelfDate != null) {
            Book book = new Book(title, author, category, publishYear, shelfDate);
            book.setBorrowed(isBorrowed);
            book.setBorrowCount(borrowCount);
            book.setBookId(bookId);
            return book;
        }
        System.out.println("DEBUG: parseBookJson finished for json: " + json);
        return null;
    }
}
