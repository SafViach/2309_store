package by.itclass.controllers.order;

import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.AppConst.*;

@WebServlet(ORDER_HISTORY_CONTROLLER)
public class OrdersHistoryController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        var userId =((User) session.getAttribute(USER_ATTR)).getId();
        var orders = orderService.getOrders(userId);
        session.setAttribute(ORDERS_ATTR , orders);
        forward(req,resp,ORDERS_JSP);

    }
}
