package ru.testtsk.holt.servlets;

import ru.testtsk.holt.service.BaseFactory;
import ru.testtsk.holt.base.BaseInterface;
import ru.testtsk.holt.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 22.01.2017.
 */
public class AddUserServlet extends HttpServlet {
    private static final BaseInterface BASE = BaseFactory.getBase();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BASE.add(new User(req.getParameter("name"), Integer.parseInt(req.getParameter("age")), Boolean.parseBoolean(req.getParameter("isAdmin"))));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/"));
//        resp.setContentType("text/html");
//        resp.setStatus(HttpServletResponse.SC_OK);
//        PrintWriter out = resp.getWriter();
//        out.write("<h1>Hello</h1>");
//        out.flush();
//        out.close();

    }
}
