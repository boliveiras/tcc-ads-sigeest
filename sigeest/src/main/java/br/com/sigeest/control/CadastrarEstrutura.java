package br.com.sigeest.control;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sigeest.enums.TipoEstrutura;
import br.com.sigeest.model.Estrutura;
import br.com.sigeest.service.EstruturaService;

@Controller
@RequestMapping("/estrutura")
public class CadastrarEstrutura {
	
	@Autowired
	private EstruturaService servicoEstrutura;
	
	@RequestMapping("/novo")
	public ModelAndView cadastrar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("CadastrarEstrutura");
		mav.addObject(new Estrutura());
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Estrutura estrutura, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return "CadastrarEstrutura";
		}

		try {
			servicoEstrutura.cadastrar(estrutura);
		} catch (IllegalArgumentException e) {
			errors.rejectValue("erro", e.getMessage());
			return "CadastrarEstrutura";
		}

		attributes.addFlashAttribute("mensagem", "Estrutura salva com sucesso!");
		return "redirect:/estruturas";
	}
	
	@ModelAttribute("todosTiposEstruturas")
	public List<TipoEstrutura> tiposEstruturas() {
		return Arrays.asList(TipoEstrutura.values());

	}
	
}
