package com.test.jsp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.jsp.common.DBCon;
import com.test.jsp.dto.UserInfo;

public class UserServiceImpl implements UserService{

	
	public int insertUser(HashMap hm)
	{
		int result = 0;
		
		DBCon dbCon = new DBCon();
		try {
			Connection con = dbCon.getConnection();
			String sql = "INSERT INTO user_info(username, userid, userpwd, userage,useraddress)";
			       sql += "values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,(String)hm.get("name"));
			ps.setString(2,(String)hm.get("id"));
			ps.setString(3,(String)hm.get("pwd"));
			ps.setString(4,(String)hm.get("age"));
			ps.setString(5,(String)hm.get("address"));
			
			result = ps.executeUpdate();
		}catch(Exception e)		{
			e.printStackTrace();
		}finally{
			try {
				dbCon.closeCon();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	return result;
		
	}
	
	public int insertUser(UserInfo ui)
	{
		int result = 0;
		
		DBCon dbCon = new DBCon();
		try {
			Connection con = dbCon.getConnection();
			String sql = "INSERT INTO user_info(username, userid, userpwd, userage,useraddress)";
			       sql += "values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,ui.getUserName());
			ps.setString(2,ui.getUserId());
			ps.setString(3,ui.getUserPwd());
			ps.setInt(4,ui.getUserAge());
			ps.setString(5,ui.getUserAddress());
			
			result = ps.executeUpdate();
		}catch(Exception e)		{
			e.printStackTrace();
		}finally{
			try {
				dbCon.closeCon();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	return result;
		
	}
	
	public UserInfo getUser(String id, String pwd) throws ClassNotFoundException, SQLException	
	{
		DBCon dbCon = new DBCon();
		Connection con = dbCon.getConnection();
		
		String sql = "select * from user_info ui," + 
				" depart_info di" + 
				" where ui.dino = di.dino";
		sql += " and ui.userid=? and ui.userpwd=?"; //< SQL인젝션을 위한 코드 ?는 바인딩을 위함
												    //< 만앞에 띄어쓰기 
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id); //< 바인딩
		ps.setString(2, pwd); //< 바인딩
		ResultSet rs = ps.executeQuery();
		
		
		UserInfo ui = null;
		
		while(rs.next()) {
			ui = new UserInfo();
			ui.setUserNo(rs.getInt("userno"));
			ui.setUserName(rs.getString("username"));
			ui.setUserId(rs.getString("userid"));
			ui.setUserPwd(rs.getString("userpwd"));
			ui.setUserAddress(rs.getString("useraddress"));
			ui.setDiNo(rs.getInt("dino"));
			ui.setUserAge(rs.getInt("userage"));
		}
		
		return ui;
	}
	public ArrayList<UserInfo> getUserList(){
		ArrayList<UserInfo> al= new ArrayList<UserInfo>();
		DBCon dbCon = new DBCon();
		try {
			Connection con = dbCon.getConnection();
			String sql = "select * from user_info ui," + 
					" depart_info di" + 
					" where ui.dino = di.dino";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				UserInfo ui  = new UserInfo();
				ui.setUserNo(rs.getInt("userno"));
				ui.setUserName(rs.getString("username"));
				ui.setUserId(rs.getString("userid"));
				ui.setUserPwd(rs.getString("userpwd"));
				ui.setUserAge(rs.getInt("userage"));
				ui.setUserAddress(rs.getString("useraddress"));
				al.add(ui);
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally{
			try {
				dbCon.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}

}
