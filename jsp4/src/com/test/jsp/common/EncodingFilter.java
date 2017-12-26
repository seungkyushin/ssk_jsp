package com.test.jsp.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("필터클래스 종료!!");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		//< doGet이나 doPost으로 이동하게된다.
		fc.doFilter(req, res);
		
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("필터클래스 최초 생성!!");
	}

}
