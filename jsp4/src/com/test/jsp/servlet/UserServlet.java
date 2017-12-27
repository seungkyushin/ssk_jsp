 package com.test.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.test.jsp.dto.UserInfo;
import com.test.jsp.service.DepartService;
import com.test.jsp.service.DepartServiceImpl;
import com.test.jsp.service.UserService;
import com.test.jsp.service.UserServiceImpl;

public class UserServlet extends HttpServlet{

	UserService us = new UserServiceImpl();
	DepartService ds = new DepartServiceImpl();
	
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
		System.out.println("UserServlet");
		
		String mytest = req.getParameter("mytest");
		System.out.println(mytest);
		String str = req.getCharacterEncoding();
		System.out.println("chatset : " + str);
		 
		PrintWriter out = res.getWriter();
		String cmd = req.getParameter("cmd");
		System.out.println(req.getRequestURI());
		if(cmd==null) {
			res.sendRedirect("/error.jsp");
		}else if(cmd.equals("list")) {
			System.out.println("cmd : " + cmd.toString());
			ArrayList<UserInfo>	userList = us.getUserList();
			Gson gs = new Gson();
			//< JSP에서 파싱할 수 있도록 스트링으로 변경
			//<gs.toJson(userList) 하기전에는 객체
			out.println(gs.toJson(userList));
			
		}else if(cmd.equals("login")){
			System.out.println("cmd : " + cmd.toString());
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			HashMap<String,String> hm = new HashMap<String,String>();
			try
			{
				UserInfo ui = us.getUser(id, pwd);
	
				if( ui == null )
				{
					hm.put("result", "no");
					hm.put("msg", "아이디와 비밀번호를 확인하세요");
					
				}else
				{
					HttpSession hs = req.getSession();
					hs.setAttribute("user", ui);
					hm.put("result", "ok");
					hm.put("msg", ui.getUserName() + "님 환영");
					
				}
				Gson gs = new Gson();
				out.println(gs.toJson(hm));
				
			}catch(ClassNotFoundException | SQLException e){
				e.printStackTrace();
			}
		
		}else if(cmd.equals("logout")){
			System.out.println("cmd : " + cmd.toString());
			HttpSession hs = req.getSession();
			hs.invalidate(); //< 세션의 값을 초기화한다.
			res.sendRedirect("/user/login.jsp");
			
		}else if(cmd.equals("join")) {
			String params = req.getParameter("params");
			Gson gs = new Gson();
			//HashMap hm = gs.fromJson(params, HashMap.class);
			UserInfo ui = gs.fromJson(params, UserInfo.class);
			System.out.println(ui);
			int result = us.insertUser(ui);
			HashMap<String,String> hm = new HashMap<String,String>();
			
			if(result!=0)
			{
				hm.put("result","ok");
				hm.put("msg","회원가입에 성공하셨습니다.");
				hm.put("url","/user/login.jsp");
			}
			else
			{
				hm.put("result","no");
				hm.put("msg","회원가입에 실패하였습니다.");
			}
			
			out.println(gs.toJson(hm));
			
		}else if(cmd.equals("view"))
		{
			int userNo =  Integer.parseInt(req.getParameter("userno"));
			UserInfo ui = us.getUser(userNo);
			Gson gs = new Gson();
			out.println(gs.toJson(ui));
			
			
		}else if(cmd.equals("update"))
		{
			int result = us.updateUser(null);

			HashMap<String,String> hm = new HashMap<String,String>();
	
				if( result == 0 )
				{
					hm.put("result", "no");
					hm.put("msg", "회원수정이 실패하셨습니다.");
					
				}else
				{
					hm.put("result", "ok");
					hm.put("msg", "회원수정이 성공하셨습니다.");
					hm.put("url", "/user/view.jsp?userno=");
					
				}
			Gson gs = new Gson();
			out.println(gs.toJson(hm));
			
			
		}
		else if(cmd.equals("delete"))
		{
			String checkPwd = req.getParameter("checkPwd");
			UserInfo ui = (UserInfo)req.getSession().getAttribute("user");
			ui.setUserPwd(checkPwd);
			int result = us.deleteUser(ui);
			
			HashMap<String,String> hm = new HashMap<String,String>();
	
				if( result == 0 )
				{
					hm.put("result", "no");
					hm.put("msg", "회원 탈퇴에 실패하셨습니다.");
					
				}else
				{
					hm.put("result", "ok");
					hm.put("msg", "회원탈퇴에 성공하셨습니다.");
					hm.put("url", "/user/logout.user?cmd=logout");
					
				}
			Gson gs = new Gson();
			out.println(gs.toJson(hm));
			
			
		}else if(cmd.equals("checkPwd"))
		{
			String checkPwd = req.getParameter("checkPwd");
			HttpSession hs = req.getSession();
			UserInfo ui = (UserInfo)hs.getAttribute("user");
			String userPwd = ui.getUserPwd();
			HashMap<String,String> hm = new HashMap<String,String>();
			hm.put("result","no");
			hm.put("msg","비밀번호가 틀렸습니다.");
			if(checkPwd.equals(userPwd))
			{
				hm.put("result","ok");
				hm.put("msg","");
			}
			
			Gson gs = new Gson();
			out.println(gs.toJson(hm));
			
		}else if(cmd.equals("dino"))
		{
			Gson gs = new Gson();
			out.println(gs.toJson(ds.selectDepartList(null, null)));
			
		}
		else
		{
			System.out.println("cmd : " + cmd.toString());
			res.sendRedirect("/error.jsp");
		}
	}
	
	
}
