package br.com.sigeest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.service.UsuarioService;

@Controller
public class PesquisarUsuario {
	
	@Autowired
	private UsuarioService servico;
	
	@RequestMapping("/usuarios")
	public ModelAndView pesquisar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("PesquisarUsuario");
		mav.addObject("usuarios", servico.retornarTodos());
		return mav;
	}

}
