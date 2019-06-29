package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.model.Fabricante;
import br.com.sigeest.service.FabricanteService;

@Controller
@RequestMapping("/editar/fabricantes")
public class EditarFabricante {
	
	@Autowired
	private FabricanteService servico;
	
	@RequestMapping("/selecionar")
	public ModelAndView selecionar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("fabricantes", servico.retornarTodos());
		mav.setViewName("EditarFabricante");
		return mav;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Fabricante fabricante) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("CadastrarFabricante");
		mav.addObject(fabricante);
		return mav;
	}
	

}
