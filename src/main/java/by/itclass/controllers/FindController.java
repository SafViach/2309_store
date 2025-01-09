package by.itclass.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.AppConst.*;

@WebServlet(FIND_CONTROLLER)
public class FindController extends AbstractController{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var str = req.getParameter(FIND_PARAM);
        var result = findService.getFind(str);
        if (result.size() >= 1){
            req.getSession().setAttribute(FIND_ATTR , result);
            req.getRequestDispatcher(HOME_JSP).forward(req,resp);
        }else {
            req.getSession().setAttribute(MESSAGE_ATTR , "no Find");
            req.getRequestDispatcher(HOME_JSP).forward(req,resp);
        }
    }
}
