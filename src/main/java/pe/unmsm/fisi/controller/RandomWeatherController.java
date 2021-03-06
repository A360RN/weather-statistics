package pe.unmsm.fisi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import pe.unmsm.fisi.service.StatService;

@Controller
public class RandomWeatherController {

	@Autowired
	private StatService statService;

	@Autowired
	private SimpMessagingTemplate template;

	@Scheduled(initialDelay = 0, fixedRate = 60*1000)
	public void index() {
		template.convertAndSend("/topic/weather", statService.getRandomStat());
	}
	
	@MessageMapping("/weather")
	@SendTo("/topic/weather")
	public Map<String, Object> initialData() {
		return statService.getRandomStat();
	}
}
