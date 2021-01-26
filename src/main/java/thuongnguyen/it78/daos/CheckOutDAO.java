package thuongnguyen.it78.daos;

import thuongnguyen.it78.configs.LibraryMethod;
import thuongnguyen.it78.models.Order;
import thuongnguyen.it78.models.OrderDetail;
import thuongnguyen.it78.models.Shoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CheckOutDAO {

    public static boolean checkOut(String note, int id, HashMap<Integer, OrderDetail> mapShoes) {
        int orderID = getIDOrder() + 1;
        String valuesQuery = LibraryMethod.getQueryOrder(mapShoes, orderID);
        String query = "insert into orders(order_id, order_date, order_note, account_id) values(?, ?, ?, ?)";
        String query1 = "insert into order_details(order_id, shoes_detail_id, quantity) values" + valuesQuery;

        System.out.println(query1);

        Connection connect = null;
        PreparedStatement pstmt = null;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dataInsert = dateFormat.format(date);



        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);

            pstmt.setInt(1, orderID);
            pstmt.setString(2, dataInsert);
            pstmt.setString(3, note);
            pstmt.setInt(4, id);

            int row = pstmt.executeUpdate();

            pstmt.close();
            connect.close();

            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query1);
            int row1 = pstmt.executeUpdate();

            return true;


        } catch (Exception e) {
            e.printStackTrace();
        }



        return false;
    }

    public static int getIDOrder() {
        String query = "select order_id from orders order by order_id desc";

        Connection connect = null;
        PreparedStatement pstmt = null;

        int result;

        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            result = rs.getInt(1);


            rs.close();
            pstmt.close();
            connect.close();

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;

    }


    public static HashMap<Integer, Order> getListOrder() {
        HashMap<Integer, Order> listShoes = new HashMap<>();

        String query = "select * from orders as o, order_details as od where o.order_id = od.order_id";

        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            ResultSet rs =  pstmt.executeQuery();
            while(rs.next()) {

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


    public static void main(String[] args) {

    }
}
