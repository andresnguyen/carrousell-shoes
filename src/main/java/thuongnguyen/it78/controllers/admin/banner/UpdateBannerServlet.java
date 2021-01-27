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

@WebServlet("/admin/updatebanner")
public class UpdateBannerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        try {
            String name = request.getParameter("name").trim();
            Part part = request.getPart("image");

            // get name
            String fileName = part.getSubmittedFileName();

            // create path
            String path = getServletContext().getRealPath("/resources/img/banner/");

            // save file to the path
            part.write(path + "/" + fileName);
            boolean status = Boolean.parseBoolean(request.getParameter("status")==null?"true":request.getParameter("status").trim());
            int id = Integer.parseInt(request.getParameter("id").trim());
            int status1=0;
            System.out.println(id);
            if (status==false){
                status1=2;
            }else {
                status1=1;
            }

            System.out.println(status1);
            String sql = "update banner set name=?,image=?,status=? where id=?";
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,fileName);
            ps.setInt(3,status1);
            ps.setInt(4,id);
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
