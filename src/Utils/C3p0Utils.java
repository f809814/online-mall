package Utils;
import java.sql.*;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * @author fu
 * @date 2018/12/18 - 16:27
 */
public class C3p0Utils {
    //通过标识名来创建相应连接池
    static ComboPooledDataSource dataSource = new ComboPooledDataSource("c3p0_online_mall");
    //从连接池中取用一个连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();

        } catch (Exception e) {
        }
        return connection;
    }
    //释放连接回连接池
    public static void close(Connection conn, PreparedStatement pst, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
}
