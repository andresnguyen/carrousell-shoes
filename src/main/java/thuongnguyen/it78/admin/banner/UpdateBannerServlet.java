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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/updatebanner")
public class UpdateBannerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        try {
            String name = request.getParameter("name").trim();
            String img = request.getParameter("image").trim();
            boolean status = Boolean.parseBoolean(request.getParameter("status")==null?"true":request.getParameter("status").trim());
            String id = request.getParameter("id").trim();
            int status1=0;
            if (status==false){
                status1=2;
            }else {
                status1=1;
            }
            String sql = "update banner set name=?,image=?,status=? where id=?";
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,img);
            ps.setInt(3,status1);
            ps.setString(4,id);
            ps.executeUpdate();
            response.sendRedirect("/banner");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
