package main.Servlet;

import main.Model.JavaBean.Result;
import main.Model.Service.TestService;
import main.Utils.ResultUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    private TestService testService = new TestService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String operate = req.getParameter("operate");
        if(operate.isEmpty()){
            operate = "index";
        }

        if(operate.equals("index")){
            index(req, resp);
        }
    }

    private Result<?> index(HttpServletRequest request, HttpServletResponse response){
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        System.out.println(account + " " + password);
        HttpSession session = request.getSession();
        System.out.println("This is index");
        return ResultUtils.success("");
    }
}
