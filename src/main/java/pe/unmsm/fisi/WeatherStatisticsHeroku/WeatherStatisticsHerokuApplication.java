package pe.unmsm.fisi.WeatherStatisticsHeroku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"pe.unmsm.fisi"})
public class WeatherStatisticsHerokuApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherStatisticsHerokuApplication.class, args);
	}
}
