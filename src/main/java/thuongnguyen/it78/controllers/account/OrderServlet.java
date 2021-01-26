package thuongnguyen.it78.controllers.account;


import thuongnguyen.it78.daos.CheckOutDAO;
import thuongnguyen.it78.models.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/me/order")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // get account and set params
        Account account = (Account) req.getSession().getAttribute("account");
        req.setAttribute("order-me", CheckOutDAO.getListOrderOfAccount(account.getId()));
        req.getRequestDispatcher("/views/orders-me.jsp").forward(req, res);
    }
}
