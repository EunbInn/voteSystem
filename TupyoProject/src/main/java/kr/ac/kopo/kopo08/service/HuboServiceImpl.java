package kr.ac.kopo.kopo08.service;

import java.sql.SQLException;
import java.util.List;

import kr.ac.kopo.kopo08.dao.HuboDao;
import kr.ac.kopo.kopo08.dao.HuboDaoImpl;
import kr.ac.kopo.kopo08.domain.Hubo;

public class HuboServiceImpl implements HuboService {
	HuboDao huboDao = new HuboDaoImpl();
	
	@Override
	public void create(Hubo hubo) throws SQLException {
		huboDao.create(hubo);
		
	}

	@Override
	public void selectHubo(int kiho) {
	
	}

	@Override
	public List<Hubo> selectAll() throws SQLException {
		List<Hubo> retAll = huboDao.selectAll();
		if (retAll == null) {
			return null;
		} else {
			return retAll;
		}
	}

	@Override
	public void delete(int kiho) throws SQLException {
		huboDao.delete(kiho);
		
	}
	
}
