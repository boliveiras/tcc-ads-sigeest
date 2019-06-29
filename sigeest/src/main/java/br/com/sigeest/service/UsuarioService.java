package br.com.sigeest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigeest.model.Usuario;
import br.com.sigeest.repository.Usuarios;

@Service
public class UsuarioService {

	@Autowired
	private Usuarios usuarios;

	public void cadastrar(Usuario usuario) {
		usuarios.save(usuario);
	}

	public void excluir(Long codigo) {
		usuarios.delete(codigo);
	}

	public List<Usuario> retornarTodos() {
		return usuarios.findAll();
	}

}
