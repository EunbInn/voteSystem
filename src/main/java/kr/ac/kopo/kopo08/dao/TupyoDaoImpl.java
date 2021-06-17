package kr.ac.kopo.kopo08.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.kopo08.domain.Hubo;
import kr.ac.kopo.kopo08.domain.Tupyo;

public class TupyoDaoImpl implements TupyoDao{
	private static TupyoDaoImpl instance = new TupyoDaoImpl();
	
	private TupyoDaoImpl() {
		
	}
	
	public static TupyoDaoImpl getInstance() {
		return instance;
	}

	@Override
	//insert data
	public void create(Tupyo tupyo) {
		String query = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
			Statement stmt = con.createStatement(); 
		
			query = String.format("insert into tupyo(kiho, age) values(%d, %d);", tupyo.getKiho(), tupyo.getAge());
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
	//delete data
	public void delete(int kiho) {
		String query = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
			Statement stmt = con.createStatement(); 
		
			query = String.format("delete from Tupyo where kiho=%d;", kiho);
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
	//select all data and return List
	public List<Tupyo> selectAll() {
		List<Tupyo> tupyoArr = new ArrayList<Tupyo>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
			Statement stmt = con.createStatement(); 
			String query = "";
			
			Tupyo tupyo;
			query = "select * from tupyo;";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				tupyo = new Tupyo();
				tupyo.setId(rs.getInt(1));
				tupyo.setAge(rs.getInt(2));
				tupyo.setKiho(rs.getInt(3));
				tupyoArr.add(tupyo);
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			String err = e.getMessage();
			System.out.println(err);
			e.printStackTrace();
		} finally {}
		
		if (tupyoArr.size() == 0) {
			return null;
		} else {
			return tupyoArr;
		}
	}
	
	@Override
	public List<Tupyo> selectOne(int kiho) {
		List<Tupyo> retOne = new ArrayList<Tupyo>();
		Tupyo tupyo = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
			Statement stmt = con.createStatement(); 
			String query = "";
			
			query = "select * from tupyo where kiho=" + kiho + ";";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				tupyo = new Tupyo();
				tupyo.setId(rs.getInt(1));
				tupyo.setAge(rs.getInt(2));
				tupyo.setKiho(rs.getInt(3));
				retOne.add(tupyo);
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			String err = e.getMessage();
			System.out.println(err);
			e.printStackTrace();
		} finally {}
		if (retOne.size() == 0) {
			return null;
		} else {
			return retOne;
		}

	}


	@Override
	public void update(Tupyo tupyo) {
		// TODO Auto-generated method stub
		
	}

	
}
