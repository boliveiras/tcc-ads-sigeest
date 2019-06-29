package br.com.sigeest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.model.Bateria;

@Controller
public class ExibirBateria {
	
	@RequestMapping("/bateria/{codigo}/exibir")
	public ModelAndView exibir(@PathVariable("codigo") Bateria bateria) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ExibirBateria");
		mav.addObject(bateria);
		return mav;
	}

}
