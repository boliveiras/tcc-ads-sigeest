package br.com.sigeest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigeest.model.Fabricante;
import br.com.sigeest.repository.Fabricantes;

@Service
public class FabricanteService {

	@Autowired
	private Fabricantes fabricantes;

	public void cadastrar(Fabricante fabricante) {
		fabricantes.save(fabricante);
	}

	public void excluir(Long codigo) {
		fabricantes.delete(codigo);
	}

	public List<Fabricante> retornarTodos() {
		return fabricantes.findAll();
	}

}
