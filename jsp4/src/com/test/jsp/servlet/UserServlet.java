package com.test.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.jsp.service.UserService;
import com.test.jsp.service.UserServiceImpl;

public class UserServlet extends HttpServlet{

	UserService us = new UserServiceImpl();
	
	public void doGet(HttpServletRequest req,
			HttpServletResponse res)throws
	IOException, ServletException{
		doProcess(req,res);
	}

	public void doPost(HttpServletRequest req,
			HttpServletResponse res)throws
	IOException, ServletException{
		doProcess(req,res);
	}
	
	public void doProcess(HttpServletRequest req,
			HttpServletResponse res)throws
	IOException, ServletException{
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		String cmd = req.getParameter("cmd");
		System.out.println(req.getRequestURI());
		if(cmd==null) {
			res.sendRedirect("/error.jsp");
		}else if(cmd.equals("list")) {
			String html="";
			ArrayList<HashMap<String,String>>
			userList = us.getUserList();
			for(HashMap<String,String> map : userList){
				html += "<tr>";
				Iterator<String> it = map.keySet().iterator();
				while(it.hasNext()){
					String key = it.next();
					html += "<td>" + map.get(key) + "</td>";
				}
				html += "</tr>";
			}
			out.println(html);
		}else if(cmd.equals("login")){
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String str = "";
			if("test".equals(id)) {
				if("test".equals(pwd)) {
					str += "{\"result\":\"ok\",";
					str += "\"msg\":\"로그인 되셨습니다.\"";
					str += "}";
				}else {
					str += "{\"result\":\"no\",";
					str += "\"msg\":\"비밀번호 틀림\"";
					str += "}";
				}
			}else {
				str += "{\"result\":\"no\",";
				str += "\"msg\":\"아이디 틀림\"";
				str += "}";
			}
			out.println(str);
		}else {
			res.sendRedirect("/error.jsp");
		}
	}
}
