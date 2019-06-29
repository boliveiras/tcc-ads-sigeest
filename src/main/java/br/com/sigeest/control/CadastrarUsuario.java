package br.com.sigeest.control;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sigeest.enums.Setor;
import br.com.sigeest.enums.TipoUsuario;
import br.com.sigeest.model.Grupo;
import br.com.sigeest.model.Usuario;
import br.com.sigeest.service.GrupoService;
import br.com.sigeest.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class CadastrarUsuario {
	
	@Autowired
	private UsuarioService servicoUsuario;
	
	@Autowired
	private GrupoService servicoGrupo;
	
	@RequestMapping("/novo")
	public ModelAndView cadastrar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("CadastrarUsuario");
		mav.addObject(new Usuario());
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Usuario usuario, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return "CadastrarUsuario";
		}

		try {
			servicoUsuario.cadastrar(usuario);
		} catch (IllegalArgumentException e) {
			errors.rejectValue("erro", e.getMessage());
			return "CadastrarUsuario";
		}

		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");
		return "redirect:/usuarios";
	}
	
	@ModelAttribute("todosGrupos")
	public List<Grupo> grupos() {
		return servicoGrupo.retornarTodos();

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
