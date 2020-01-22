package controller.person;

import model.entity.Person;
import model.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update.do")
public class Update extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Person person = new Person();
        person.setUsername(req.getParameter("username"));
        person.setPassword(req.getParameter("pasaword"));
        person.setFirstname(req.getParameter("firstname"));
        person.setLastname(req.getParameter("lastname"));
        try {
            PersonServiceImpl.getInstance().update(person);
            res.sendRedirect("/get.do");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
