package thuongnguyen.it78.controllers.admin;

import thuongnguyen.it78.daos.CategoryDAO;
import thuongnguyen.it78.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

@WebServlet("/admin/category")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // get type to recognize add, update or delete
        String type = (String) req.getParameter("type");

        // set default
        ArrayList<Category> listAccount;
        req.setAttribute("flag", "error");
        req.setAttribute("list-account", CategoryDAO.getCategories());



        if(type == null || !type.matches("add|edit|delete")) {
            // set default
            listAccount = CategoryDAO.getCategories();
            req.setAttribute("list-account", listAccount);
            req.getRequestDispatcher("/views/category-admin.jsp").forward(req, res);
            return;
        }

        // control when type equal delete
        if(type.equals("delete")) {

            int id = Integer.parseInt(req.getParameter("id"));
            if(!CategoryDAO.update(id)) {
                req.getRequestDispatcher("/views/category-admin.jsp").forward(req, res);
                return;
            }

            req.setAttribute("flag", "success");
            // set default
            listAccount = CategoryDAO.getCategories();
            req.setAttribute("list-account", listAccount);
            req.getRequestDispatcher("/views/category-admin.jsp").forward(req, res);
            return;
        }

        // common params
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");
        int active = Integer.parseInt(req.getParameter("active"));


        Category category = new Category();
        category.setActive(active);
        category.setDesc(desc);
        category.setName(name);
        System.out.println(type);
        System.out.println(name);



        // control when type equal add
        if(type.equals("add")) {

            if(!CategoryDAO.create(category)) {
                System.out.println("error");
                req.getRequestDispatcher("/views/category-admin.jsp").forward(req, res);
                return;
            }
            // set default
            System.out.println("SUCCESS");
            listAccount = CategoryDAO.getCategories();
            req.setAttribute("list-account", listAccount);
            req.setAttribute("flag", "success");
            req.getRequestDispatcher("/views/category-admin.jsp").forward(req, res);
            return;
        }


        // control when type equal update
        if(type.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            System.out.println(id);

            category.setId(id);
            if(!CategoryDAO.update(category)) {
                req.getRequestDispatcher("/views/category-admin.jsp").forward(req, res);
                return;
            }
            // set default
            listAccount = CategoryDAO.getCategories();
            req.setAttribute("list-account", listAccount);
            req.setAttribute("flag", "success");
            req.getRequestDispatcher("/views/category-admin.jsp").forward(req, res);
            return;


        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("list-account", CategoryDAO.getCategories());
        req.getRequestDispatcher("/views/category-admin.jsp").forward(req, res);

    }
}
