package br.com.sigeest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.model.Estrutura;

@Controller
public class ExibirEstrutura {
	
	@RequestMapping("/estrutura/{codigo}/exibir")
	public ModelAndView exibir(@PathVariable("codigo") Estrutura estrutura) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ExibirEstrutura");
		mav.addObject("equipamentos", estrutura.getEquipamentos());
		mav.addObject("baterias", estrutura.getBaterias());
		mav.addObject(estrutura);
		return mav;
	}

}
