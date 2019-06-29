package br.com.sigeest.enums;

public enum TipoUsuario {
	
	COMUM("Comum"), ADMIN("Administrador"), DESENVOLVEDOR("Desenvolvedor");

	public String descricao;

	TipoUsuario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
