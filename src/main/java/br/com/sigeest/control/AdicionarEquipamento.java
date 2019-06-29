package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sigeest.enums.Status;
import br.com.sigeest.model.Equipamento;
import br.com.sigeest.model.Estoque;
import br.com.sigeest.model.Estrutura;
import br.com.sigeest.service.EquipamentoService;
import br.com.sigeest.service.EstruturaService;

@Controller
public class AdicionarEquipamento {
	
	@Autowired
	private EstruturaService servicoEstrutura;
	
	@Autowired
	private EquipamentoService servicoEquipamento;
	
	
	@RequestMapping("/{codigo}/equipamentos/adicionar")
	public ModelAndView selecionar(@PathVariable("codigo") Estrutura estrutura){
		ModelAndView mav = new ModelAndView();
		mav.addObject(estrutura);
		mav.addObject("equipamentos", servicoEquipamento.retornarEquipamentosDesalocados(Status.DESALOCADO));
		mav.setViewName("AdicionarEquipamento");		
		return mav;
	}
	
	@RequestMapping("/{codigoEstrutura}/equipamentos/adicionar/{codigoEquipamento}/{codigoEstoque}")
	public String adicionarEquipamento(@PathVariable("codigoEstrutura") Estrutura estrutura,
			                           @PathVariable("codigoEquipamento") Equipamento equipamento,
			                           @PathVariable("codigoEstoque") Estoque estoque,
			                           RedirectAttributes attributes) {
		servicoEstrutura.adicionarEquipamento(estrutura, equipamento, estoque);
		attributes.addFlashAttribute("mensagem", "Equipamento adicionado!");
		return "redirect:/estrutura/{codigoEstrutura}/exibir";
	}

}
