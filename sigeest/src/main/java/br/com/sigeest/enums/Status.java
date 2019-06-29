package br.com.sigeest.enums;

public enum Status {
	
	ALOCADO("Em uso"), DESALOCADO("Em estoque"), MANUTENCAO("Em reparo"), INDEFINIDO("Indefinido");

	public String descricao;

	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
