package kr.ac.kopo.kopo08.service;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.kopo08.dao.TupyoDao;
import kr.ac.kopo.kopo08.dao.TupyoDaoImpl;
import kr.ac.kopo.kopo08.domain.Tupyo;

public class TupyoServiceImpl implements TupyoService{
	private static TupyoServiceImpl instance = new TupyoServiceImpl();
	TupyoDao tupyoDao = TupyoDaoImpl.getInstance();
	
	private TupyoServiceImpl() {
		
	}
	
	public static TupyoServiceImpl getInstance() {
		return instance;
	}
	
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
		return retAll;
	}

	@Override
	public void showOne(int kiho) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	//select one candidate's count and percentage group by age
	//return List<double[]> double[] - 0: age, 1: count, 2: percent
	public List<double[]> selectOneGroupbyAge(int kiho) {
		int[] age = {10, 20, 30, 40, 50, 60, 70, 80, 90};
		List<double[]> viewOne = new ArrayList<double[]>();
		
		List<Tupyo> tupyoList = tupyoDao.selectOne(kiho);
		
		double oneKihoCnt = 0;
		if (tupyoList == null) {
			oneKihoCnt = 0;
		} else {
			oneKihoCnt = tupyoList.size();
		}
		
		for (int i = 0; i < age.length; i++) {
			double cnt = 0.0;
			double percent = 0.0;
			if (oneKihoCnt != 0) {
				for (int j = 0; j < tupyoList.size(); j++) {
					Tupyo tupyo = tupyoList.get(j);
					if (tupyo.getAge() == age[i]) {
						cnt++;
					}
				}
				percent = (cnt / oneKihoCnt) * 100;
			}
			double[] agePercent = {age[i], cnt, percent};
			viewOne.add(agePercent);
		}
		return viewOne;
	}

	@Override
	//return double[] 0: count, 1: percent;
	public double[] selectCountGroupbyKiho(int kiho) {
		double kihoCnt = 0.0;
		double kihoPer = 0.0;
		
		List<Tupyo> tupyoList = tupyoDao.selectOne(kiho);
		List<Tupyo> allList = tupyoDao.selectAll();
		if (tupyoList == null) {
			kihoCnt = 0;
		} else {
			kihoCnt = tupyoList.size();
			kihoPer = (kihoCnt / allList.size()) * 100;
		}
		
		double[] cntPer = {kihoCnt, kihoPer};
		return cntPer;
		
	}

	@Override
	public List<Tupyo> selectOne(int kiho) {
		List<Tupyo> tupyo = tupyoDao.selectOne(kiho);
		return tupyo;
	}
}
