 package com.test.jsp.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.jsp.dto.DepartInfo;
import com.test.jsp.service.DepartService;
import com.test.jsp.service.DepartServiceImpl;

public class DepartServlet extends HttpServlet{

	DepartService ds = new DepartServiceImpl();
	
	//< url에 입력하면 get방식이다.
	public void doGet(HttpServletRequest req,
			HttpServletResponse res)throws
	IOException, ServletException{
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
		doProcess(req,res);
	}
	
	public void doProcess(HttpServletRequest req,
			HttpServletResponse res)throws
	IOException, ServletException{
		String uri = req.getRequestURI();
		String cmd = getCommandFormUri(uri);
		System.out.println("Servlet cmd : " + cmd);

		if( cmd.equals("list") )
		{
			String search = req.getParameter("serchOption");
			String searchStr = req.getParameter("diName");
			Map<String,String[]> param = req.getParameterMap();
			Iterator<String> it = param.keySet().iterator();
			while(it.hasNext())
			{
				String key = it.next();
				System.out.println("[" + key + "] : " + param.get(key));
			}
			
			req.setAttribute("departList", ds.selectDepartList(search,searchStr));
			
		}else if( cmd.equals("view") || cmd.equals("update") )
		{
			String diNo = req.getParameter("dino");
			req.setAttribute("depart", ds.selectDepart(Integer.parseInt(diNo)));
		}else if( cmd.equals("insert"))
		{
			
		}else if( cmd.equals("insert_ok")) {
			String diName = req.getParameter("diName");
			String diEtc = req.getParameter("diEtc");
			DepartInfo di = new DepartInfo();
			di.setDiName(diName);
			di.setDiEtc(diEtc);
			req.setAttribute("insert", ds.insertDepart(di));
			uri = "depart/list";
		}else if( cmd.equals("delete")) {
			int diNo = Integer.parseInt(req.getParameter("dino"));
			DepartInfo di = new DepartInfo();
			di.setDiNo(diNo);
//			int result = ds.deleteDepart(di);
//			String msg = "삭제 되었습니다.";
//			if(result!=1)
//			{
//				msg = "삭제에 실패하였습니다.";
//			}
//			req.setAttribute("msg",msg);
			req.setAttribute("delete", ds.deleteDepart(di));
			uri = "depart/list";
		}
		
		else {
			uri = "/error"; 
		}
		
		//< 배달원
		System.out.println("Servelt uri : " + uri);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/" + uri + ".jsp");

		rd.forward(req, res);
	}
}
