package thuongnguyen.it78.controllers.admin;

import thuongnguyen.it78.daos.AccountDAO;
import thuongnguyen.it78.models.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;

@MultipartConfig()
@WebServlet("/admin/account")
public class AccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // get type to recognize add, update or delete
        String type = (String) req.getParameter("type");
        PrintWriter out = res.getWriter();
        System.out.println(type);

        // check condition
        if(type == null) {
            res.sendRedirect("/views/404.jsp");
            return;
        }

        if(!type.matches("add|update|delete")) {
            res.sendRedirect("/views/404.jsp");
            return;
        }



        // control when type equal delete
        if(type.equals("delete")) {
            // get value
            int id = Integer.parseInt(req.getParameter("id"));

            if(AccountDAO.deleteSort(id)) {
                out.println("OK");
                out.flush();
                return;
            }
            out.println("NOT OK");
            out.flush();
            return;
        }

        String fullname = req.getParameter("fullname");
        String number = req.getParameter("phone");
        String email = req.getParameter("email");
        int gender = Integer.parseInt(req.getParameter("gender"));
        String address = req.getParameter("address");

        // control when type equal add
        if(type.equals("add")) {
            String password = req.getParameter("password");

            Account account = new Account();
            account.setEmail(email);
            account.setPassword(password);
            account.setFullName(fullname);
            account.setNumber(number);
            account.setGender(gender);
            account.setAddress(address);

            if(!AccountDAO.create(account)) {
                // fail
                out.println("FALSE");
                out.flush();
                return;
            }
            // success
            out.println("OK");
            out.flush();
            return;
        }
        // control when type equal update
        if(type.equals("update")) {
            try {
                // get value
                int id = Integer.parseInt(req.getParameter("id"));
                int role = Integer.parseInt(req.getParameter("role"));

                // upload file
                Part part = req.getPart("avatar");
                // get name
                String fileName = part.getSubmittedFileName();
                // create path
                String path = getServletContext().getRealPath("/resources/img/avatar/");
                // save file to the path
                part.write(path + "/" + fileName);

                Account account = new Account();
                account.setId(id);
                account.setEmail(email);
                account.setFullName(fullname);
                account.setNumber(number);
                account.setGender(gender);
                account.setAddress(address);
                account.setAvatar(fileName);
                account.setRole(role);

                if(!AccountDAO.updateForAdmin(account)) {
                    // update fail
                    out.println("FALSE");
                    out.flush();
                    return;
                }

                out.println("OK");
                out.flush();
                // update success



                return;

            } catch (Exception e) {
                e.printStackTrace();
                res.sendRedirect("/view/404.jsp");
                return;
            }

        }



       res.sendRedirect("/view/404.jsp");


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<Account> listAccount = AccountDAO.getAccounts();
        req.setAttribute("list-account", listAccount);
        req.getRequestDispatcher("/views/account-admin.jsp").forward(req, res);

    }
}
