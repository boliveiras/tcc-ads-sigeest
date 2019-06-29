package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sigeest.model.Equipamento;
import br.com.sigeest.service.EstoqueService;

@Controller
public class EnviarEquipamentoManutencao {
	
	@Autowired
	private EstoqueService servicoEstoque;
	
	@RequestMapping("/{codigoEstoque}/equipamentos/{codigoEquipamento}/enviar")
	public String colocarEquipamentoManutencao(@PathVariable("codigoEquipamento") Equipamento equipamento, RedirectAttributes attributes) {		
		servicoEstoque.enviarEquipamentoManutencao(equipamento);	
		attributes.addFlashAttribute("mensagem", "Equipamento enviado para manutenção!");
		return "redirect:/estoque/{codigoEstoque}/exibir";
	}
	
	

}
