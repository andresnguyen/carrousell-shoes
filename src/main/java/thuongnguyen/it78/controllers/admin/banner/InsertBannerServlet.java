package thuongnguyen.it78.controllers.admin.banner;

import thuongnguyen.it78.daos.ConnectDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@MultipartConfig()

@WebServlet("/admin/insertbanner")
public class InsertBannerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name").trim();
        Part part = request.getPart("image");

        // get name
        String fileName = part.getSubmittedFileName();

        // create path
        String path = getServletContext().getRealPath("/resources/img/banner/");

        // save file to the path
        part.write(path + "/" + fileName);

        int status = 1;
        try {
            String sql = "insert into banner (name,image,status) value (?,?,?)";
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,fileName);
            ps.setInt(3,status);
            ps.executeUpdate();
            ps.close();
            con.close();
            response.sendRedirect("/admin/banner");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}