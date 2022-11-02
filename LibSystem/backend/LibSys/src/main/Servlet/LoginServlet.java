package main.Servlet;

import main.Model.JavaBean.Admin;
import main.Model.JavaBean.Result;
import main.Model.Service.AdminService;
import main.Utils.ResponseUtils;
import main.Utils.ResultUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private AdminService adminService = new AdminService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String operate = req.getParameter("operate");
        if(operate.isEmpty()){
            operate = "login";
        }
        if(operate.equals("login")){
            login(req, resp);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Admin admin = adminService.getAdminByAccount(account);
        Result result = new Result();
        if(admin.getPassword().equals(password)){
            result.setCode(200);
            result.setMsg("LoginSuccess");
            ResponseUtils.responseByJson(response, result);
        }
        else{
            result.setCode(400);
            result.setMsg("LoginFail");
            ResponseUtils.responseByJson(response, result);
        }
//        System.out.println(account + " " + password);
    }
}
