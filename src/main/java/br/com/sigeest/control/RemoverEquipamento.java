package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sigeest.model.Equipamento;
import br.com.sigeest.model.Estoque;
import br.com.sigeest.model.Estrutura;
import br.com.sigeest.service.EstoqueService;
import br.com.sigeest.service.EstruturaService;

@Controller
public class RemoverEquipamento {
	
	@Autowired
	private EstruturaService servico;
	
	@Autowired
	private EstoqueService servicoEstoque;
	
	@RequestMapping("/{codigoEstrutura}/equipamentos/remover/{codigoEquipamento}")
	public ModelAndView equipamento(@PathVariable ("codigoEstrutura") Estrutura estrutura,
									@PathVariable ("codigoEquipamento") Equipamento equipamento){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("RemoverEquipamento");
		mav.addObject(estrutura);
		mav.addObject(equipamento);
		mav.addObject("todosEstoques", servicoEstoque.retornarTodos());				
		return mav;		
	}
	
	@RequestMapping("/{codigoEstrutura}/equipamentos/{codigoEquipamento}/estocar/{codigoEstoque}")
	public String removerEquipamento(@PathVariable("codigoEstrutura") Estrutura estrutura,
			                         @PathVariable("codigoEquipamento") Equipamento equipamento,
			                         @PathVariable("codigoEstoque") Estoque estoque,
			                         RedirectAttributes attributes) {
		
		servico.removerEquipamento(estrutura, equipamento, estoque);
		attributes.addFlashAttribute("mensagem", "Equipamento removido!");
		return "redirect:/estrutura/{codigoEstrutura}/exibir";
	}

}
