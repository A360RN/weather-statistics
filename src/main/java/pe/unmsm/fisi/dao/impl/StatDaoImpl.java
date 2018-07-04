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
		MongoDatabase weatherStatsDb = mongoClient.getDatabase("heroku_7lpvwtth");
		MongoCollection<Document> weatherCollection = weatherStatsDb.getCollection("WEATHER_STATS");
		Document statDocument = weatherCollection.find(new Document("randomId", randomId).append("type", type)).first();
		Stat stat = new Stat();
		stat.setCountryCode(statDocument.getString("countryCode"));
		stat.setId(statDocument.getInteger("randomId"));
		stat.setMonth(statDocument.getInteger("month"));
		stat.setType(statDocument.getInteger("type"));
		stat.setStat(statDocument.getDouble("value"));
		
		return stat;
	}

	@Override
	public void insertStat(Stat stat) {
		MongoDatabase weatherStatsDb = mongoClient.getDatabase("heroku_7lpvwtth");
		MongoCollection<Document> weatherCollection = weatherStatsDb.getCollection("WEATHER_STATS");

		Document document = new Document("countryCode", stat.getCountryCode()).append("type", stat.getType())
				.append("month", stat.getMonth()).append("randomId", stat.getId()).append("value", stat.getStat());

		weatherCollection.insertOne(document);
	}

	@Override
	public Long getStatCount() {
		MongoDatabase weatherStatsDb = mongoClient.getDatabase("heroku_7lpvwtth");
		MongoCollection<Document> weatherCollection = weatherStatsDb.getCollection("WEATHER_STATS");
		
		Long count = weatherCollection.countDocuments();
		
		return count;
	}

}
