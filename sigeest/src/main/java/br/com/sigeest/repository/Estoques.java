package br.com.sigeest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sigeest.model.Estoque;

public interface Estoques extends JpaRepository<Estoque, Long>{

}
