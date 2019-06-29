package br.com.sigeest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigeest.enums.Status;
import br.com.sigeest.model.Bateria;
import br.com.sigeest.repository.Baterias;

@Service
public class BateriaService {

	@Autowired
	private Baterias baterias;

	public void cadastrar(Bateria bateria) {
		bateria.estocar();
		baterias.save(bateria);
	}

	public void excluir(Long codigo) {
		baterias.delete(codigo);
	}

	public List<Bateria> retornarTodas() {
		return baterias.findAll();
	}
	
	public List<Bateria> retornarBateriasDesalocadas(Status status){
		return baterias.findByStatus(status);
	}

}
