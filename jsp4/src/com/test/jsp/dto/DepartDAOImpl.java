package com.test.jsp.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DepartDAOImpl implements DepartDAO{
	private Connection con;
	
	public DepartDAOImpl(Connection con) {
		this.con = con;
	}
	
	@Override
	public ArrayList<DepartInfo> selectDepartList() throws SQLException {
		String sql = "SELECT * FROM depart_info";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<DepartInfo> diList = new ArrayList<DepartInfo>();
		while(rs.next()) {
			DepartInfo di = new DepartInfo();
			di.setDiNo(rs.getInt("dino"));
			di.setDiName(rs.getString("diname"));
			di.setDiEtc(rs.getString("dietc"));
			diList.add(di);
		}
		return diList;
	}

	@Override
	public DepartInfo selectDepart(int diNo) throws SQLException{

		String sql = "SELECT * FROM depart_info WHERE dino=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, diNo);
		ResultSet rs = ps.executeQuery();
		DepartInfo di = null;
		while(rs.next()) {
			di = new DepartInfo();
			di.setDiNo(rs.getInt("dino"));
			di.setDiName(rs.getString("diname"));
			di.setDiEtc(rs.getString("dietc"));
		}
		
		return di;
	}

	@Override
	public void updateDepart() {
	
		
	}

	@Override
	public void insertDepart() {

		
	}

}
