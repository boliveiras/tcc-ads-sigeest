package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.service.EquipamentoService;

@Controller
public class PesquisarEquipamento {
	
	@Autowired
	private EquipamentoService servico;
	
	@RequestMapping("/equipamentos")
	public ModelAndView pesquisar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("PesquisarEquipamento");
		mav.addObject("equipamentos", servico.retornarTodos());
		return mav;
	}

}
