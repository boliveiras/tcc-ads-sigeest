package br.com.sigeest.enums;

public enum TipoEquipamento {
	
	CPE("Cpe"), SWITCH("Switch"), ROUTER("Roteador"), CONVERSOR("Conversor"), MODEM("Modem");

	public String descricao;

	TipoEquipamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
