package thuongnguyen.it78.controllers.admin;

import thuongnguyen.it78.configs.LibraryMethod;
import thuongnguyen.it78.daos.ShoesDAO;
import thuongnguyen.it78.models.Shoes;

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
@WebServlet("/admin/product")
public class ProductAServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // get type to recognize add, update or delete
        String type = (String) req.getParameter("type");
        // set default
        ArrayList<Shoes> listShoes;
        req.setAttribute("flag", "error");

        if(type == null || !type.matches("add|edit|delete")) {
            listShoes = ShoesDAO.getAllShoesDetail();
            req.setAttribute("listShoes", listShoes);
            req.getRequestDispatcher("/views/product-admin.jsp").forward(req, res);
            return;
        }



        if(type.equals("delete")) {
            // get id to delete
            if(req.getParameter("id") == null) {
                listShoes = ShoesDAO.getAllShoesDetail();
                req.setAttribute("listShoes", listShoes);
                req.getRequestDispatcher("/views/product-admin.jsp").forward(req, res);
                return;
            }
            int id = Integer.parseInt(req.getParameter("id"));
            if(!ShoesDAO.deleteShoes(id)) {
                listShoes = ShoesDAO.getAllShoesDetail();
                req.setAttribute("listShoes", listShoes);
                req.getRequestDispatcher("/views/product-admin.jsp").forward(req, res);
            }

            listShoes = ShoesDAO.getAllShoesDetail();
            req.setAttribute("listShoes", listShoes);
            req.setAttribute("flag", "success");
            req.getRequestDispatcher("/views/product-admin.jsp").forward(req, res);
            return;
        }




        // control when type equal add
        if(type.equals("add")) {

            // declare common for add and update
            String name = req.getParameter("name");
            int category = Integer.parseInt(req.getParameter("category"));
            String color = req.getParameter("color");
            int typeof = Integer.parseInt(req.getParameter("typeof"));
            String description = req.getParameter("description");


            // control image

                // upload file
                Part part1 = req.getPart("image1");
                Part part2 = req.getPart("image2");
                Part part3 = req.getPart("image3");
                Part part4 = req.getPart("image4");

                if(part1 == null || part2 == null || part3 == null || part4 == null) {
                    listShoes = ShoesDAO.getAllShoesDetail();
                    req.setAttribute("listShoes", listShoes);
                    req.getRequestDispatcher("/views/product-admin.jsp").forward(req, res);
                    return;
                }
                String img = "";

                String path = getServletContext().getRealPath("/resources/img/img/");

                String fileName1 = part1.getSubmittedFileName();
                img += "/img/" + fileName1;
                part1.write(path + "/" + fileName1);

                String fileName2 = part2.getSubmittedFileName();
                img += ",/img/" + fileName2;
                part2.write(path + "/" + fileName2);

                String fileName3 = part3.getSubmittedFileName();
                img += ",/img/" + fileName3;
                part3.write(path + "/" + fileName3);

                String fileName4 = part4.getSubmittedFileName();
                img += ",/img/" + fileName4;
                part4.write(path + "/" + fileName4);

                // control size
                int size1 = LibraryMethod.getSizeInt(req.getParameter("size1"));
                Double price1 = Double.parseDouble(req.getParameter("price1"));
                int stock1 = Integer.parseInt(req.getParameter("quantity1"));

                int size2 = LibraryMethod.getSizeInt(req.getParameter("size2"));
                Double price2 = Double.parseDouble(req.getParameter("price2"));
                int stock2 = Integer.parseInt(req.getParameter("quantity2"));

                int size3 = LibraryMethod.getSizeInt(req.getParameter("size3"));
                Double price3 = Double.parseDouble(req.getParameter("price3"));
                int stock3 = Integer.parseInt(req.getParameter("quantity3"));

                int size4 = LibraryMethod.getSizeInt(req.getParameter("size4"));
                Double price4 = Double.parseDouble(req.getParameter("price4"));
                int stock4 = Integer.parseInt(req.getParameter("quantity4"));


            Shoes shoes = new Shoes();
            shoes.setName(name);
            shoes.setColor(color);
            shoes.setDescription(description);
            shoes.setType(typeof);
            shoes.setImage(img);
            shoes.setCategoryID(category);


            if(!ShoesDAO.createShoes(shoes, size1, size2, size3, size4,
                    price1, price2, price3, price4, stock1, size2, stock3, stock4)) {

                listShoes = ShoesDAO.getAllShoesDetail();
                req.setAttribute("listShoes", listShoes);
                req.getRequestDispatcher("/views/product-admin.jsp").forward(req, res);
            }


            listShoes = ShoesDAO.getAllShoesDetail();
            req.setAttribute("listShoes", listShoes);
            req.setAttribute("flag", "success");
            req.getRequestDispatcher("/views/product-admin.jsp").forward(req, res);
            return;

        }
        // control when type equal update

        if(type.equals("edit")) {
            // declare common for add and update
            String name = req.getParameter("name");
            int category = Integer.parseInt(req.getParameter("category"));
            String color = req.getParameter("color");
            String description = req.getParameter("description");
            int id = Integer.parseInt(req.getParameter("id"));

            int active = Integer.parseInt(req.getParameter("active"));
            double price = Double.parseDouble(req.getParameter("price"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            Shoes shoes = new Shoes();

            shoes.setId(id);
            shoes.setName(name);
            shoes.setColor(color);
            shoes.setDescription(description);
            shoes.setPrice(price);
            shoes.setStock(quantity);
            shoes.setActive(active);
            shoes.setCategoryID(category);

            if(!ShoesDAO.updateShoes(shoes)) {
                listShoes = ShoesDAO.getAllShoesDetail();
                req.setAttribute("listShoes", listShoes);
                req.getRequestDispatcher("/views/product-admin.jsp").forward(req, res);
                return;
            }

            listShoes = ShoesDAO.getAllShoesDetail();
            req.setAttribute("listShoes", listShoes);
            req.setAttribute("flag", "success");
            req.getRequestDispatcher("/views/product-admin.jsp").forward(req, res);
            return;
        }


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<Shoes> listShoes = ShoesDAO.getAllShoesDetail();
        req.setAttribute("listShoes", listShoes);
        req.getRequestDispatcher("/views/product-admin.jsp").forward(req, res);

    }
}
