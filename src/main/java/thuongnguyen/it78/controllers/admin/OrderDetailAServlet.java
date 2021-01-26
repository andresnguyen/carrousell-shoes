package thuongnguyen.it78.controllers.admin;
import thuongnguyen.it78.daos.CheckOutDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/admin/order-detail/*")
public class OrderDetailAServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // get order by account id
        req.setAttribute("order-me", CheckOutDAO.getListOrder());

        // get params
        int shoesDetailID = 1;

        // nếu tham số gửi lên khác null thì gán lại shoesID
        if(req.getPathInfo() != null) shoesDetailID = Integer.parseInt(req.getPathInfo().substring(1));

        req.setAttribute("order-id", shoesDetailID);

        req.getRequestDispatcher("/views/order-details-admin.jsp").forward(req, res);
    }
}
