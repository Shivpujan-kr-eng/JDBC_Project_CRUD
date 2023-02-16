package com.finalpakage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.finalpakage.*;

public class Dao {
	
	Connection conn=Conn.getConnection();
	Entity entity=null;
	
	public boolean insertingData(Entity entity) {
		boolean f=false;
		
		String sql="insert into college.entity values(?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, entity.getId());
			ps.setString(2, entity.getName());
			ps.setString(3, entity.getJob());
			ps.setInt(4, entity.getSalary());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (SQLException e) {
			System.out.println("error encountered while inserting data ");
			e.printStackTrace();
		}
		
		
		return f;
	}
	public Entity gettingData(int id) {
		
		
		String sql="select * from college.entity where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, entity.getId());
			
			ResultSet rs=ps.executeQuery();
			entity.setId(rs.getInt(1));
			entity.setName(rs.getString(2));
			entity.setJob(rs.getString(3));
			entity.setSalary(rs.getInt(4));
			
		} catch (SQLException e) {
			System.out.println("error encountered while inserting data ");
			e.printStackTrace();
		}
		
		
		return entity;
	}
	public boolean updatingData(int id,Entity entity) {
		boolean f=false;
		
		System.out.println("enter name");
		
		
		String sql="update college.entity set name=? , salary=?,job=? where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, entity.getName());
			ps.setInt(2, entity.getSalary());
			ps.setString(3, entity.getJob());
			
			ps.setInt(4, id);
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (SQLException e) {
			System.out.println("error encountered while inserting data or may be you have given id that doesn't exist");
			e.printStackTrace();
		}
		
		
		return f;
	}
	public void gettingAllData() {
		
		
		String sql="select * from college.entity ";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
//			ps.setInt(1, entity.getId());
//			
			ResultSet rs=ps.executeQuery();
//			entity.setId(rs.getInt(1));
//			entity.setName(rs.getString(2));
//			entity.setJob(rs.getString(3));
//			entity.setSalary(rs.getInt(4));
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
			
		} catch (SQLException e) {
			System.out.println("error encountered while inserting data ");
			e.printStackTrace();
		}
		
		
		
	}
	public boolean deletingData(int id) {
		
		boolean f=false;
		String sql="delete  from college.entity where entity.idEntity="+id;
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			int rs=ps.executeUpdate();
			
			if(rs==1) {
				f=true;
				
			}
			
		} catch (SQLException e) {
			System.out.println("error encountered while inserting data ");
			e.printStackTrace();
		}
		
		
		return f;
	}
	
	
	
}
