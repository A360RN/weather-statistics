package pe.unmsm.fisi.WeatherStatisticsHeroku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@SpringBootApplication(scanBasePackages= {"pe.unmsm.fisi"})
public class WeatherStatisticsHerokuApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherStatisticsHerokuApplication.class, args);
	}
	
	@Bean
	public MongoClient mongoClient() {
		return new MongoClient(new MongoClientURI("mongodb://alonso9715:los800815@ds127811.mlab.com:27811/heroku_7lpvwtth"));
	}
}
