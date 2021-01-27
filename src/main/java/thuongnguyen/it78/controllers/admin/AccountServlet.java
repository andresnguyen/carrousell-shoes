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

        // set default
        ArrayList<Account> listAccount;
        req.setAttribute("flag", "error");

        // set default
        listAccount = AccountDAO.getAccounts();
        req.setAttribute("list-account", listAccount);


        if(type == null || !type.matches("add|update|delete")) {
            // set default
            listAccount = AccountDAO.getAccounts();
            req.setAttribute("list-account", listAccount);
            req.getRequestDispatcher("/views/account-admin.jsp").forward(req, res);
            return;
        }

        // control when type equal delete
        if(type.equals("delete")) {

            if(req.getParameter("id") == null) {
                req.getRequestDispatcher("/views/account-admin.jsp").forward(req, res);
                return;
            }

            int id = Integer.parseInt(req.getParameter("id"));

            if(!AccountDAO.deleteSort(id)) {
                req.getRequestDispatcher("/views/account-admin.jsp").forward(req, res);
                return;
            }

            req.setAttribute("flag", "success");
            // set default
            listAccount = AccountDAO.getAccounts();
            req.setAttribute("list-account", listAccount);
            req.getRequestDispatcher("/views/account-admin.jsp").forward(req, res);
            return;
        }

        // common params
        String fullname = req.getParameter("fullname");
        String number = req.getParameter("phone");
        String email = req.getParameter("email");
        String genderString = req.getParameter("gender");
        String address = req.getParameter("address");



        // check if error
        if(fullname == null || number == null || email == null || genderString == null || address == null) {
            // set default
            listAccount = AccountDAO.getAccounts();
            req.setAttribute("list-account", listAccount);
            req.getRequestDispatcher("/views/account-admin.jsp").forward(req, res);
            return;
        }

        int gender = Integer.parseInt(genderString);

        // control when type equal add
        if(type.equals("add")) {

            if(AccountDAO.checkEmail(email)) {
                listAccount = AccountDAO.getAccounts();
                req.setAttribute("list-account", listAccount);
                req.getRequestDispatcher("/views/account-admin.jsp").forward(req, res);
                return;
            }

            String password = req.getParameter("password");

            Account account = new Account();
            account.setEmail(email);
            account.setPassword(password);
            account.setFullName(fullname);
            account.setNumber(number);
            account.setGender(gender);
            account.setAddress(address);

            if(!AccountDAO.create(account)) {
                req.getRequestDispatcher("/views/account-admin.jsp").forward(req, res);
                return;
            }
            // set default
            listAccount = AccountDAO.getAccounts();
            req.setAttribute("list-account", listAccount);
            req.setAttribute("flag", "success");
            req.getRequestDispatcher("/views/account-admin.jsp").forward(req, res);
            return;
        }
        // control when type equal update
        if(type.equals("update")) {
            try {
                // get value
                if(req.getParameter("id") == null ||
                   req.getParameter("role") == null ||
                   req.getPart("avatar") == null) {

                    listAccount = AccountDAO.getAccounts();
                    req.setAttribute("list-account", listAccount);
                    req.getRequestDispatcher("/views/account-admin.jsp").forward(req, res);
                    return;
                }
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

                if(part == null || !AccountDAO.updateForAdmin(account)) {
                    // set default
                    listAccount = AccountDAO.getAccounts();
                    req.setAttribute("list-account", listAccount);
                    req.getRequestDispatcher("/views/account-admin.jsp").forward(req, res);
                    return;
                }
                // set default
                listAccount = AccountDAO.getAccounts();
                req.setAttribute("list-account", listAccount);
                req.setAttribute("flag", "success");
                req.getRequestDispatcher("/views/account-admin.jsp").forward(req, res);
                return;

            } catch (Exception e) {
                e.printStackTrace();
                listAccount = AccountDAO.getAccounts();
                req.setAttribute("list-account", listAccount);
                req.getRequestDispatcher("/views/account-admin.jsp").forward(req, res);
                return;
            }

        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<Account> listAccount = AccountDAO.getAccounts();
        req.setAttribute("list-account", listAccount);
        req.getRequestDispatcher("/views/account-admin.jsp").forward(req, res);

    }
}
