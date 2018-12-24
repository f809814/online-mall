package user.servlet;

import Utils.Db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author fu
 * @date 2018/12/19 - 15:41
 */
@WebServlet(name = "Register", urlPatterns = "/register")
public class Register extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入register servlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        HashMap<String, String> form= new HashMap<String, String>();
        HashMap<String, String> errors= new HashMap<String, String>();
        boolean isRe = false;
        try {
            isRe = Db.userIsRegister(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(isRe == false){

            boolean addRe = false;
            System.out.println("该用户未注册!");
            try {
                addRe = Db.addUser(name, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(addRe == false){
                System.out.println("注册失败");
                form.put("username", name);
                form.put("password", password);
                errors.put("username", "注册失败，请检查用户名和密码格式");
                request.setAttribute("form", form);
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("/jsp/Register.jsp").forward(request, response);
                return;
            }
            System.out.println("插入数据结束");
            response.sendRedirect("/online-mall/jsp/registerSuccess.jsp");
        }else {
            System.out.println("该用户已注册");
            form.put("username", name);
            form.put("password", password);
            errors.put("username", "该用户已注册");
            request.setAttribute("form", form);
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/jsp/Register.jsp").forward(request, response);
        }
    }
}
