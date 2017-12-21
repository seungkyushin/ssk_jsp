package com.test.jsp.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.test.jsp.common.DBCon;
import com.test.jsp.dto.DepartDAO;
import com.test.jsp.dto.DepartDAOImpl;
import com.test.jsp.dto.DepartInfo;

public class DepartServiceImpl implements DepartService{

	@Override
	public ArrayList<DepartInfo> selectDepartList() {
		ArrayList<DepartInfo> departList = null;
		DBCon dbCon = new DBCon();
		try {
			DepartDAO ddao = new DepartDAOImpl(dbCon.getConnection());
			departList = ddao.selectDepartList();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		return departList;
	}

	@Override
	public DepartInfo selectDepart(int diNo) {
		DepartInfo di = null;
		DBCon dbCon = new DBCon();
		try {
			DepartDAO ddao = new DepartDAOImpl(dbCon.getConnection());
			di = ddao.selectDepart(diNo);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		return di;
		
	}

	@Override
	public void updateDepart(HttpServletRequest req) {
				
	}

	@Override
	public void insertDepart(HttpServletRequest req) {
	
		
	}

	@Override
	public DepartInfo selectDepart() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
