package br.com.sigeest.control;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.enums.TipoEstrutura;
import br.com.sigeest.model.Estrutura;
import br.com.sigeest.service.EstruturaService;

@Controller
@RequestMapping("/editar/estruturas")
public class EditarEstrutura {
		
	@Autowired
	private EstruturaService servico;
	
	@RequestMapping("/selecionar")
	public ModelAndView selecionar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("estruturas", servico.retornarTodas());
		mav.setViewName("EditarEstrutura");
		return mav;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Estrutura estrutura) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("CadastrarEstrutura");
		mav.addObject(estrutura);
		return mav;
	}
	
	@ModelAttribute("todosTiposEstruturas")
	public List<TipoEstrutura> tiposEstruturas() {
		return Arrays.asList(TipoEstrutura.values());

	}

}
