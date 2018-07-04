package pe.unmsm.fisi.dao;

import pe.unmsm.fisi.dto.Stat;

public interface StatDao {

	public Stat getStatByTypeAndRandomId(int type, int randomId);
	
	public void insertStat(Stat stat);
}
