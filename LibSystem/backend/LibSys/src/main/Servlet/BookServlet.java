package main.Servlet;

import main.Model.Service.BookService;
import main.Utils.ResponseUtils;
import main.Utils.ResultUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private BookService bookService = new BookService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String operate = req.getParameter("operate");
        if(operate.isEmpty()){
            operate = "getBookByBookName";
        }

        if(operate.equals("getBookByBookName")){
            getBookByBookName(req, resp);
        }else if(operate.equals("getBookList")){
            getBookList(req, resp);
        }
    }

    private void getBookByBookName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String searchBy = request.getParameter("searchBy");
        String info = request.getParameter("info");
        ResponseUtils.responseByJson(response, ResultUtils.success(bookService.getBookByBookInfo(searchBy, info)));
    }

    private void getBookList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResponseUtils.responseByJson(response, ResultUtils.success(bookService.getBookList()));
    }
}
