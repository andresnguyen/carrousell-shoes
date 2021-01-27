package thuongnguyen.it78.controllers.admin;
import thuongnguyen.it78.daos.CheckOutDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/admin/view")
public class ViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // get all user, get all product, get all order pending

        ArrayList<Integer> listView = CheckOutDAO.getView();
        req.setAttribute("view", listView);

        req.getRequestDispatcher("/views/view-admin.jsp").forward(req, res);
    }
}
