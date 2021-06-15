package kr.ac.kopo.kopo08.dao;

import java.sql.SQLException;
import java.util.List;

import kr.ac.kopo.kopo08.domain.Hubo;

public interface HuboDao {
	void create(Hubo hubo) throws SQLException;
	void delete(int kiho)throws SQLException;
	List<Hubo> selectAll() throws SQLException;
	List<Hubo> selectOne(int kiho) throws SQLException;
}
