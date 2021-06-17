package kr.ac.kopo.kopo08.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.kopo08.domain.Hubo;

public class HuboDaoImpl implements HuboDao{
	private static HuboDaoImpl instance = new HuboDaoImpl();
	
	private HuboDaoImpl() {
		
	}
	
	public static HuboDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	//insert data in hubotable
	public void create(Hubo hubo) {
		String query = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
			Statement stmt = con.createStatement(); 
		
			query = String.format("insert into hubo(name) values('%s');", hubo.getName());
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
	public void delete(int kiho) {
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
		} finally {}
		
	}

	@Override
	public List<Hubo> selectAll(){
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
		} finally {}
		
		if (retAll.size() == 0) {
			return null;
		} else {
			return retAll;
		}
	}
	

	@Override
	public Hubo selectOne(int kiho) {
		Hubo hubo = null;
		Connection con = null;
		Statement stmt = null;
		
		String query = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
			stmt = con.createStatement(); 

			query = "select * from hubo where kiho=" + kiho + ";";
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				hubo = new Hubo();
				hubo.setKiho(rs.getInt(1));
				hubo.setName(rs.getString(2));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			String err = e.getMessage();
			System.out.println(err);
		} finally {}
		
		return hubo;

	}	

	@Override
	public void update(Hubo hubo) {
		// TODO Auto-generated method stub
		
	}

}
