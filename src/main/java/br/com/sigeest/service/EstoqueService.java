package br.com.sigeest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigeest.model.Bateria;
import br.com.sigeest.model.Equipamento;
import br.com.sigeest.model.Estoque;
import br.com.sigeest.repository.Baterias;
import br.com.sigeest.repository.Equipamentos;
import br.com.sigeest.repository.Estoques;

@Service
public class EstoqueService {

	@Autowired
	private Estoques estoques;
	
	@Autowired
	private Equipamentos equipamentos;
	
	@Autowired
	private Baterias baterias;

	public void cadastrar(Estoque estoque) {
		estoques.save(estoque);
	}

	public void excluir(Long codigo) {
		estoques.delete(codigo);
	}

	public List<Estoque> retornarTodos() {
		return estoques.findAll();
	}

	public void enviarEquipamentoManutencao(Equipamento equipamento) {
		equipamento.emManutencao();
		equipamentos.save(equipamento);
	}

	public void receberEquipamentoManutencao(Equipamento equipamento) {
		equipamento.semManutencao();
		equipamentos.save(equipamento);
	}

	public void enviarBateriaManutencao(Bateria bateria) {
		bateria.emManutencao();	
		baterias.save(bateria);
	}

	public void receberBateriaManutencao(Bateria bateria) {
		bateria.semManutencao();
		baterias.save(bateria);
	}

}
