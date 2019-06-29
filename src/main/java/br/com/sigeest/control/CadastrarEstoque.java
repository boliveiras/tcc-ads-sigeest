package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sigeest.model.Estoque;
import br.com.sigeest.service.EstoqueService;

@Controller
@RequestMapping("/estoque")
public class CadastrarEstoque {
	
	@Autowired
	private EstoqueService servicoEstoque;
	
	@RequestMapping("/novo")
	public ModelAndView cadastrar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("CadastrarEstoque");
		mav.addObject(new Estoque());
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Estoque estoque, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return "CadastrarEstoque";
		}

		try {
			servicoEstoque.cadastrar(estoque);
		} catch (IllegalArgumentException e) {
			errors.rejectValue("erro", e.getMessage());
			return "CadastrarEstoque";
		}

		attributes.addFlashAttribute("mensagem", "Estoque salvo com sucesso!");
		return "redirect:/estoques";
	}
	
}
