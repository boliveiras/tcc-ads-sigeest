package br.com.sigeest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.model.Usuario;

@Controller
public class ExibirUsuario {

	@RequestMapping("/usuario/{codigo}/exibir")
	public ModelAndView exibir(@PathVariable("codigo") Usuario usuario) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ExibirUsuario");
		mav.addObject(usuario);		
		return mav;
	}

}
