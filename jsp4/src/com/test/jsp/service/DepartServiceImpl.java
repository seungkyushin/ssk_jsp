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
	public ArrayList<DepartInfo> selectDepartList(String search, String searchStr) {
		ArrayList<DepartInfo> departList = null;
		DBCon dbCon = new DBCon();
		try {
			DepartDAO ddao = new DepartDAOImpl(dbCon.getConnection());
			departList = ddao.selectDepartList(search,searchStr);
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
	public  int insertDepart(DepartInfo di) {
		DBCon dbCon = new DBCon();
		try {
				DepartDAO ddao = new DepartDAOImpl(dbCon.getConnection());
				return ddao.insertDepart(di);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				dbCon.closeCon();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	@Override
	public DepartInfo selectDepart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteDepart(DepartInfo di) {
		DBCon dbCon = new DBCon();
		try {
				DepartDAO ddao = new DepartDAOImpl(dbCon.getConnection());
				return ddao.deleteDepart(di);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				dbCon.closeCon();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	@Override
	public int updateDepart(DepartInfo di) {
		DBCon dbCon = new DBCon();
		try {
				DepartDAO ddao = new DepartDAOImpl(dbCon.getConnection());
				return ddao.updateDepart(di);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				dbCon.closeCon();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
		
	}
	

}
