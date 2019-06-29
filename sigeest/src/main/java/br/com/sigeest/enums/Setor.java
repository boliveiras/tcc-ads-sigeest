package br.com.sigeest.enums;

public enum Setor {
	
	NOC("Noc"), ATENDIMENTO("Atendimento"), INFRA("Infraestrutura"), PROJETOS("Projetos"), GERENCIA("Gerência"), DIRECAO("Direção");

	public String descricao;

	Setor(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
