package com.test.jsp.service;

import javax.servlet.http.HttpServletRequest;

public interface DepartService {
	public void selectDepartList(HttpServletRequest req);
	public void selectDepart(HttpServletRequest req);
	public void updateDepart(HttpServletRequest req);
	public void insertDepart(HttpServletRequest req);
	

}
