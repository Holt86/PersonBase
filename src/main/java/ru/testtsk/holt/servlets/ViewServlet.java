package ru.testtsk.holt.servlets;

import ru.testtsk.holt.base.Base;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by user on 21.01.2017.
 */
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", Base.getInstance().values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/UserView.jsp");
        dispatcher.forward(req, resp);
    }
}
