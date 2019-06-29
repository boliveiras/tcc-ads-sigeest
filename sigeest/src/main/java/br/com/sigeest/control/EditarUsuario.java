package br.com.sigeest.control;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sigeest.enums.Setor;
import br.com.sigeest.enums.TipoUsuario;
import br.com.sigeest.model.Grupo;
import br.com.sigeest.model.Usuario;
import br.com.sigeest.repository.Grupos;
import br.com.sigeest.service.UsuarioService;

@Controller
@RequestMapping("/editar/usuarios")
public class EditarUsuario {
	
	@Autowired
	private UsuarioService servico;
	
	@Autowired
	private Grupos grupos;
	
	@RequestMapping("/selecionar")
	public ModelAndView selecionar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuarios", servico.retornarTodos());
		mav.setViewName("EditarUsuario");
		return mav;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Usuario usuario) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("CadastrarUsuario");
		mav.addObject(usuario);
		return mav;
	}
	
	@ModelAttribute("todosGrupos")
	public List<Grupo> grupos() {
		return grupos.findAll();

	}
	
	@ModelAttribute("todosSetores")
	public List<Setor> setores() {
		return Arrays.asList(Setor.values());

	}
	
	@ModelAttribute("todosTiposUsuarios")
	public List<TipoUsuario> tiposUsuario() {
		return Arrays.asList(TipoUsuario.values());

	}
	
}
