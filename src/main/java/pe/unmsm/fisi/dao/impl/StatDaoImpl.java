package pe.unmsm.fisi.dao.impl;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import pe.unmsm.fisi.dao.StatDao;
import pe.unmsm.fisi.dto.Stat;

@Repository
public class StatDaoImpl implements StatDao {

	@Autowired
	private MongoClient mongoClient;

	@Override
	public Stat getStatByTypeAndRandomId(int type, int randomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertStat(Stat stat) {
		MongoDatabase weatherStatsDb = mongoClient.getDatabase("heroku_7lpvwtth");
		MongoCollection<Document> weatherCollection = weatherStatsDb.getCollection("WEATHER_STATS");
		
		Document document = new Document("countryCode", stat.getCountryCode())
				.append("type", stat.getType())
				.append("month", stat.getMonth())
				.append("randomId", stat.getId())
				.append("value", stat.getStat());
		
		weatherCollection.insertOne(document);
	}

}
