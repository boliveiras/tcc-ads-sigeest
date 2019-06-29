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
import javax.validation.constraints.Pattern;

import br.com.sigeest.enums.Status;
import br.com.sigeest.enums.TipoEquipamento;

@Entity
@Table(name = "equipamentos", uniqueConstraints = @UniqueConstraint(columnNames = "mac", name = "u_equipamento_mac"))
public class Equipamento extends Componente {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "MAC é obrigatório")
	@Pattern(regexp = "^([0-9a-fA-F]{2}:){5}[0-9a-fA-F]{2}$", message = "MAC-ADDRESS fora do padrão")
	private String mac;

	@Enumerated(EnumType.STRING)
	private TipoEquipamento tipo;

	@ManyToOne	
	@JoinColumn(name = "codigo_fabricante", foreignKey = @ForeignKey(name = "fk_equipamento_fabricante"), referencedColumnName = "codigo")
	private Fabricante fabricante;

	@ManyToOne
	@JoinColumn(name = "codigo_estrutura", foreignKey = @ForeignKey(name = "fk_equipamento_estrutura"), referencedColumnName = "codigo")
	private Estrutura estrutura;

	@ManyToOne
	@JoinColumn(name = "codigo_estoque", foreignKey = @ForeignKey(name = "fk_equipamento_estoque"), referencedColumnName = "codigo")
	private Estoque estoque;

	public Equipamento() {

	}	

	public Equipamento(Long codigo, String nome, Integer corrente, Integer voltagem, Double preco, Status status,
			Date dataCompra, Boolean ativo, String mac, TipoEquipamento tipo, Fabricante fabricante,
			Estrutura estrutura, Estoque estoque) {
		super(codigo, nome, corrente, voltagem, preco, status, dataCompra, ativo);
		this.mac = mac;
		this.tipo = tipo;
		this.fabricante = fabricante;
		this.estrutura = estrutura;
		this.estoque = estoque;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public TipoEquipamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEquipamento tipo) {
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
