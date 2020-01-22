package controller.person;

import model.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete.do")
public class Delete extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            PersonServiceImpl.getInstance().delete(req.getParameter("username"));
            res.sendRedirect("/get.do");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
