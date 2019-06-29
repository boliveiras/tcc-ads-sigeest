package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sigeest.model.Bateria;
import br.com.sigeest.service.EstoqueService;

@Controller
public class EnviarBateriaManutencao {
	
	@Autowired
	private EstoqueService servicoEstoque;
	
	@RequestMapping("/{codigoEstoque}/baterias/{codigoBateria}/enviar")
	public String colocarBateriaManutencao(@PathVariable("codigoBateria") Bateria bateria, RedirectAttributes attributes) {		
		servicoEstoque.enviarBateriaManutencao(bateria);
		attributes.addFlashAttribute("mensagem", "Bateria enviada para manutenção!");
		return "redirect:/estoque/{codigoEstoque}/exibir";
	}
	
	

}
