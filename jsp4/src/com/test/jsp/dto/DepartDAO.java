package com.test.jsp.dto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public interface DepartDAO {

	public ArrayList<DepartInfo> selectDepartList() throws SQLException;
	public DepartInfo selectDepart(int diNo) throws SQLException;
	public void updateDepart();
	public void insertDepart();
}
