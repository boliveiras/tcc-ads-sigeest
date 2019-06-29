package br.com.sigeest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sigeest.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>{
	
	Usuario findByLogin(String login);
	public List<Usuario> findByNomeContaining(String nome);

}
