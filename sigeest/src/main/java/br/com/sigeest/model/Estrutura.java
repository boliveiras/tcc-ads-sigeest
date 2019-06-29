package br.com.sigeest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import br.com.sigeest.enums.TipoEstrutura;

@Entity
@Table(name = "estruturas", uniqueConstraints = @UniqueConstraint(columnNames = "nome", name = "u_estrutura_nome"))
public class Estrutura extends Localidade {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Nome é obrigatório")
	@NotEmpty(message = "Nome não pode ser vazio")
	@Size(max = 55, message = "Nome deve conter no mínimo 55 caracteres")
	private String nome;

	@NotNull(message = "Nome do proprietário é obrigatório")
	@NotEmpty(message = "Nome do proprietário não pode ser vazio")
	@Size(max = 55, message = "Nome do proprietário deve conter no máximo 55 caracteres")
	private String proprietario;

	@NotNull(message = "Valor do aluguel é obrigatório")
	@DecimalMin(value = "0.01", message = "Valor não pode ser inferior a 0,01")
	@DecimalMax(value = "9999999.99", message = "Valor não pode ser maior que 9.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private Double aluguel;

	@Enumerated(EnumType.STRING)
	private TipoEstrutura tipo;

	@OneToMany(mappedBy = "estrutura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Equipamento> equipamentos;

	@OneToMany(mappedBy = "estrutura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Bateria> baterias;

	public Estrutura() {

	}

	public Estrutura(Long codigo, String endereco, String latitude, String longitude, Integer elevacao, String telefone,
			Boolean ativo, String nome, String proprietario, Double aluguel, TipoEstrutura tipo,
			List<Equipamento> equipamentos, List<Bateria> baterias) {
		super(codigo, endereco, latitude, longitude, elevacao, telefone, ativo);
		this.nome = nome;
		this.proprietario = proprietario;
		this.aluguel = aluguel;
		this.tipo = tipo;
		this.equipamentos = equipamentos;
		this.baterias = baterias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public Double getAluguel() {
		return aluguel;
	}

	public void setAluguel(Double aluguel) {
		this.aluguel = aluguel;
	}

	public TipoEstrutura getTipo() {
		return tipo;
	}

	public void setTipo(TipoEstrutura tipo) {
		this.tipo = tipo;
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
		equipamento.setEstrutura(this);
	}

	public void removerEquipamento(Equipamento equipamento) {
		this.equipamentos.remove(equipamento);
		equipamento.setEstrutura(null);
	}

	public void adicionarBateria(Bateria bateria) {
		this.baterias.add(bateria);
		bateria.setEstrutura(this);
	}

	public void removerBateria(Bateria bateria) {
		this.baterias.remove(bateria);
		bateria.setEstrutura(null);
	}

}
