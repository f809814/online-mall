package user.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Thread.sleep;

/**
 * @author fu
 * @date 2018/12/23 - 14:30
 */
@WebServlet(name = "AjaxTest" ,urlPatterns = "/ajax")
public class AjaxTest extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException{
        System.out.println("进入AjaxTest servlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        System.out.println("testCache");
        String kind = request.getParameter("kind");
        System.out.println("kind:" + kind);
        PrintWriter out = response.getWriter();
        if(kind.equals("info")) {
//            try {
//                sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            out.println("调用ajax成功");
        }else if(kind.equals("error")) {
            String inputString = request.getParameter("str");
            if(inputString.equals("fu"))
                out.println("验证成功");
            else
                out.println("输入格式有误");
        }
    }
}
