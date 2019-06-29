package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sigeest.model.Fabricante;
import br.com.sigeest.service.FabricanteService;

@Controller
@RequestMapping("/fabricante")
public class CadastrarFabricante {
	
	@Autowired
	private FabricanteService servicoFabricante;
	
	@RequestMapping("/novo")
	public ModelAndView cadastrar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("CadastrarFabricante");
		mav.addObject(new Fabricante());
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Fabricante fabricante, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return "CadastrarFabricante";
		}

		try {
			servicoFabricante.cadastrar(fabricante);
		} catch (IllegalArgumentException e) {
			errors.rejectValue("erro", e.getMessage());
			return "CadastrarFabricante";
		}

		attributes.addFlashAttribute("mensagem", "Fabricante salvo com sucesso!");
		return "redirect:/fabricantes";
	}
	
}
