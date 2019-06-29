package br.com.sigeest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "fabricantes", uniqueConstraints = @UniqueConstraint(columnNames = "nome", name = "u_fabricante_nome"))
public class Fabricante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotNull(message = "Nome é obrigatório")
	@NotEmpty(message = "Nome não pode ser vazio")
	@Size(max = 55, message = "Nome deve conter no mínimo 55 caracteres")
	private String nome;

	@Email
	@Column(name = "EMAIL")
	private String email;

	@OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Equipamento> equipamentos;
	
	@OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)	
	private List<Bateria> baterias;

	public Fabricante() {

	}	

	public Fabricante(Long codigo, String nome, String email, List<Equipamento> equipamentos, List<Bateria> baterias) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.equipamentos = equipamentos;
		this.baterias = baterias;
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		equipamentos.add(equipamento);
		equipamento.setFabricante(this);
	}

	public void removeEquipamento(Equipamento equipamento) {
		equipamentos.remove(equipamento);
		equipamento.setFabricante(null);
	}
	
	public void adicionarBateria(Bateria  bateria) {
		baterias.add(bateria);
		bateria.setFabricante(this);
	}

	public void removerBateria(Bateria bateria) {
		baterias.remove(bateria);
		bateria.setFabricante(null);
	}

}
