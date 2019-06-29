package br.com.sigeest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sigeest.enums.Status;
import br.com.sigeest.model.Bateria;

public interface Baterias extends JpaRepository<Bateria, Long>{
	
	public List<Bateria> findByNomeContaining(String nome);
	public List<Bateria> findByStatus(Status status);

}
