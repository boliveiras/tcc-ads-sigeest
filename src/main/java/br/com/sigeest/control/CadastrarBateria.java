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

import br.com.sigeest.enums.TipoBateria;
import br.com.sigeest.model.Bateria;
import br.com.sigeest.model.Estoque;
import br.com.sigeest.model.Fabricante;
import br.com.sigeest.service.BateriaService;
import br.com.sigeest.service.EstoqueService;
import br.com.sigeest.service.FabricanteService;

@Controller
@RequestMapping("/bateria")
public class CadastrarBateria {
	
	@Autowired
	private BateriaService servicoBateria;
	
	@Autowired
	private FabricanteService servicoFabricante;
	
	@Autowired
	private EstoqueService servicoEstoque;
	
	@RequestMapping("/novo")
	public ModelAndView cadastrar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("CadastrarBateria");
		mav.addObject(new Bateria());
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Bateria bateria, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return "CadastrarBateria";
		}

		try {
			servicoBateria.cadastrar(bateria);
		} catch (IllegalArgumentException e) {
			errors.rejectValue("erro", e.getMessage());
			return "CadastrarBateria";
		}

		attributes.addFlashAttribute("mensagem", "Bateria salva com sucesso!");
		return "redirect:/baterias";
	}
	
	@ModelAttribute("todosTiposBaterias")
	public List<TipoBateria> tiposBateria() {
		return Arrays.asList(TipoBateria.values());

	}
	
	@ModelAttribute("todosFabricantes")
	public List<Fabricante> todosFabricantes() {
		return servicoFabricante.retornarTodos();

	}
	
	@ModelAttribute("todosEstoques")
	public List<Estoque> todosEstoques() {
		return servicoEstoque.retornarTodos();
	}

}
