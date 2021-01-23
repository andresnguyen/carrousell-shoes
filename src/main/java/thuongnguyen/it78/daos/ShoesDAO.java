package thuongnguyen.it78.daos;

import thuongnguyen.it78.configs.LibraryMethod;
import thuongnguyen.it78.models.Shoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShoesDAO {

    public ShoesDAO() {

    }

    // lấy một shoes chi tiết
    public static Shoes getShoes(int shoesId) {

        String query = "select sd.shoes_detail_id, s.shoes_name, s.shoes_image, s.shoes_description," +
                " sd.shoes_detail_price, sd.shoes_detail_color, sd.shoes_detail_stock, ss.size_name, s.shoes_gender " +
                "from shoes as s, shoes_details as sd, sizes as ss " +
                "where s.shoes_id = sd.shoes_id and sd.shoes_id = ? and sd.size_id = ss.size_id and ss.size_id = 1 " +
                "limit 1;";

        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setInt(1, shoesId);
            ResultSet rs =  pstmt.executeQuery();
            while(rs.next()) {
                int shoesID = Integer.parseInt(rs.getString(1));
                String shoesName = rs.getString(2);
                String shoesImage = rs.getString(3);
                String shoesDescription = rs.getString(4);
                double shoesPrice = Double.parseDouble(rs.getString(5));
                String shoesColor = rs.getString(6);
                int shoesStock = Integer.parseInt(rs.getString(7));
                String shoesSize = rs.getString(8);
                int shoesGender = Integer.parseInt(rs.getString(9));



                Shoes shoes = new Shoes();

                shoes.setId(shoesID);
                shoes.setName(shoesName);
                shoes.setImage(shoesImage);
                shoes.setDescription(shoesDescription);
                shoes.setPrice(shoesPrice);
                shoes.setColor(shoesColor);
                shoes.setStock(shoesStock);
                shoes.setSize(shoesSize);
                shoes.setType(shoesGender);

                // clean up environment
                rs.close();
                pstmt.close();
                connect.close();

                return shoes;
            }
            // clean up environment
            rs.close();
            pstmt.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // kiểm tra id shoes này là thuộc category nào
    public static String getCategoryByShoesID(int id) {
        String query = "select c.category_name from categories as c, shoes as s, shoes_details as sd " +
                "where sd.shoes_detail_id = ? and sd.shoes_id = s.shoes_id and s.category_id = c.category_id " +
                "limit 1";
        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs =  pstmt.executeQuery();
            while(rs.next()) {
                String result = rs.getString(1);
                // clean up environment
                rs.close();
                pstmt.close();
                connect.close();

                return result.trim();
            }
            // clean up environment
            rs.close();
            pstmt.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Shoes";
    }

    // lấy một list shoes detail theo giới tính
    public static ArrayList<Shoes> getListShoesByGender(int gender) {
        ArrayList<Shoes> listShoes = new ArrayList<Shoes>();

        String query = "select s.shoes_id, s.shoes_name, s.shoes_image, sd.shoes_detail_price, " +
                "sd.shoes_detail_color from shoes as s, shoes_details as sd where s.shoes_id = " +
                "sd.shoes_id and s.shoes_gender = ? group by shoes_id, shoes_name, shoes_image, " +
                "shoes_detail_price, shoes_detail_color";

        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setInt(1, gender);
            ResultSet rs =  pstmt.executeQuery();
            while(rs.next()) {
                int shoesID = Integer.parseInt(rs.getString(1));
                String shoesName = rs.getString(2);
                String shoesImage = rs.getString(3);
                double shoesPrice = Double.parseDouble(rs.getString(4));
                String shoesColor = rs.getString(5);

                Shoes shoes = new Shoes();
                shoes.setId(shoesID);
                shoes.setName(shoesName);
                shoes.setImage(shoesImage);
                shoes.setPrice(shoesPrice);
                shoes.setColor(shoesColor);

                listShoes.add(shoes);
            }
            // clean up environment
            rs.close();
            pstmt.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listShoes;
    }

    // lấy ra một đôi giày bằng shoes detail id
    public static Shoes getShoesByShoesDetailId(int shoesDetailId) {

        String query = "select sd.shoes_detail_id, s.shoes_name, s.shoes_image," +
                " sd.shoes_detail_price, sd.shoes_detail_color, ss.size_name " +
                "from shoes as s, shoes_details as sd, sizes as ss " +
                "where s.shoes_id = sd.shoes_id and sd.shoes_detail_id = ? and sd.size_id = ss.size_id " +
                "limit 1;";

        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setInt(1, shoesDetailId);
            ResultSet rs =  pstmt.executeQuery();
            while(rs.next()) {
                int shoesID = Integer.parseInt(rs.getString(1));
                String shoesName = rs.getString(2);
                String shoesImage = rs.getString(3);
                double shoesPrice = Double.parseDouble(rs.getString(4));
                String shoesColor = rs.getString(5);
                String shoesSize = rs.getString(6);

                Shoes shoes = new Shoes();

                shoes.setId(shoesID);
                shoes.setName(shoesName);
                shoes.setImage(shoesImage);
                shoes.setPrice(shoesPrice);
                shoes.setColor(shoesColor);
                shoes.setSize(shoesSize);

                // clean up environment
                rs.close();
                pstmt.close();
                connect.close();

                return shoes;
            }
            // clean up environment
            rs.close();
            pstmt.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // lấy ra một đôi giày bằng shoesID và size id
    public static int getIdBySizeAndId(int shoesID, int sizeID) {
        String query = "select shoes_detail_id from shoes_details " +
                "where shoes_id = ? and size_id = ? ";

        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setInt(1, shoesID);
            pstmt.setInt(2, sizeID);
            ResultSet rs =  pstmt.executeQuery();

            while(rs.next()) {
                int shoesDetailID = Integer.parseInt(rs.getString(1));

                // clean up environment
                rs.close();
                pstmt.close();
                connect.close();

                return shoesDetailID;
            }
            // clean up environment
            rs.close();
            pstmt.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shoesID;
    }

    // get list shoes
    public static ArrayList<Shoes> getListShoes(int category, int price, int size, int gender, String sort, int start, int limit) {
        ArrayList<Shoes> listShoes = new ArrayList<>();
        String categoryFilter = " and s.category_id = " + category;
        String genderFilter = " and s.shoes_gender = " + gender;

        String template = "";
        String sortTemplate = "";

        if(category != 0) template += categoryFilter;
        if(price != 0) template += LibraryMethod.filterPrice(price);
        if(gender != 0) template += genderFilter;
        if(sort != null) sortTemplate += LibraryMethod.filterSort(sort);

        String query = "select s.shoes_id, s.shoes_name, s.shoes_image, sd.shoes_detail_price, sd.shoes_detail_color " +
                "from shoes as s, shoes_details as sd " +
                "where s.shoes_id = sd.shoes_id " + template +
                " group by shoes_id, shoes_name, shoes_image, shoes_detail_price, shoes_detail_color " +
                sortTemplate +
                " limit " + start +", " + limit;

        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            ResultSet rs =  pstmt.executeQuery();
            while(rs.next()) {
                int shoesID = Integer.parseInt(rs.getString(1));
                String shoesName = rs.getString(2);
                String shoesImage = rs.getString(3);
                double shoesPrice = Double.parseDouble(rs.getString(4));
                String shoesColor = rs.getString(5);

                Shoes shoes = new Shoes();
                shoes.setId(shoesID);
                shoes.setName(shoesName);
                shoes.setImage(shoesImage);
                shoes.setPrice(shoesPrice);
                shoes.setColor(shoesColor);

                listShoes.add(shoes);
            }
            // clean up environment
            rs.close();
            pstmt.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listShoes;
    }

    // ADMIN
    // create
    public static boolean createShoes(Shoes shoes) {

        String query = "insert into shoes(shoes_name, shoes_description, shoes_gender, shoes_image, category_id) values(?, ?, ?, ?, ?)";
        String query1 = "insert into shoes_details(shoes_details_price, shoes_details_stock, shoes_details_color, size_id, shoes_id) " +
                "values(?, ?, ?, ?, ?)";

        Connection connect = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;

        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setString(1, shoes.getName());
            pstmt.setString(2, shoes.getDescription());
            pstmt.setInt(3, shoes.getType());
            pstmt.setString(4, shoes.getImage());
            pstmt.setInt(5, shoes.getCategoryID());
            pstmt.executeUpdate();

            // clean up environment
            pstmt.close();

            pstmt1 = connect.prepareStatement(query);
            pstmt1.setDouble(1, shoes.getPrice());
            pstmt1.setInt(2, shoes.getStock());
            pstmt1.setString(3, shoes.getColor());
            // pstmt1.setInt(4, shoes.getShoesID);
            // pstmt1.setInt(5, shoes.getSize());

            pstmt1.executeUpdate();
            pstmt1.close();
            connect.close();

            return true;





        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
