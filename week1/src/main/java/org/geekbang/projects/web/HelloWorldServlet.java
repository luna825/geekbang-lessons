package org.geekbang.projects.web;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet implements Servlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("hello world");
        out.close();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
