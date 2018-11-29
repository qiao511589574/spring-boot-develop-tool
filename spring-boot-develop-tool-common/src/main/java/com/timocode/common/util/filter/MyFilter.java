package com.timocode.common.util.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
        log.info(servletRequest.getParameter("name"));
        HttpServletRequest hrequest = (HttpServletRequest) servletRequest;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
        if(hrequest.getRequestURI().indexOf("/index") != -1 ||
            hrequest.getRequestURI().indexOf("/asd") != -1 ||
            hrequest.getRequestURI().indexOf("/online") != -1 ||
            hrequest.getRequestURI().indexOf("/login") != -1 )
        {
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            wrapper.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}
