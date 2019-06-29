package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sigeest.model.Bateria;
import br.com.sigeest.model.Estoque;
import br.com.sigeest.model.Estrutura;
import br.com.sigeest.service.EstoqueService;
import br.com.sigeest.service.EstruturaService;

@Controller
public class RemoverBateria {
	
	@Autowired
	private EstruturaService servico;
	
	@Autowired
	private EstoqueService servicoEstoque;

	@RequestMapping("/{codigoEstrutura}/baterias/remover/{codigoBateria}")
	public ModelAndView bateria(@PathVariable ("codigoEstrutura") Estrutura estrutura,
									@PathVariable ("codigoBateria") Bateria bateria){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("RemoverBateria");
		mav.addObject(estrutura);
		mav.addObject(bateria);
		mav.addObject("todosEstoques", servicoEstoque.retornarTodos());				
		return mav;		
	}
	
	@RequestMapping("/{codigoEstrutura}/baterias/{codigoBateria}/estocar/{codigoEstoque}")
	public String removerBateria(@PathVariable("codigoEstrutura") Estrutura estrutura,
			                         @PathVariable("codigoBateria") Bateria bateria,
			                         @PathVariable("codigoEstoque") Estoque estoque,
			                         RedirectAttributes attributes){
		
		servico.removerBateria(estrutura, bateria, estoque);
		attributes.addFlashAttribute("mensagem", "Bateria removida!");
		return "redirect:/estrutura/{codigoEstrutura}/exibir";
	}

}
