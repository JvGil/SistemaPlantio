package br.com.joao.sistema.vo;

public class FazendaVO {
	private String nome;
	private String areaTotal;
	private String cidade;

	public FazendaVO() {
	}

	public FazendaVO(String nome, String areaTotal, String cidade) {
		this.nome = nome;
		this.areaTotal = areaTotal;
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(String areaTotal) {
		this.areaTotal = areaTotal;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
