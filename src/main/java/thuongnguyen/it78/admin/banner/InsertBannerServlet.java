package thuongnguyen.it78.admin.banner;

import thuongnguyen.it78.daos.ConnectDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/insertbanner")
public class InsertBannerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        String name = request.getParameter("name").trim();
        String img = request.getParameter("image").trim();
        int status = 1;
        try {
            String sql = "insert into banner (name,image,status) value (?,?,?)";
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,img);
            ps.setInt(3,status);
            ps.executeUpdate();
            response.sendRedirect("/banner");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}