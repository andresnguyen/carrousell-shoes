package thuongnguyen.it78.daos;

import thuongnguyen.it78.models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryDAO {

    public static boolean create(Category category) {
        String sql = "insert into categories(category_name, category_description, category_active) values(?, ?, ?)";

        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(sql);
            pstmt.setString(1, category.getName());
            pstmt.setString(2, category.getDesc());
            pstmt.setInt(3, category.getActive());

            pstmt.executeUpdate();

            pstmt.close();
            connect.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update(Category category) {
        String sql = "update categories set category_name = ?, category_description = ?, category_active = ? where category_id = ?";

        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(sql);
            pstmt.setString(1, category.getName());
            pstmt.setString(2, category.getDesc());
            pstmt.setInt(3, category.getActive());
            pstmt.setInt(4, category.getId());


            pstmt.executeUpdate();

            pstmt.close();
            connect.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update(int id) {
        String sql = "update categories set category_isDelete = 1 where category_id = ?";

        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(sql);

            pstmt.setInt(1, id);


            pstmt.executeUpdate();

            pstmt.close();
            connect.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Category> getCategories() {
        String sql = "select category_id, category_name, category_description, category_active from categories where category_isDelete != 1";
        ArrayList<Category> listCategories = new ArrayList<>();

        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Category category = new Category();

                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));
                category.setDesc(rs.getString(3));
                category.setActive(rs.getInt(4));

                listCategories.add(category);
            }

            pstmt.close();
            connect.close();
            return listCategories;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCategories;

    }






}
