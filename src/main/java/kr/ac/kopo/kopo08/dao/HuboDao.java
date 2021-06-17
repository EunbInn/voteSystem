package kr.ac.kopo.kopo08.dao;

import java.util.List;

import kr.ac.kopo.kopo08.domain.Hubo;

public interface HuboDao {
	void create(Hubo hubo);
	void delete(int kiho);
	Hubo selectOne(int kiho);
	List<Hubo> selectAll();
	void update(Hubo hubo);
}
