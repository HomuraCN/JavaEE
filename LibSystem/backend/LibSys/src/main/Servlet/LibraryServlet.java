package main.Servlet;

import main.Model.Service.LibraryService;
import main.Utils.ResponseUtils;
import main.Utils.ResultUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/library")
public class LibraryServlet extends HttpServlet {
    private LibraryService libraryService = new LibraryService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String operate = req.getParameter("operate");
        if(operate.isEmpty()){
            operate = "getLibraryInfo";
        }

        if(operate.equals("getLibraryInfo")){
            getLibraryInfo(req, resp);
        }
    }

    private void getLibraryInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResponseUtils.responseByJson(response, ResultUtils.success(libraryService.getLibraryInfo()));
    }
}
