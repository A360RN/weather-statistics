package pe.unmsm.fisi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.unmsm.fisi.service.StatService;

@Controller
public class RandomWeatherController {

	@Autowired
	private StatService statService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> index() {
		return statService.getRandomStat();
	}
}
