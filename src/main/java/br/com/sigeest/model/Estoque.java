package br.com.sigeest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "estoques", uniqueConstraints = @UniqueConstraint(columnNames = "descricao", name = "u_estoque_descricao"))
public class Estoque extends Localidade {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Descrição é obrigatória")
	@NotEmpty(message = "Descrição não pode ser vazia")
	@Size(max = 55, message = "Descrição deve conter no mínimo 55 caracteres")
	private String descricao;

	@OneToMany(mappedBy = "estoque", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Equipamento> equipamentos;

	@OneToMany(mappedBy = "estoque", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Bateria> baterias;

	public Estoque() {

	}

	public Estoque(Long codigo, String endereco, String latitude, String longitude, Integer elevacao, String telefone,
			Boolean ativo, String descricao, List<Equipamento> equipamentos, List<Bateria> baterias) {
		super(codigo, endereco, latitude, longitude, elevacao, telefone, ativo);
		this.descricao = descricao;
		this.equipamentos = equipamentos;
		this.baterias = baterias;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public List<Bateria> getBaterias() {
		return baterias;
	}

	public void setBaterias(List<Bateria> baterias) {
		this.baterias = baterias;
	}
	
	public void adicionarEquipamento(Equipamento equipamento) {
		this.equipamentos.add(equipamento);
		equipamento.setEstoque(this);
	}

	public void removerEquipamento(Equipamento equipamento) {
		this.equipamentos.remove(equipamento);
		equipamento.setEstoque(null);
	}

	public void adicionarBateria(Bateria bateria) {
		this.baterias.add(bateria);
		bateria.setEstoque(this);
	}

	public void removerBateria(Bateria bateria) {
		this.baterias.remove(bateria);
		bateria.setEstoque(null);
	}

}
