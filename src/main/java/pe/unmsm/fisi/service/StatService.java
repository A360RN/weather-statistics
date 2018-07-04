package pe.unmsm.fisi.service;

import java.util.Map;

import pe.unmsm.fisi.dto.Stat;

public interface StatService {

	public Stat getRandomPrecipitationStat();
	
	public Stat getRandomTemperatureStat();
	
	public Map<String, Object> getRandomStat();
	
	public void insertStat(Stat stat);
}
