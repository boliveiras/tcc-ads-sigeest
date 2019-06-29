package br.com.sigeest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.model.Estoque;

@Controller
public class ExibirEstoque {
	
	@RequestMapping("/estoque/{codigo}/exibir")
	public ModelAndView exibir(@PathVariable("codigo") Estoque estoque) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ExibirEstoque");
		mav.addObject(estoque);
		mav.addObject("listaEquipamentos", estoque.getEquipamentos());
		mav.addObject("listaBaterias", estoque.getBaterias());		
		return mav;
	}

}
