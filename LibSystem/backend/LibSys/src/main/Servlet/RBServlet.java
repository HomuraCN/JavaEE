package main.Servlet;

import main.Model.Service.RBService;
import main.Utils.ResponseUtils;
import main.Utils.ResultUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rb")
public class RBServlet extends HttpServlet {
    private RBService rbService = new RBService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String operate = req.getParameter("operate");
        if(operate.isEmpty()){
            operate = "getRBList";
        }

        if(operate.equals("getRBList")) {
            getRBList(req, resp);
        }
    }

    private void getRBList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResponseUtils.responseByJson(response, ResultUtils.success(rbService.getRBList()));
    }
}
