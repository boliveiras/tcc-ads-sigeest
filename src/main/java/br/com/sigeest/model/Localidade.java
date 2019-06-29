package br.com.sigeest.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public abstract class Localidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotNull(message = "Endereço é obrigatório")
	@NotEmpty(message = "Endereço não pode ser vazio")
	@Size(max = 150, message = "Nome deve conter no máximo 150 caracteres")
	private String endereco;

	@NotEmpty(message = "Latitude é obrigatória")
	private String latitude;

	@NotEmpty(message = "Longitude é obrigatória")
	private String longitude;

	private Integer elevacao;

	@NotEmpty(message = "Telefone é obrigatório")
	private String telefone;

	private Boolean ativo;

	public Localidade() {

	}

	public Localidade(Long codigo, String endereco, String latitude, String longitude, Integer elevacao,
			String telefone, Boolean ativo) {
		super();
		this.codigo = codigo;
		this.endereco = endereco;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevacao = elevacao;
		this.telefone = telefone;
		this.ativo = ativo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Integer getElevacao() {
		return elevacao;
	}

	public void setElevacao(Integer elevacao) {
		this.elevacao = elevacao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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
		Localidade other = (Localidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
