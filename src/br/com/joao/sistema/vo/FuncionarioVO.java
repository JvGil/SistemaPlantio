package br.com.joao.sistema.vo;

public class FuncionarioVO {
	private String nome;
	private String telefone;
	private String dataNascimento;
	
	public FuncionarioVO() {
	}

	public FuncionarioVO(String nome, String telefone, String dataNascimento) {
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
