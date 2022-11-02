package main.Model.Service;

import main.Model.JavaBean.Book;
import main.Utils.DBUtils;

import java.util.List;

public class BookService {
    public List<Book> getBookByBookInfo(String searchBy, String info){
        String sql = "select * from Book where " + searchBy + " = ?";
        return DBUtils.queryList(Book.class, sql, info);
    }

    public List<Book> getBookList(){
        String sql = "select * from Book";
        return DBUtils.queryList(Book.class, sql);
    }

    public void updateBookById(int bId, String ISBN, String type, Double price, String publisher, String bookName){
        String sql = "update Book set ISBN = ? type = ? price = ? publisher = ? bookName = ? where bId = ?";
        DBUtils.update(sql, ISBN, type, type, price, publisher, bookName, bId);
    }

    public void deleteBookById(int bId){
        String sql = "delete from Book where bId = ?";
        DBUtils.update(sql, bId);
    }

}
