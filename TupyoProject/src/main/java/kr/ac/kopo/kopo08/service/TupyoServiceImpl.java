package kr.ac.kopo.kopo08.service;

import java.util.List;

import kr.ac.kopo.kopo08.dao.TupyoDaoImpl;
import kr.ac.kopo.kopo08.domain.Tupyo;

public class TupyoServiceImpl implements TupyoService{
	TupyoDaoImpl tupyoDao = new TupyoDaoImpl();
	@Override
	public void create(Tupyo tupyo) {
		tupyoDao.create(tupyo);
		
	}

	@Override
	public void delete(int kiho) {
		tupyoDao.delete(kiho);
	}

	@Override
	public List<Tupyo> selectAll() {
		List<Tupyo> retAll = tupyoDao.selectAll();
		return null;
	}

	@Override
	public void showOne(int kiho) {
		// TODO Auto-generated method stub
		
	}

}
