package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.service.FabricanteService;

@Controller
public class PesquisarFabricante {
	
	@Autowired
	private FabricanteService servico;
	
	@RequestMapping("/fabricantes")
	public ModelAndView pesquisar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("PesquisarFabricante");
		mav.addObject("fabricantes", servico.retornarTodos());
		return mav;
	}

}
