package main.Servlet;

import main.Model.Service.AdminService;
import main.Model.Service.BookService;
import main.Utils.ResponseUtils;
import main.Utils.ResultUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private AdminService adminService = new AdminService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String operate = req.getParameter("operate");
        if(operate.isEmpty()){
            operate = "queryAdminList";
        }

        if(operate.equals("queryAdminList")){
            queryAdminList(req, resp);
        } else if (operate.equals("updateAdminListById")) {
            updateAdminListById(req, resp);
        }
    }

    private void queryAdminList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResponseUtils.responseByJson(response, ResultUtils.success(adminService.getAdminList()));
    }
    private void updateAdminListById(HttpServletRequest request, HttpServletResponse response){
        
    }
}
