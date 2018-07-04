package pe.unmsm.fisi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import pe.unmsm.fisi.service.StatService;

@Controller
public class RandomWeatherController {

	@Autowired
	private StatService statService;

	@MessageMapping("/weather")
	@SendTo("/topic/weather")
	public Map<String, Object> index() {
		return statService.getRandomStat();
	}
}
