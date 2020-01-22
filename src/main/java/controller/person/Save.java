package controller.person;

import model.entity.Person;
import model.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save.do")
public class Save extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getParameter("username") != null
                && req.getParameter("password") != null
                && req.getParameter("firstname")!=null
                && req.getParameter("lastname")!=null) {
            Person person = new Person();
            person.setUsername(req.getParameter("username"));
            person.setPassword(req.getParameter("password"));
            person.setFirstname(req.getParameter("firstname"));
            person.setLastname(req.getParameter("lastname"));
            try {
                PersonServiceImpl.getInstance().save(person);
                res.sendRedirect("/get.do");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            res.sendRedirect("/error.jsp");
        }
    }
}
