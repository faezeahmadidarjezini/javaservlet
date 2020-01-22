package controller.person;

import model.service.PersonService;
import model.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/get.do")
public class Get extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {

            req.setAttribute("list", PersonServiceImpl.getInstance().get());
            req.getRequestDispatcher("/ index.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
