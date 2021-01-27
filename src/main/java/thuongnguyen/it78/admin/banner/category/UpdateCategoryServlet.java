package thuongnguyen.it78.admin.banner.category;

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

@WebServlet("/updatecategory")
public class UpdateCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        try {
            String name = request.getParameter("name").trim();
            String description = request.getParameter("description").trim();
            boolean category_active = Boolean.parseBoolean(request.getParameter("category_active")==null?"true":request.getParameter("category_active").trim());
            String id = request.getParameter("id").trim();
            int category_active1=0;
            if (category_active==false){
                category_active1=2;
            }else {
                category_active1=1;
            }
            String sql = "update categories set category_name=?,category_description=?,category_active=? where category_id=?";
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,description);
            ps.setInt(3,category_active1);
            ps.setString(4,id);
            ps.executeUpdate();
            response.sendRedirect("/category");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
