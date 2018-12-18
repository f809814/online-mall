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
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("username");
        //String password = req.getParameter("password");
        boolean isRe = false;
        try {
            isRe = Db.userIsRegister(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(name.equals("付卓军")){
            System.out.println("该用户是注册用户");
            req.getRequestDispatcher("welcome.jsp").forward(req, resp);
            return;
        }
        if(isRe == false){
            PrintWriter out = resp.getWriter();
            out.println("您还未注册！");
            System.out.println("该用户未注册!");
            return;
        }
        System.out.println("该用户是注册用户");
        req.getRequestDispatcher(req.getContextPath() + "/jsp/welcome.jsp").forward(req, resp);
    }
}
