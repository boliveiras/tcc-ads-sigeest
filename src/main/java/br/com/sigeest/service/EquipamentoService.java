package br.com.sigeest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigeest.enums.Status;
import br.com.sigeest.model.Equipamento;
import br.com.sigeest.repository.Equipamentos;

@Service
public class EquipamentoService {

	@Autowired
	private Equipamentos equipamentos;

	public void cadastrar(Equipamento equipamento) {
		equipamento.estocar();
		equipamentos.save(equipamento);
	}

	public void excluir(Long codigo) {
		equipamentos.delete(codigo);
	}

	public List<Equipamento> retornarTodos() {
		return equipamentos.findAll();
	}
	
	public List<Equipamento> retornarEquipamentosDesalocados(Status status){
		return equipamentos.findByStatus(status);
	}

}
