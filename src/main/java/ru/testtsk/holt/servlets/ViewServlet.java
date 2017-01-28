package ru.testtsk.holt.servlets;

import ru.testtsk.holt.base.BaseCache;
import ru.testtsk.holt.base.BaseInterface;
import ru.testtsk.holt.model.User;
import ru.testtsk.holt.service.BaseFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


/**
 * Created by user on 21.01.2017.
 */
public class ViewServlet extends HttpServlet {
    private static final BaseInterface BASE = BaseFactory.getBase();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Collection<User> users = BASE.values();
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/UserView.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        BASE.close();
    }
}
