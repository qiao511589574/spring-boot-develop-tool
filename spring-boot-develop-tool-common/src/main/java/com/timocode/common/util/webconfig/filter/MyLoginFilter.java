package com.timocode.common.util.webconfig.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登陆过滤器 LoginFilter 配置
 */
@Slf4j
public class MyLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
        if(request.getRequestURI().indexOf("/login") != -1 ||
        request.getRequestURI().indexOf("/test") != -1) {
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            if (session != null && session.getAttribute("user") != null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                wrapper.sendRedirect("/login");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
