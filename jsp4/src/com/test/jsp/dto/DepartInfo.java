package com.test.jsp.dto;

public class DepartInfo {
	private int DiNo;
	private String DiName;
	private String DiEtc;
	private String Ditest="1";
	


	public String getDItest() {
		return Ditest;
	}

	public void setDItest(String ditest) {
		Ditest = ditest;
	}

	public int getDiNo() {
		return DiNo;
	}

	public void setDiNo(int diNo) {
		DiNo = diNo;
	}

	public String getDiName() {
		return DiName;
	}

	public void setDiName(String diName) {
		DiName = diName;
	}

	public String getDiEtc() {
		return DiEtc;
	}

	public void setDiEtc(String diEtc) {
		DiEtc = diEtc;
	}

	@Override
	public String toString() {
		return "DepartInfo [DiNo=" + DiNo + ", DiName=" + DiName + ", DiEtc=" + DiEtc + "]";
	}

}
