package com.edu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "UserLoginFilter", urlPatterns = {"/pages/admin/*","/pages/student/*","/pages/teacher/*","/admin/*","/student/*","/teacher/*"})
public class UserLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Object user = request.getSession().getAttribute("user");
        if (user != null) {
            chain.doFilter(req, resp);
        }else {
            request.setAttribute("msg","请先登录再进行操作！");
            request.getRequestDispatcher("/pages/page/login.jsp").forward(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
