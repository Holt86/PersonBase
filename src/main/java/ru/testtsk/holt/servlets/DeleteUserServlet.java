package ru.testtsk.holt.servlets;

import ru.testtsk.holt.base.Base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 22.01.2017.
 */
public class DeleteUserServlet extends HttpServlet {
    private static final Base BASE = Base.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BASE.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/"));
    }
}
