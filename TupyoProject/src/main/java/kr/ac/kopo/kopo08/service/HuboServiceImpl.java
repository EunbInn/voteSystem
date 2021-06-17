package kr.ac.kopo.kopo08.service;

import java.util.List;

import kr.ac.kopo.kopo08.dao.HuboDao;
import kr.ac.kopo.kopo08.dao.HuboDaoImpl;
import kr.ac.kopo.kopo08.domain.Hubo;

public class HuboServiceImpl implements HuboService {
	private static HuboServiceImpl instance = new HuboServiceImpl();
	HuboDao huboDao = HuboDaoImpl.getInstance();
	
	private HuboServiceImpl() {
		
	}
	
	public static HuboServiceImpl getInstance() {
		return instance;
	}
	
	
	@Override
	public void create(Hubo hubo) {
		huboDao.create(hubo);
	}

	@Override
	public void update(Hubo hubo) {
	
	}

	@Override
	public List<Hubo> selectAll() {
		List<Hubo> retAll = huboDao.selectAll();
		if (retAll == null) {
			return null;
		} else {
			return retAll;
		}
	}

	@Override
	public void delete(int kiho) {
		huboDao.delete(kiho);
	}

	@Override
	public Hubo selectOne(int kiho) {
		Hubo hubo = huboDao.selectOne(kiho);
		return hubo;
		
	}
	
}
