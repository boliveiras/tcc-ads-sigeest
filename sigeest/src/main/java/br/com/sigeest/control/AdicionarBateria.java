package br.com.sigeest.control;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sigeest.enums.Status;
import br.com.sigeest.model.Bateria;
import br.com.sigeest.model.Estoque;
import br.com.sigeest.model.Estrutura;
import br.com.sigeest.service.BateriaService;
import br.com.sigeest.service.EstruturaService;

@Controller
public class AdicionarBateria {
	
	@Autowired
	private EstruturaService servicoEstrutura;
	
	@Autowired
	private BateriaService servicoBateria;
	
	@RequestMapping("/{codigo}/baterias/adicionar")
	public ModelAndView baterias(@PathVariable("codigo") Estrutura estrutura){
		ModelAndView mav = new ModelAndView();
		mav.addObject(estrutura);
		mav.addObject("baterias", servicoBateria.retornarBateriasDesalocadas(Status.DESALOCADO));
		mav.setViewName("AdicionarBateria");		
		return mav;
	}
	
	@RequestMapping("/{codigoEstrutura}/baterias/adicionar/{codigoBateria}/{codigoEstoque}")
	public String adicionarBateria(@PathVariable("codigoEstrutura") Estrutura estrutura,
			                           @PathVariable("codigoBateria") Bateria bateria,
			                           @PathVariable("codigoEstoque") Estoque estoque,
			                           RedirectAttributes attributes) {
		servicoEstrutura.adicionarBateria(estrutura, bateria, estoque);
		attributes.addFlashAttribute("mensagem", "Bateria adicionada!");
		return "redirect:/estrutura/{codigoEstrutura}/exibir";
	}

}
