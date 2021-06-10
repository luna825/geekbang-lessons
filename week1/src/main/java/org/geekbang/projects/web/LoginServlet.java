package org.geekbang.projects.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=utf8");

        PrintWriter out = resp.getWriter();

        out.println("<form method=post action=portal>");
        out.println("<div><span>请输入用户名:</span>");
        out.println("<input type=text name=username />");
        out.println("<input type=submit value=登录 /></div></form>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
