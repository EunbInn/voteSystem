package kr.ac.kopo.kopo08.service;

import java.util.List;

import kr.ac.kopo.kopo08.domain.Hubo;
import kr.ac.kopo.kopo08.domain.Tupyo;

public interface TupyoService {
	void create(Tupyo tupyo);
	void delete(int kiho);
	List<Tupyo> selectAll();
	void showOne(int kiho);
	List<Tupyo> selectOne(int kiho);
	List<double[]> selectOneGroupbyAge(int kiho);
	double[] selectCountGroupbyKiho(int kiho);
}
