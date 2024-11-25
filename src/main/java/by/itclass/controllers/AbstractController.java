package by.itclass.controllers;

import by.itclass.model.sevices.CartService;
import by.itclass.model.sevices.LapTopService;
import by.itclass.model.sevices.TvService;
import by.itclass.model.sevices.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.AppConst.MESSAGE_ATTR;

public abstract class AbstractController extends HttpServlet {
    protected UserService userService;
    protected TvService tvService;
    protected LapTopService lapTopService;
    protected CartService cartService;

    @Override
    public void init() throws ServletException {
        userService = UserService.getInstance();
        tvService = TvService.getInstance();
        lapTopService = LapTopService.getInstance();
        cartService = CartService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void forward(HttpServletRequest req, HttpServletResponse resp , String url) throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req,resp);
    }

    protected void forward(HttpServletRequest req, HttpServletResponse resp , String url , String message) throws ServletException, IOException {
        req.setAttribute(MESSAGE_ATTR,message);
        req.getRequestDispatcher(url).forward(req,resp);
    }
    protected void redirect(HttpServletResponse resp , String url) throws IOException {
        resp.sendRedirect(url);
    }

}
