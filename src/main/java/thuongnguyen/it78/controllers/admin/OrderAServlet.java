package thuongnguyen.it78.controllers.admin;


import thuongnguyen.it78.daos.CheckOutDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/admin/order")
public class OrderAServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int orderID = Integer.parseInt(req.getParameter("orderID"));
        int status = Integer.parseInt(req.getParameter("status"));
        CheckOutDAO.setStatus(orderID, status);

        res.sendRedirect("/admin/order");

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setAttribute("order-me", CheckOutDAO.getListOrder());
        req.getRequestDispatcher("/views/order-admin.jsp").forward(req, res);
    }
}
