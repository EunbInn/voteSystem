package kr.ac.kopo.kopo08.service;

import java.sql.SQLException;
import java.util.List;
import kr.ac.kopo.kopo08.domain.Hubo;

public interface HuboService {
	void create(Hubo hubo);
	List<Hubo> selectAll();
	void update(Hubo hubo);
	void delete(int kiho);
	Hubo selectOne(int kiho);
}
