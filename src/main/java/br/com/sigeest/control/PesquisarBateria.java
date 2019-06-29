package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.service.BateriaService;

@Controller
public class PesquisarBateria {
	
	@Autowired
	private BateriaService servico;
	
	@RequestMapping("/baterias")
	public ModelAndView pesquisar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("PesquisarBateria");
		mav.addObject("baterias", servico.retornarTodas());
		return mav;
	}

}
