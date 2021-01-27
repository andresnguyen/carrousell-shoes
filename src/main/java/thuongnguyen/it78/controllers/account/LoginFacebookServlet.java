package thuongnguyen.it78.controllers.account;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thuongnguyen.it78.daos.AccountDAO;
import thuongnguyen.it78.models.Account;

@WebServlet("/login-facebook")
public class LoginFacebookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        if (email == null || email.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher("/views/login.jsp");
            dis.forward(request, response);
        } else {

            Account account = new Account();
            account.setFullName(name);
            account.setEmail(id);
            account.setAvatar("default.jpg");
            account.setGender(1);
            account.setAddress("Unknown");
            account.setPassword("Secret");
            account.setNumber("123456789");

            if(!AccountDAO.checkEmail(id)) {

                AccountDAO.create(account);

            }

            account = AccountDAO.getAccount(account.getEmail(), account.getPassword());

           // account.setId(id);
            request.getSession().setAttribute("account", account);
            RequestDispatcher dis = request.getRequestDispatcher("/views/index.jsp");
            dis.forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
