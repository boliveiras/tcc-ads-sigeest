package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sigeest.service.FabricanteService;

@Controller
@RequestMapping("/excluir/fabricantes")
public class ExcluirFabricante {
	
	@Autowired
	private FabricanteService servico;
	
	@RequestMapping("/selecionar")
	public ModelAndView selecionar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ExcluirFabricante");
		mav.addObject("fabricantes", servico.retornarTodos());
		return mav;	
	}
	
	
	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		servico.excluir(codigo);
		attributes.addFlashAttribute("mensagem", "Fabricante excluído com sucesso!");
		return "redirect:/excluir/fabricantes/selecionar";
	}

}
