package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.service.EstruturaService;

@Controller
public class PesquisarEstrutura {
	
	@Autowired
	private EstruturaService servico;
	
	@RequestMapping("/estruturas")
	public ModelAndView pesquisar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("PesquisarEstrutura");
		mav.addObject("estruturas", servico.retornarTodas());
		return mav;
	}

}
