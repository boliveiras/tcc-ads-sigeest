package br.com.sigeest.enums;

public enum TipoBateria {
	
	VLRA("VRLA"), NOBREAK("No-Break"), ESTACIONARIA("Estacionária");

	public String descricao;

	TipoBateria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
