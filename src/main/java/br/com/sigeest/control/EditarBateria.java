package br.com.sigeest.control;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.enums.TipoBateria;
import br.com.sigeest.model.Bateria;
import br.com.sigeest.model.Estoque;
import br.com.sigeest.model.Fabricante;
import br.com.sigeest.repository.Estoques;
import br.com.sigeest.repository.Fabricantes;
import br.com.sigeest.service.BateriaService;

@Controller
@RequestMapping("/editar/baterias")
public class EditarBateria {
	
	@Autowired
	private BateriaService servicoBateria;
	
	@Autowired
	private Fabricantes fabricantes;
	
	@Autowired
	private Estoques estoques;
	
	@RequestMapping("/selecionar")
	public ModelAndView selecionar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("baterias", servicoBateria.retornarTodas());
		mav.setViewName("EditarBateria");
		return mav;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Bateria bateria) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("CadastrarBateria");
		mav.addObject(bateria);
		return mav;
	}
	
	@ModelAttribute("todosTiposBaterias")
	public List<TipoBateria> tiposBateria() {
		return Arrays.asList(TipoBateria.values());

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
