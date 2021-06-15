package kr.ac.kopo.kopo08.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.kopo08.domain.Hubo;

public class HuboDaoImpl implements HuboDao{

	@Override
	//insert data in hubotable
	public void create(Hubo hubo) throws SQLException {
		String query = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
			Statement stmt = con.createStatement(); 
		
			query = String.format("insert into hubo values(%d, '%s');", hubo.getKiho(), hubo.getName());
			stmt.execute(query);

			stmt.close();
			con.close();
		} catch (Exception e) {
			String err = e.getMessage();
			System.out.println(err);
			e.printStackTrace();
		} finally {}

	}

	@Override
	//delete data in hubotable
	public void delete(int kiho) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		String query = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
			stmt = con.createStatement();
			query = "delete from hubo where kiho=" + kiho + ";";
			stmt.execute(query);
			
			stmt.close();
			con.close();
		} catch (Exception e) {
			String err = e.getMessage();
			System.out.println(err);
		} finally {
			stmt.close();
			con.close();
		}
		
	}

	@Override
	public List<Hubo> selectAll() throws SQLException {
		List<Hubo> retAll = new ArrayList<Hubo>();
		Hubo hubo = null;
		Connection con = null;
		Statement stmt = null;
		
		String query = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
			stmt = con.createStatement(); 

			query = "select * from hubo;";
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				hubo = new Hubo();
				hubo.setKiho(rs.getInt(1));
				hubo.setName(rs.getString(2));
				retAll.add(hubo);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			String err = e.getMessage();
			System.out.println(err);
		} finally {
			stmt.close();
			con.close();
		}
		
		if (retAll.size() == 0) {
			return null;
		} else {
			return retAll;
		}
	}

	@Override
	public List<Hubo> selectOne(int kiho) throws SQLException {
		List<Hubo> retOne = new ArrayList<Hubo>();
		Hubo hubo = null;
		Connection con = null;
		Statement stmt = null;
		String query = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
			stmt = con.createStatement();
			query = "select * from hubo where kiho;";
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				hubo = new Hubo();
				hubo.setKiho(rs.getInt(1));
				hubo.setName(rs.getString(2));
				retOne.add(hubo);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			String err = e.getMessage();
		} finally {
			stmt.close();
			con.close();
		}
		
		return retOne;
		
	}
	
}
