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

import br.com.sigeest.enums.TipoEquipamento;
import br.com.sigeest.model.Equipamento;
import br.com.sigeest.model.Estoque;
import br.com.sigeest.model.Fabricante;
import br.com.sigeest.service.EquipamentoService;
import br.com.sigeest.service.EstoqueService;
import br.com.sigeest.service.FabricanteService;

@Controller
@RequestMapping("/equipamento")
public class CadastrarEquipamento {
	
	@Autowired
	private EquipamentoService servicoEquipamento;
	
	@Autowired
	private FabricanteService servicoFabricante;
	
	@Autowired
	private EstoqueService servicoEstoque;
	
	@RequestMapping("/novo")
	public ModelAndView cadastrar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("CadastrarEquipamento");
		mav.addObject(new Equipamento());
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Equipamento equipamento, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return "CadastrarEquipamento";
		}

		try {
			servicoEquipamento.cadastrar(equipamento);
		} catch (IllegalArgumentException e) {
			errors.rejectValue("erro", e.getMessage());
			return "CadastrarEquipamento";
		}

		attributes.addFlashAttribute("mensagem", "Equipamento salvo com sucesso!");
		return "redirect:/equipamentos";
	}
	
	@ModelAttribute("todosTiposEquipamentos")
	public List<TipoEquipamento> tiposBateria() {
		return Arrays.asList(TipoEquipamento.values());

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
