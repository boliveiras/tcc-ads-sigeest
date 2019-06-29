package br.com.sigeest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigeest.model.Bateria;
import br.com.sigeest.model.Equipamento;
import br.com.sigeest.model.Estoque;
import br.com.sigeest.model.Estrutura;
import br.com.sigeest.repository.Baterias;
import br.com.sigeest.repository.Equipamentos;
import br.com.sigeest.repository.Estoques;
import br.com.sigeest.repository.Estruturas;

@Service
public class EstruturaService {

	@Autowired
	private Estruturas estruturas;

	@Autowired
	private Equipamentos equipamentos;

	@Autowired
	private Baterias baterias;

	@Autowired
	private Estoques estoques;
	
	public void cadastrar(Estrutura estrutura) {
		estruturas.save(estrutura);	
		
	}
	
	public void excluir(Long codigo) {
		estruturas.delete(codigo);
	}
	
	public List<Estrutura> retornarTodas(){
		return estruturas.findAll();
	}

	public void adicionarEquipamento(Estrutura estrutura, Equipamento equipamento, Estoque estoque) {
		equipamento.desestocar();
		estrutura.adicionarEquipamento(equipamento);
		estoque.removerEquipamento(equipamento);
		equipamentos.save(equipamento);
		estruturas.save(estrutura);
		estoques.save(estoque);
	}

	public void removerEquipamento(Estrutura estrutura, Equipamento equipamento, Estoque estoque) {
		equipamento.estocar();
		estrutura.removerEquipamento(equipamento);
		estoque.adicionarEquipamento(equipamento);
		equipamentos.save(equipamento);
		estruturas.save(estrutura);
		estoques.save(estoque);
	}

	public void adicionarBateria(Estrutura estrutura, Bateria bateria, Estoque estoque) {
		bateria.desestocar();
		estrutura.adicionarBateria(bateria);
		estoque.removerBateria(bateria);
		baterias.save(bateria);
		estruturas.save(estrutura);
		estoques.save(estoque);
	}

	public void removerBateria(Estrutura estrutura, Bateria bateria, Estoque estoque) {
		bateria.estocar();
		estrutura.removerBateria(bateria);
		estoque.adicionarBateria(bateria);
		baterias.save(bateria);
		estruturas.save(estrutura);
		estoques.save(estoque);
	}

}
