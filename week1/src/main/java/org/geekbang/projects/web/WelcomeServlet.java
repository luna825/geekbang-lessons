package org.geekbang.projects.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {

    private String greeting;

    @Override
    public void init() {
        // 获取欢迎的文本
        greeting = getInitParameter("greeting");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf8");

        String user = req.getParameter("username");
        String welcomeInfo = greeting + ", " + user;

        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>");
        out.println("Welcome Page");
        out.println("</title></head><body>");
        out.println(welcomeInfo);
        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }


}
