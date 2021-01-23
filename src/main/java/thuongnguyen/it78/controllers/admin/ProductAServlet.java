package thuongnguyen.it78.controllers.admin;

import thuongnguyen.it78.models.Shoes;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig()
@WebServlet("/admin/product")
public class ProductAServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // get type to recognize add, update or delete
        String type = (String) req.getParameter("type");
        PrintWriter out = res.getWriter();

        // check condition
        if(type == null) {
            res.sendRedirect("/views/404.jsp");
            return;
        }

        if(!type.matches("add|update|delete")) {
            res.sendRedirect("/views/404.jsp");
            return;
        }

        // get value
        int id = Integer.parseInt(req.getParameter("id"));

        if(type.equals("delete")) {
            return;
        }

        String name = req.getParameter("name");
        int typeof = Integer.parseInt(req.getParameter("typeof"));
        String size = req.getParameter("size");
        String color = req.getParameter("color");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int category = Integer.parseInt(req.getParameter("category"));
        String description = req.getParameter("description");

        // upload file
        Part part1 = req.getPart("img1");
        Part part2 = req.getPart("img2");
        Part part3 = req.getPart("img3");
        Part part4 = req.getPart("img4");
        String img = "";

        if(part1 != null){
            String fileName1 = part1.getSubmittedFileName();
            img += "/img/" + fileName1;
            String path = getServletContext().getRealPath("/resources/img/avatar/");
            part1.write(path + "/" + fileName1);
        }
        if(part2 != null){
            String fileName2 = part2.getSubmittedFileName();
            img += ",/img/" + fileName2;
            String path = getServletContext().getRealPath("/resources/img/avatar/");
            part2.write(path + "/" + fileName2);
        }
        if(part3 != null){
            String fileName3 = part3.getSubmittedFileName();
            img += ",/img/" + fileName3;
            String path = getServletContext().getRealPath("/resources/img/avatar/");
            part3.write(path + "/" + fileName3);
        }
        if(part4 != null){
            String fileName4 = part4.getSubmittedFileName();
            img += ",/img/" + fileName4;
            String path = getServletContext().getRealPath("/resources/img/avatar/");
            part4.write(path + "/" + fileName4);
        }

        // control when type equal add
        if(type.equals("add")) {
            Shoes shoes = new Shoes();
            shoes.setName(name);
            shoes.setPrice(price);
            shoes.setColor(color);
            shoes.setSize(size);
            shoes.setDescription(description);
            shoes.setStock(quantity);
            shoes.setType(typeof);
            shoes.setImage(img);
        }
        // control when type equal update
        if(type.equals("update")) {
            int active = Integer.parseInt(req.getParameter("active"));
        }


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/views/admin/products.jsp").forward(req, res);

    }
}
