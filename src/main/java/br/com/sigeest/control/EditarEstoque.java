package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.model.Estoque;
import br.com.sigeest.service.EstoqueService;

@Controller
@RequestMapping("/editar/estoques")
public class EditarEstoque {
	
	@Autowired
	private EstoqueService servico;
	
	@RequestMapping("/selecionar")
	public ModelAndView selecionar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("estoques", servico.retornarTodos());
		mav.setViewName("EditarEstoque");
		return mav;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Estoque estoque) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("CadastrarEstoque");
		mav.addObject(estoque);
		return mav;
	}
	
}
