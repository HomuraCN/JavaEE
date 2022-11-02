package main.Servlet;

import main.Model.Service.ReaderService;
import main.Utils.ResponseUtils;
import main.Utils.ResultUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reader")
public class ReaderServlet extends HttpServlet {
    private ReaderService readerService = new ReaderService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String operate = req.getParameter("operate");
        if(operate.isEmpty()){
            operate = "queryReaderList";
        }

        if(operate.equals("queryReaderList")){
            queryReaderList(req, resp);
        } else if (operate.equals("updateReaderListById")) {
            updateReaderListById(req, resp);
        }
    }

    private void queryReaderList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResponseUtils.responseByJson(response, ResultUtils.success(readerService.getReaderList()));
    }
    private void updateReaderListById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        String borrowingTimes = request.getParameter("borrowingTimes");
        String rid = request.getParameter("rid");
        System.out.println(account);
        readerService.updateReaderListById(Integer.parseInt(rid), account, password, type, Integer.parseInt(borrowingTimes));
        ResponseUtils.responseByJson(response, ResultUtils.success());
    }
}
