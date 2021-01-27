package thuongnguyen.it78.loginfb;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thuongnguyen.it78.models.Account;

@WebServlet("/login-facebook")
public class LoginFacebookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
//        int id = Integer.parseInt(request.getParameter("id"));
        if (email == null || email.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher("/views/login.jsp");
            dis.forward(request, response);
        } else {
            Account account = new Account();
            account.setFullName(name);
            account.setEmail(email);
//            account.setId(id);
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
