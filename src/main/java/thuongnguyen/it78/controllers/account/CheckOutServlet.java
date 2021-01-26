package thuongnguyen.it78.controllers.account;

import thuongnguyen.it78.daos.AccountDAO;
import thuongnguyen.it78.daos.CheckOutDAO;
import thuongnguyen.it78.daos.ShoesDAO;
import thuongnguyen.it78.models.Account;
import thuongnguyen.it78.models.OrderDetail;
import thuongnguyen.it78.models.Shoes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


@WebServlet("/me/checkout")
public class CheckOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String note = req.getParameter("note");

        if(note == null) {
            note = "";
        }
        // get account from session
        Account accountLegal = (Account) req.getSession().getAttribute("account");

        // get cart from session
        HashMap<Integer, OrderDetail> mapShoes = (HashMap) req.getSession().getAttribute("cart");

        // checkout
        if(CheckOutDAO.checkOut(note, accountLegal.getId(), mapShoes)) {
            // clear cart and asign to session cart
            mapShoes.clear();
            req.getSession().setAttribute("cart", mapShoes);
            res.sendRedirect("/me/order");
            return;
        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.getRequestDispatcher("/views/checkout.jsp").forward(req, res);
    }
}
