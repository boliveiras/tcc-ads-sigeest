package br.com.sigeest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import br.com.sigeest.enums.Status;
import br.com.sigeest.enums.TipoBateria;

@Entity
@Table(name = "baterias", uniqueConstraints = @UniqueConstraint(columnNames = "serial", name = "u_bateria_serial"))

public class Bateria extends Componente {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Número de série é obrigatório")
	private String serial;

	@Enumerated(EnumType.STRING)
	private TipoBateria tipo;

	@ManyToOne	
	@JoinColumn(name = "codigo_fabricante", foreignKey = @ForeignKey(name = "fk_bateria_fabricante"), referencedColumnName = "codigo")
	private Fabricante fabricante;

	@ManyToOne	
	@JoinColumn(name = "codigo_estrutura", foreignKey = @ForeignKey(name = "fk_bateria_estrutura"), referencedColumnName = "codigo")
	private Estrutura estrutura;

	@ManyToOne	
	@JoinColumn(name = "codigo_estoque", foreignKey = @ForeignKey(name = "fk_bateria_estoque"), referencedColumnName = "codigo")
	private Estoque estoque;

	public Bateria() {

	}

	public Bateria(Long codigo, String nome, Integer corrente, Integer voltagem, Double preco, Status status,
			Date dataCompra, Boolean ativo, String serial, TipoBateria tipo, Fabricante fabricante, Estrutura estrutura,
			Estoque estoque) {
		super(codigo, nome, corrente, voltagem, preco, status, dataCompra, ativo);
		this.serial = serial;
		this.tipo = tipo;
		this.fabricante = fabricante;
		this.estrutura = estrutura;
		this.estoque = estoque;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public TipoBateria getTipo() {
		return tipo;
	}

	public void setTipo(TipoBateria tipo) {
		this.tipo = tipo;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Estrutura getEstrutura() {
		return estrutura;
	}

	public void setEstrutura(Estrutura estrutura) {
		this.estrutura = estrutura;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

}
