package br.com.sigeest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.model.Fabricante;

@Controller
public class ExibirFabricante {

	@RequestMapping("/fabricante/{codigo}/exibir")
	public ModelAndView exibir(@PathVariable("codigo") Fabricante fabricante) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ExibirFabricante");
		mav.addObject("equipamentos", fabricante.getEquipamentos());
		mav.addObject("baterias", fabricante.getBaterias());
		mav.addObject(fabricante);		
		return mav;
	}

}
