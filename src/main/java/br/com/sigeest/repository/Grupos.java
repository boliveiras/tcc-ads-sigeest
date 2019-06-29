package br.com.sigeest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sigeest.model.Grupo;
import br.com.sigeest.model.Usuario;

public interface Grupos extends JpaRepository<Grupo, Long>{
	
	List<Grupo> findByUsuariosIn(Usuario usuario);

}
