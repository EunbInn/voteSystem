package kr.ac.kopo.kopo08.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.kopo08.domain.Tupyo;

public class TupyoDaoImpl implements TupyoDao{

	@Override
	public void create(Tupyo tupyo) {
		String query = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
			Statement stmt = con.createStatement(); 
		
			query = String.format("insert into tupyo values(%d, %d);", tupyo.getKiho(), tupyo.getAge());
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
	public List<double[]> selectOneGroupbyAge(int kiho) {
		String query = "";
		List<double[]> viewOne = new ArrayList<double[]>();
		double[] agePercent;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
			Statement stmt = con.createStatement(); 
		
			query = String.format("select age, count(age), (count(age)/(select count(a.age) from tupyo as a where kiho=%d))*100 "+
									"from tupyo where kiho=%d group by age order by age", kiho, kiho);
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				agePercent = new double[3];
				agePercent[0] = rs.getInt(1); //나이대
				agePercent[1] = rs.getInt(2); //득표수
				agePercent[2] = rs.getDouble(3); //퍼센트
				viewOne.add(agePercent);
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			String err = e.getMessage();
			System.out.println(err);
			e.printStackTrace();
		} finally {}
		
		return viewOne;
	}

	@Override
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
	public List<Tupyo> selectAll() {
		String query = "";
		List<Tupyo> tupyoArr = new ArrayList<Tupyo>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
			Statement stmt = con.createStatement(); 
		
			Tupyo tupyo;
			query = "select * from tupyo;";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				tupyo = new Tupyo();
				tupyo.setKiho(rs.getInt(1));
				tupyo.setAge(rs.getInt(2));
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

	



}
