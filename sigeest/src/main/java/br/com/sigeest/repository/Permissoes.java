package br.com.sigeest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sigeest.model.Grupo;
import br.com.sigeest.model.Permissao;

public interface Permissoes extends JpaRepository<Permissao, Long>{
	
	List<Permissao> findByGruposIn(Grupo grupo);

}
