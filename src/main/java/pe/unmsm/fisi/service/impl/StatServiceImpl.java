package pe.unmsm.fisi.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unmsm.fisi.dao.StatDao;
import pe.unmsm.fisi.dto.Stat;
import pe.unmsm.fisi.service.StatService;

@Service
public class StatServiceImpl implements StatService {
	
	@Autowired
	private StatDao statDao;

	@Override
	public Stat getRandomPrecipitationStat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stat getRandomTemperatureStat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getRandomStat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertStat(Stat stat) {
		statDao.insertStat(stat);
	}

}
