package user.servlet;

import Utils.Db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @author fu
 * @date 2018/12/18 - 14:36
 */
@WebServlet(name = "login" ,urlPatterns = "/login")
public class login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入login servlet");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        boolean isRe = false;//是否注册
        int vrRe = -3;//验证密码
        try {
            isRe = Db.userIsRegister(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(isRe == false){
            PrintWriter out = resp.getWriter();
            out.println("您还未注册！");
            System.out.println("该用户未注册!");
            return;
        }
        System.out.println("该用户是注册用户");
        try {
            vrRe = Db.userVerify(name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(vrRe == 0) {
            System.out.println("认证成功");
            req.getRequestDispatcher("/jsp/welcome.jsp").forward(req, resp);
        }else{
            PrintWriter out = resp.getWriter();
            out.println("密码错误！");
            System.out.println("密码错误!");
        }
    }
}
