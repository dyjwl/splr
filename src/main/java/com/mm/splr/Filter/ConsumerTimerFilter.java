package com.mm.splr.Filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

@Component
public class ConsumerTimerFilter implements Filter {
    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("timer Filter begin");
        long start=new Date().getTime();
        chain.doFilter(request, response);
        long end=new Date().getTime();
        System.out.println("timer Filter end,cost time:"+(end-start));
    }
}