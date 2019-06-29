package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.service.EstoqueService;

@Controller
public class PesquisarEstoque {
	
	@Autowired
	private EstoqueService servico;
	
	@RequestMapping("/estoques")
	public ModelAndView pesquisar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("PesquisarEstoque");
		mav.addObject("estoques", servico.retornarTodos());
		return mav;
	}

}
