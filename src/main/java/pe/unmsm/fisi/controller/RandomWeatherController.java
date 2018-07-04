package pe.unmsm.fisi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import pe.unmsm.fisi.service.StatService;

@Controller
@EnableScheduling
public class RandomWeatherController {

	@Autowired
	private StatService statService;

	@Scheduled(fixedRate=5000)
	@MessageMapping("/weather")
	@SendTo("/topic/weather")
	public Map<String, Object> index() {
		return statService.getRandomStat();
	}
}
