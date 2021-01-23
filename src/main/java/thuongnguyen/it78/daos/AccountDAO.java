package thuongnguyen.it78.daos;

import thuongnguyen.it78.models.Account;

import java.sql.*;
import java.util.ArrayList;

public class AccountDAO {

    public AccountDAO() {

    }

    // get all account
    public ArrayList<Account> getAccounts() {
        ArrayList<Account> listAccount = new ArrayList<Account>();

        String query = "select * from accounts";
        Connection connect = null;
        Statement stmt = null;
        try {
            connect = ConnectDB.getConnection();
            stmt = connect.createStatement();
            ResultSet rs =  stmt.executeQuery(query);
            while(rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                String email = rs.getString(2);
                String password = rs.getString(3);
                String fullname = rs.getString(4);
                String number = rs.getString(5);
                int gender = Integer.parseInt(rs.getString(6));
                String address = rs.getString(7);
                String avatar = rs.getString(8);
                int role = Integer.parseInt(rs.getString(9));

                Account account = new Account();
                account.setId(id);
                account.setEmail(email);
                account.setPassword(password);
                account.setFullName(fullname);
                account.setNumber(number);
                account.setGender(gender);
                account.setAddress(address);
                account.setAvatar(avatar);
                account.setRole(role);

                listAccount.add(account);
            }
            // clean up environment
            rs.close();
            stmt.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listAccount;
    }

    // get account by id
    public static Account getAccount(int accountID) {
        Account account;
        String query = "select * from accounts where account_id = ?";
        Connection connect = null;
        PreparedStatement pstmt = null;

        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setInt(1, accountID);
            ResultSet rs =  pstmt.executeQuery();
            while(rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                String email = rs.getString(2);
                String password = rs.getString(3);
                String fullname = rs.getString(4);
                String number = rs.getString(5);
                int gender = Integer.parseInt(rs.getString(6));
                String address = rs.getString(7);
                String avatar = rs.getString(8);
                int role = Integer.parseInt(rs.getString(9));

                account = new Account();
                account.setId(id);
                account.setEmail(email);
                account.setPassword(password);
                account.setFullName(fullname);
                account.setNumber(number);
                account.setGender(gender);
                account.setAddress(address);
                account.setAvatar(avatar);
                account.setRole(role);

                // clean up environment
                rs.close();
                pstmt.close();
                connect.close();

                return account;
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

    // get one account through email, password
    public static Account getAccount(String emailLogin, String passwordLogin) {
        String query = "select * from accounts where account_email = ? and account_password = ?";
        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setString(1, emailLogin);
            pstmt.setString(2, passwordLogin);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                String email = rs.getString(2);
                String password = rs.getString(3);
                String fullName = rs.getString(4);
                String number = rs.getString(5);
                int gender = Integer.parseInt(rs.getString(6));
                String address = rs.getString(7);
                String avatar = rs.getString(8);
                int role = Integer.parseInt(rs.getString(9));

                Account account = new Account();
                account.setId(id);
                account.setEmail(email);
                account.setPassword(password);
                account.setFullName(fullName);
                account.setNumber(number);
                account.setGender(gender);
                account.setAddress(address);
                account.setAvatar(avatar);
                account.setRole(role);

                // clean up environment
                rs.close();
                pstmt.close();
                connect.close();

                return account;
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

    // change password by id
    public static boolean changePassword(int id, String newPassword) {
        String query = "update accounts set account_password = ? where account_id = ?";
        Connection connect = null;
        PreparedStatement pstmt = null;

        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setString(1, newPassword);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();

            // clean up environment
            pstmt.close();
            connect.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // check password by id
    public static boolean checkPassword(int id, String password) {
        String query = "select * from accounts where account_id = ? and account_password = ?";
        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                // clean up environment
                rs.close();
                pstmt.close();
                connect.close();
                return true;
            }
            rs.close();
            pstmt.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // check email exist system
    public static boolean checkEmail(String email) {
        String query = "select * from accounts where account_email = ?";
        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                // clean up environment
                rs.close();
                pstmt.close();
                connect.close();
                return true;
            }
            rs.close();
            pstmt.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // get password of account by id
    public static String getPassword(int accountID) {

        String query = "select account_password from accounts where account_id = ?";
        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setInt(1, accountID);
            ResultSet rs =  pstmt.executeQuery();
            while(rs.next()) {
                String password = rs.getString(1);

                return password;
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

    
    public static boolean create(Object obj) {
        Account account = (Account) obj;
        String query ="insert accounts (account_email, account_password," +
                " account_fullname, account_number, account_gender, " +
                "account_address) values(?, ?, ?, ?, ?, ?)";
        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setString(1, account.getEmail());
            pstmt.setString(2, account.getPassword());
            pstmt.setString(3, account.getFullName());
            pstmt.setString(4, account.getNumber());
            pstmt.setInt(5, account.getGender());
            pstmt.setString(6, account.getAddress());
            pstmt.executeUpdate();

            // clean up environment
            pstmt.close();
            connect.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String query = "delete from accounts where account_id = ?";
        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            // clean up environment
            pstmt.close();
            connect.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Object obj) {
        Account account = (Account) obj;

        String query = "update accounts set account_fullname = ?, " +
                "account_password = ?, account_address = ?, account_gender = ?," +
                "account_avatar = ?, account_number = ? where account_id = ?";
        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setString(1, account.getFullName());
            pstmt.setString(2, account.getPassword());
            pstmt.setString(3, account.getAddress());
            pstmt.setInt(4, account.getGender());
            pstmt.setString(5, account.getAvatar());
            pstmt.setString(6, account.getNumber());
            pstmt.setInt(7, account.getId());

            pstmt.executeUpdate();

            // clean up environment
            pstmt.close();
            connect.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateInfo(Object obj) {
        Account account = (Account) obj;

        String query = "update accounts set account_fullname = ?, " +
                "account_address = ?, account_gender = ?," +
                "account_number = ? where account_id = ?";
        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setString(1, account.getFullName());
            pstmt.setString(2, account.getAddress());
            pstmt.setInt(3, account.getGender());
            pstmt.setString(4, account.getNumber());
            pstmt.setInt(5, account.getId());


            pstmt.executeUpdate();

            pstmt.close();
            connect.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    public boolean updatePassword(String email, String newPassword) {

        String query = "update accounts set account_password = ? " +
                "where account_email = ?";
        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setString(1, newPassword);
            pstmt.setString(2, email);

            pstmt.executeUpdate();

            pstmt.close();
            connect.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    // ADMIN

    public static boolean updateForAdmin(Object obj) {
        Account account = (Account) obj;

        String query = "update accounts set account_fullname = ?, " +
                "account_password = ?, account_address = ?, account_gender = ?," +
                "account_avatar = ?, account_number = ?, account_role = ? where account_id = ?";
        Connection connect = null;
        PreparedStatement pstmt = null;
        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setString(1, account.getFullName());
            pstmt.setString(2, account.getPassword());
            pstmt.setString(3, account.getAddress());
            pstmt.setInt(4, account.getGender());
            pstmt.setString(5, account.getAvatar());
            pstmt.setString(6, account.getNumber());
            pstmt.setInt(7, account.getRole());
            pstmt.setInt(8, account.getId());

            pstmt.executeUpdate();

            // clean up environment
            pstmt.close();
            connect.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteSort(int id) {

        String query = "update accounts set account_isDelete = 1 where account_id = ?";
        Connection connect = null;
        PreparedStatement pstmt = null;

        try {
            connect = ConnectDB.getConnection();
            pstmt = connect.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            // clean up environment
            pstmt.close();
            connect.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }




    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAO();
        // System.out.println(accountDAO.gets());
        // System.out.println(accountDAO.get(1));

    }
}
