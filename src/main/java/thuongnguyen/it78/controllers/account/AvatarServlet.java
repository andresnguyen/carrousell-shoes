
package thuongnguyen.it78.controllers.account;

import thuongnguyen.it78.daos.AccountDAO;
import thuongnguyen.it78.models.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig()
@WebServlet("/me/avatar")
public class AvatarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Part part = req.getPart("file");

        if(part == null) {
            res.sendRedirect("/me/info");
            return;
        }

        String path = getServletContext().getRealPath("/resources/img/img/");

        Account account = (Account) req.getSession().getAttribute("account");

        String fileName = part.getSubmittedFileName();
        part.write(path + "/" + fileName);

        AccountDAO.changeAvatar(fileName, account.getId());
        account.setAvatar(fileName);
        req.setAttribute("account", account);
        res.sendRedirect("/me/info");
        return;


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/views/shopping-cart.jsp").forward(req, res);
    }
}
