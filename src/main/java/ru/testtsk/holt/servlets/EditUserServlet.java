package ru.testtsk.holt.servlets;

import ru.testtsk.holt.service.BaseFactory;
import ru.testtsk.holt.base.BaseInterface;
import ru.testtsk.holt.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 22.01.2017.
 */
public class EditUserServlet extends HttpServlet {
    private static final BaseInterface BASE = BaseFactory.getBase();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", BASE.getUser(Integer.parseInt(req.getParameter("id"))));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/EditUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        boolean isAdmin = Boolean.parseBoolean(req.getParameter("isAdmin"));
        BASE.edit(new User(id, name, age, isAdmin));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/"));
    }
}
