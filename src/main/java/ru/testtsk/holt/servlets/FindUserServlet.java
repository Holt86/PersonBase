package ru.testtsk.holt.servlets;

import ru.testtsk.holt.service.BaseFactory;
import ru.testtsk.holt.base.BaseInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by user on 22.01.2017.
 */
public class FindUserServlet extends HttpServlet {
    private static final BaseInterface BASE = BaseFactory.getBase();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("name") != null){
            req.setAttribute("findUsers", BASE.findUser(req.getParameter("name")));
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/FindUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
