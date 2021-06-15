package kr.ac.kopo.kopo08.dao;

import java.util.List;

import kr.ac.kopo.kopo08.domain.Tupyo;

public interface TupyoDao {
	void create(Tupyo tupyo);
	void delete(int kiho);
	List<double[]> selectOneGroupbyAge(int kiho);
	List<Tupyo> selectAll();
}
