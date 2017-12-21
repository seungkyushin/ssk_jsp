 package com.test.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.jsp.service.DepartService;
import com.test.jsp.service.DepartServiceImpl;

public class DepartServlet extends HttpServlet{

	DepartService ds = new DepartServiceImpl();
	
	//< url에 입력하면 get방식이다.
	public void doGet(HttpServletRequest req,
			HttpServletResponse res)throws
	IOException, ServletException{
		System.out.println("doget");
		doProcess(req,res);
	}
	private String getCommandFormUri(String uri)
	{
		//< 마지막부터 체크해서 "/" 값을 찾은 index값 추
		int idx = uri.lastIndexOf("/");
		if(idx != -1)
		{
			return uri.substring(idx+1);
		}
		return uri;
	}
	public void doPost(HttpServletRequest req,
			HttpServletResponse res)throws
	IOException, ServletException{
		System.out.println("doPost");
		doProcess(req,res);
	}
	
	public void doProcess(HttpServletRequest req,
			HttpServletResponse res)throws
	IOException, ServletException{
		String uri = req.getRequestURI();
		System.out.println(uri);
		String cmd = getCommandFormUri(uri);
		System.out.println(cmd);

		if( cmd.equals("list") )
		{
			req.setAttribute("departList", ds.selectDepartList());
			
		}else if( cmd.equals("view"))
		{
			String diNo = req.getParameter("diNo");
			req.setAttribute("depart", ds.selectDepart(Integer.parseInt(diNo)));
		}else if( cmd.equals("update"))
		{
			req.setAttribute("depart", ds.selectDepart());
		}else if( cmd.equals("insert"))
		{
			
		}else {
			uri = "/error"; 
		}
		
		//< 배달원
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/" + uri + ".jsp");

		rd.forward(req, res);
	}
}
