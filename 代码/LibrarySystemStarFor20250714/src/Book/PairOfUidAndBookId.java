package Book;

/**
 * @author pluchon
 * @create 2025-07-15-17:39
 * 作者代码水平一般，难免难看，请见谅
 */
public class PairOfUidAndBookId {
    //这个类装门存放用户ID和书的ID
    //1,101:表⽰ID为1的⽤⼾借阅了ID为101的书籍

    private int userId;
    private int bookId;
    public PairOfUidAndBookId() {
    }

    public PairOfUidAndBookId(int userId, int bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    //把对象序列化为JSON字符串的形式
    public String toJson() {
        StringBuilder json = new StringBuilder();

        json.append(userId).append(",");
        json.append(bookId);
        //上面两行就是为了实现逗号后再拼接的字符串效果

        return json.toString();
    }
}
