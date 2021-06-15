package kr.ac.kopo.kopo08.service;

import java.sql.SQLException;
import java.util.List;
import kr.ac.kopo.kopo08.domain.Hubo;

public interface HuboService {
	void create(Hubo hubo) throws SQLException;
	void selectHubo(int kiho) throws SQLException;
	List<Hubo> selectAll() throws SQLException;
	void delete(int kiho) throws SQLException;
}
