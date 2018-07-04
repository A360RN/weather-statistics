package pe.unmsm.fisi.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unmsm.fisi.dao.StatDao;
import pe.unmsm.fisi.dto.Stat;
import pe.unmsm.fisi.service.StatService;

@Service
public class StatServiceImpl implements StatService {
	
	@Autowired
	private StatDao statDao;
	private final Integer TEMPERATURE_TYPE = 1;
	private final Integer PRECIPITATION_TYPE = 2;

	@Override
	public Stat getRandomPrecipitationStat() {
		return statDao.getStatByTypeAndRandomId(PRECIPITATION_TYPE, getRandomNumber());
	}

	@Override
	public Stat getRandomTemperatureStat() {
		return statDao.getStatByTypeAndRandomId(TEMPERATURE_TYPE, getRandomNumber());
	}

	@Override
	public Map<String, Object> getRandomStat() {
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> data = new HashMap<>();
		data.put("precipitation", getRandomPrecipitationStat());
		data.put("temperature", getRandomTemperatureStat());
		response.put("data", data);
		return response;
	}

	@Override
	public void insertStat(Stat stat) {
		statDao.insertStat(stat);
	}

	private int getRandomNumber() {
		Random random = new Random();
		
		Long maxRandom = statDao.getStatCount() / 2;
		int minRandom = 0;
		
		return random.nextInt(maxRandom.intValue() + minRandom) + minRandom;
	}
}
