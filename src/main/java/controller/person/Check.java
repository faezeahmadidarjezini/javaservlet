package controller.person;

import model.entity.Person;
import model.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/check.do")
public class Check extends HttpServlet {
    Person person = new Person();

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getParameter("username") != null
                && req.getParameter("password") != null) {
            Person person = new Person();
            person.setUsername(req.getParameter("username"));
            person.setPassword(req.getParameter("password"));
            try {
                Person check = PersonServiceImpl.getInstance().check(person);
                res.setContentType("application/json");
                res.setCharacterEncoding("UTF-8");
                PrintWriter out = res.getWriter();
                if (check !=null) {
                    req.getSession().setAttribute("currentUser",check);
                    out.write("{\"res\":\"1\"}");
                } else {
                    out.write("{res:0}");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            res.sendRedirect("static/errorpage.html");
        }
    }
}
