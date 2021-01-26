package thuongnguyen.it78.controllers.account;

import thuongnguyen.it78.daos.CheckOutDAO;
import thuongnguyen.it78.models.Account;
import thuongnguyen.it78.models.OrderDetail;

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
        Account account = (Account) req.getSession().getAttribute("account");
        req.setAttribute("order-me", CheckOutDAO.getListOrderOfAccount(account.getId()));

        // mặc định thì shoesID = 1
        int shoesDetailID = 1;

        // nếu tham số gửi lên khác null thì gán lại shoesID
        if(req.getPathInfo() != null) shoesDetailID = Integer.parseInt(req.getPathInfo().substring(1));

        req.setAttribute("order-id", shoesDetailID);

        req.getRequestDispatcher("/views/order-details.jsp").forward(req, res);
    }
}
