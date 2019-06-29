package br.com.sigeest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/login")
	public String login() {
		return "Login";
	}

	@RequestMapping(method = RequestMethod.GET, value = {"/", "/index", "inicio"})
	public String index() {
		return "Inicio";
	}

}
