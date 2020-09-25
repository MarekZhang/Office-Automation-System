package com.imooc.oa.global;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {
  private String encoding = "utf-8";

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    if(filterConfig.getInitParameter("encoding") != null){
      encoding = filterConfig.getInitParameter("encoding");
    }
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;
    req.setCharacterEncoding(encoding);
    resp.setCharacterEncoding(encoding);
    filterChain.doFilter(req, resp);
  }

  @Override
  public void destroy() {

  }
}
