package Utils;

import java.sql.*;

/**
 * @author fu
 * @date 2018/12/18 - 16:26
 */
public class Db {

    public static boolean userIsRegister(String name) throws SQLException {
        if(name == null)
            return false;
        Connection connection = C3p0Utils.getConnection();
        if(connection == null){
            System.out.println("get connection falied!");
            return false;
        }
        String query = "SELECT * FROM online_mall_user WHERE name=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,name);
        ResultSet rs = pst.executeQuery();        // 执行查询
        if(rs.next()) {
            C3p0Utils.close(connection, pst, rs);
            return true;
        } else {
            C3p0Utils.close(connection, pst, rs);
            return false;
        }
    }
    public static int userVerify(String name, String password) throws SQLException {
        if(name == null || password == null)
            return -1;
        Connection connection = C3p0Utils.getConnection();
        if(connection == null){
            System.out.println("get connection falied!");
            return -2;
        }
        String query = "SELECT * FROM online_mall_user WHERE name=? AND password=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,name);
        pst.setString(2,password);
        ResultSet rs = pst.executeQuery();        // 执行查询
        if(rs.next()) {
            C3p0Utils.close(connection, pst, rs);
            return 0;
        } else {
            C3p0Utils.close(connection, pst, rs);
            return 1;
        }
    }
    public static boolean addUser(String name, String password) throws SQLException {
        if(name == null || password == null || name.length() < 2 || password.length() < 2)
            return false;
        Connection connection = C3p0Utils.getConnection();
        if(connection == null){
            System.out.println("get connection falied!");
            return false;
        }
        String insert = "INSERT INTO online_mall_user (name,password,register_time) VALUES (?,?,?)";
        PreparedStatement pst = connection.prepareStatement(insert);
        pst.setString(1,name);
        pst.setString(2,password);
        pst.setTimestamp(3,new Timestamp(new java.util.Date().getTime()));
        int inRes = pst.executeUpdate(); // 执行查询
        boolean res;
        if (inRes == 0)
            res = false;
        else
            res = true;
        pst.close();
        connection.close();
        return res;
    }
}
