package br.com.sigeest.control;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.enums.TipoEquipamento;
import br.com.sigeest.model.Equipamento;
import br.com.sigeest.model.Estoque;
import br.com.sigeest.model.Fabricante;
import br.com.sigeest.repository.Estoques;
import br.com.sigeest.repository.Fabricantes;
import br.com.sigeest.service.EquipamentoService;

@Controller
@RequestMapping("/editar/equipamentos")
public class EditarEquipamento {
	
	@Autowired
	private EquipamentoService servico;
	
	@Autowired
	private Fabricantes fabricantes;
	
	@Autowired
	private Estoques estoques;
	
	@RequestMapping("/selecionar")
	public ModelAndView selecionar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("equipamentos", servico.retornarTodos());
		mav.setViewName("EditarEquipamento");
		return mav;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Equipamento equipamento) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("CadastrarEquipamento");
		mav.addObject(equipamento);
		return mav;
	}
	
	@ModelAttribute("todosTiposEquipamentos")
	public List<TipoEquipamento> tiposBateria() {
		return Arrays.asList(TipoEquipamento.values());

	}
	
	@ModelAttribute("todosFabricantes")
	public List<Fabricante> todosFabricantes() {
		return fabricantes.findAll();

	}
	
	@ModelAttribute("todosEstoques")
	public List<Estoque> todosEstoques() {
		return estoques.findAll();

	}

}
