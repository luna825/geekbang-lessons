package org.geekbang.projects.web;

import org.apache.commons.lang.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 请求转发实例
 * 首先判断用户有没有输入用户名，如果没有则调用RequestDispatcher接口的include方法，将请求发给LoginServlet
 * 如果用户已经输入了用户名，则调用RequestDispatcher接口的forward方法将请求转发给WelcomeServlet，展示欢迎页面
 * include 与 forward区别在于
 * forward 将控制权交给新的servlet,后面的代码不再执行
 * include 将控权交给servlet后处理完毕后，执行控制权返回，也就是后面的代码继续执行
 * */
public class PortalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");

        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>");
        out.println("登录页面");
        out.println("</title></head><body>");

        String name = req.getParameter("username");

        ServletContext context = getServletContext();

        if(StringUtils.isNotEmpty(name)){

            RequestDispatcher rd = context.getRequestDispatcher("/welcome");
            rd.forward(req, resp);
        }else {
            RequestDispatcher rd = context.getRequestDispatcher("/login");
            rd.include(req, resp);
        }

        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
