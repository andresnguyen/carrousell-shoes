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
        Order order;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            ResultSet rs =  pstmt.executeQuery();
            while(rs.next()) {
                int orderId = rs.getInt(1);
                String orderDate = rs.getString(2);
                int orderStatus = rs.getInt(3);
                String orderNote = rs.getString(4);
                int accountID = rs.getInt(5);
                int shoesDetailID = rs.getInt(7);
                int quantity = rs.getInt(8);



                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setShoes(ShoesDAO.getShoesByShoesDetailId(shoesDetailID));
                orderDetail.setQuantity(quantity);

                order = new Order();
                order.setId(orderId);
                order.setAccount(AccountDAO.getAccount(accountID));
                order.setOrderDate(orderDate);
                order.setStatus(orderStatus);
                order.setOrderNote(orderNote);
                order.addDetail(orderDetail);

                if(listShoes.containsKey(orderId)) {
                    listShoes.get(orderId).getListOrderDetail().add(orderDetail);
                    listShoes.put(orderId, listShoes.get(orderId));
                    continue;
                }

                listShoes.put(orderId, order);



            }
            // clean up environment
            rs.close();
            pstmt.close();
            connect.close();

            return listShoes;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listShoes;
    }

    public static HashMap<Integer, Order> getListOrderOfAccount(int accountId) {
        HashMap<Integer, Order> listShoes = new HashMap<>();

        String query = "select * from orders as o, order_details as od where o.order_id = od.order_id and o.account_id = ?";

        Connection connect = null;
        PreparedStatement pstmt = null;
        Order order;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setInt(1, accountId);
            ResultSet rs =  pstmt.executeQuery();
            while(rs.next()) {
                int orderId = rs.getInt(1);
                String orderDate = rs.getString(2);
                int orderStatus = rs.getInt(3);
                String orderNote = rs.getString(4);
                int accountID = rs.getInt(5);
                int shoesDetailID = rs.getInt(7);
                int quantity = rs.getInt(8);



                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setShoes(ShoesDAO.getShoesByShoesDetailId(shoesDetailID));
                orderDetail.setQuantity(quantity);

                order = new Order();
                order.setId(orderId);
                order.setAccount(AccountDAO.getAccount(accountID));
                order.setOrderDate(orderDate);
                order.setStatus(orderStatus);
                order.setOrderNote(orderNote);
                order.addDetail(orderDetail);

                if(listShoes.containsKey(orderId)) {
                    listShoes.get(orderId).getListOrderDetail().add(orderDetail);
                    listShoes.put(orderId, listShoes.get(orderId));
                    continue;
                }

                listShoes.put(orderId, order);


            }
            // clean up environment
            rs.close();
            pstmt.close();
            connect.close();

            return listShoes;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listShoes;
    }



    public static void main(String[] args) {
        // System.out.println(getListOrder().toString());
        // System.out.println(getListOrderOfAccount(1).toString());
        System.out.println(getView());
    }

    public static boolean setStatus(int orderID, int status) {
        String sql = "update orders set order_status = ? where order_id = ?";

        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(sql);
            pstmt.setInt(1, status);
            pstmt.setInt(2, orderID);

            pstmt.executeUpdate();

            pstmt.close();
            connect.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Integer> getView() {
        String sql1 = "select count(*) from accounts where account_isDelete != 1";
        String sql2 = "select count(*) from shoes_details where shoes_detail_isDelete != 1";
        String sql3 = "select count(*) from orders where order_status = 0";
        ArrayList<Integer> result = new ArrayList<>();

        Connection connect = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(sql1);

            rs = pstmt.executeQuery();
            rs.next();
            result.add(rs.getInt(1));

            rs.close();
            pstmt.close();

            pstmt = connect.prepareStatement(sql2);

            rs = pstmt.executeQuery();
            rs.next();

            result.add(rs.getInt(1));

            rs.close();
            pstmt.close();

            pstmt = connect.prepareStatement(sql3);

            rs = pstmt.executeQuery();
            rs.next();

            result.add(rs.getInt(1));

            rs.close();
            pstmt.close();

            connect.close();

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
