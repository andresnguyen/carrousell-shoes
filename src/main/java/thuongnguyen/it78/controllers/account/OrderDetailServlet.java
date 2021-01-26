package thuongnguyen.it78.controllers.account;

import thuongnguyen.it78.daos.CheckOutDAO;
import thuongnguyen.it78.models.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/me/order-detail/*")
public class OrderDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // get account from session
        Account account = (Account) req.getSession().getAttribute("account");
        // get order by account id
        req.setAttribute("order-me", CheckOutDAO.getListOrderOfAccount(account.getId()));

        // get params
        int shoesDetailID = 1;

        // nếu tham số gửi lên khác null thì gán lại shoesID
        if(req.getPathInfo() != null) shoesDetailID = Integer.parseInt(req.getPathInfo().substring(1));

        req.setAttribute("order-id", shoesDetailID);

        req.getRequestDispatcher("/views/order-details.jsp").forward(req, res);
    }
}
