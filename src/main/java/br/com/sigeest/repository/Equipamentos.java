package br.com.sigeest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sigeest.enums.Status;
import br.com.sigeest.model.Equipamento;

public interface Equipamentos extends JpaRepository<Equipamento, Long>{
	
	public List<Equipamento> findByNomeContaining(String nome);
	public List<Equipamento> findByStatus(Status status);

}
