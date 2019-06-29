package br.com.sigeest.enums;

public enum TipoEstrutura {
	
	TRANSMISSAO("Transmissão"), RECEPCAO("Recepção"), REPETICAO("Repetição");

	public String descricao;

	TipoEstrutura(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
