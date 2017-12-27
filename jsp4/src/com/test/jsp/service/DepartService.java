package com.test.jsp.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.test.jsp.dto.DepartInfo;

public interface DepartService {
	//public void selectDepartList(HttpServletRequest req);
	public ArrayList<DepartInfo> selectDepartList(String search, String searchStr);
	public DepartInfo selectDepart(int diNo);
	public DepartInfo selectDepart();
	public int updateDepart(DepartInfo di);
	public int insertDepart(DepartInfo di);
	public int deleteDepart(DepartInfo di);

}
