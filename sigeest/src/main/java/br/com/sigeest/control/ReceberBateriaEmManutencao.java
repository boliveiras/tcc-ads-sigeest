package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sigeest.model.Bateria;
import br.com.sigeest.service.EstoqueService;

@Controller
public class ReceberBateriaEmManutencao {
	
	@Autowired
	private EstoqueService servicoEstoque;
	
	@RequestMapping("/{codigoEstoque}/baterias/{codigoBateria}/receber")
	public String colocarEquipamentoManutencao(@PathVariable("codigoBateria") Bateria bateria, RedirectAttributes attributes) {		
		servicoEstoque.receberBateriaManutencao(bateria);
		attributes.addFlashAttribute("mensagem", "Bateria recebida da manutenção!");
		return "redirect:/estoque/{codigoEstoque}/exibir";
	}

}
