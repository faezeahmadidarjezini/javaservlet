package controller.person;


import com.google.gson.Gson;
import model.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/getCurrentUser.do")
public class GetCurrentUser extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Person currentUser = (Person) req.getSession().getAttribute("currentUser");

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        String userJson = new Gson().toJson(currentUser);
        res.getWriter().write(userJson);
    }
}
