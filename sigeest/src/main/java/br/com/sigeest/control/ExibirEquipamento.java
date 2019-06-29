package br.com.sigeest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.model.Equipamento;

@Controller
public class ExibirEquipamento {
	
	@RequestMapping("/equipamento/{codigo}/exibir")
	public ModelAndView exibir(@PathVariable("codigo") Equipamento equipamento) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ExibirEquipamento");
		mav.addObject(equipamento);
		return mav;
	}

}
