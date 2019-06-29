package br.com.sigeest.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import br.com.sigeest.enums.Status;

@MappedSuperclass
public abstract class Componente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull(message = "Nome é obrigatório")
	@NotEmpty(message = "Nome não pode ser vazio")
	@Size(max = 55, message = "Nome deve conter no mínimo 55 caracteres")
	private String nome;
	
	@NotNull(message = "Valor de corrente é obrigatório")
	private Integer corrente;
	
	@NotNull(message = "Voltagem é obrigatório")
	@Min(value = 5, message = "Valor de voltagem não pode ser inferior à 5v")
	@Max(value = 227, message = "Valor de voltagem não pode ser maior que 227v")
	private Integer voltagem;
	
	@NotNull(message = "Preço é obrigatório")
	@NumberFormat(pattern = "#,##0.00")
	private Double preco;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@DateTimeFormat(pattern = "dd/MM/yyy")
	@Temporal(TemporalType.DATE)
	@Past(message = "Data não pode ser futura")
	private Date dataCompra;
	
	private Boolean ativo;

	public Componente() {
		this.status = Status.INDEFINIDO;
		this.ativo = true;
	}

	
	public Componente(Long codigo, String nome, Integer corrente, Integer voltagem, Double preco, Status status,
			Date dataCompra, Boolean ativo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.corrente = corrente;
		this.voltagem = voltagem;
		this.preco = preco;
		this.status = status;
		this.dataCompra = dataCompra;
		this.ativo = ativo;
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

	public Integer getCorrente() {
		return corrente;
	}

	public void setCorrente(Integer corrente) {
		this.corrente = corrente;
	}

	public Integer getVoltagem() {
		return voltagem;
	}

	public void setVoltagem(Integer voltagem) {
		this.voltagem = voltagem;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	
	public Boolean getAtivo() {
		return ativo;
	}


	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}


	public void estocar() {
		if (this.status == Status.INDEFINIDO)
			this.status = Status.DESALOCADO;
		else if (this.status == Status.ALOCADO) {
			this.status = Status.DESALOCADO;
		} else
			return;
	}

	public void desestocar() {
		if (this.status == Status.DESALOCADO) {
			this.status = Status.ALOCADO;
		} else
			return;
	}
	
	public void emManutencao() {
		if(this.status == Status.DESALOCADO) {
			this.status = Status.MANUTENCAO;
			this.ativo = false;
		}else
			return;		
	}
	
	public void semManutencao() {
		if(this.status == Status.MANUTENCAO) {
			this.status = Status.DESALOCADO;
			this.ativo = true;
		}else
			return;		
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Componente other = (Componente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
