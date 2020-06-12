package br.com.joao.sistema.backingbean;

import java.util.ArrayList;

import br.com.joao.sistema.bean.Funcionario;
import br.com.joao.sistema.controller.FuncionarioController;
import br.com.joao.sistema.dao.FuncionarioDAO;
import br.com.joao.sistema.util.GeraExcel;
import br.com.joao.sistema.util.JSFUtil;

public class FuncionarioBacking {
	private int codigo;
	private String nome;
	private String rg;
	private String cpf;
	private String sexo;
	private String dataNascimento;
	private String telefone;
	private String celular;
	private String email;
	private String estado;
	private String cidade;
	private String cep;
	private String bairro;
	private String logradouro;
	private int numero;
	private String complemento;
	private double salario;

	private ArrayList<Funcionario> listaFuncionarios;
	private Funcionario funcionarioSelecionado = new Funcionario();

	private int scrollerPage;

	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	// ========================================================= MÉTODOS PARA
	// ACESSAR PÁGINAS =========================================================
	public String cadastraFuncionario() {
		return "";
	}

	public String cancelar() {
		limparCampos();
		return "";
	}

	public String voltaMenu() {
		return "";
	}

	public String consultaFuncionario() {
		carregarFuncionarios();
		return "";
	}

	// ===================================================== FIM DOS MÉTODOS PARA ACESSAR PÁGINAS =====================================================

	// MÉTODOS COM INTELIGÊNCIA DE TELA
	public void limparCampos() {
		codigo = 0;
		nome = null;
		rg = null;
		cpf = null;
		sexo = null;
		dataNascimento = null;
		telefone = null;
		celular = null;
		email = null;
		estado = null;
		cidade = null;
		cep = null;
		bairro = null;
		logradouro = null;
		numero = 0;
		complemento = null;
		salario = 0;
	}

	public String alteraFuncionario() {
		codigo = funcionarioSelecionado.getIdFuncionario();
		nome = funcionarioSelecionado.getNome();
		rg = funcionarioSelecionado.getRg();
		cpf = funcionarioSelecionado.getCpf();
		sexo = funcionarioSelecionado.getSexo() + "";
		dataNascimento = funcionarioSelecionado.getDataNascimento();
		telefone = funcionarioSelecionado.getTelefone();
		celular = funcionarioSelecionado.getCelular();
		email = funcionarioSelecionado.getEmail();
		estado = funcionarioSelecionado.getEstado();
		cidade = funcionarioSelecionado.getEstado();
		cep = funcionarioSelecionado.getCep();
		bairro = funcionarioSelecionado.getBairro();
		logradouro = funcionarioSelecionado.getLogradouro();
		numero = funcionarioSelecionado.getNumero();
		complemento = funcionarioSelecionado.getComplemento();
		salario = funcionarioSelecionado.getSalario();
		return "alterar";
	}
	
	public boolean validaSalvar() {
		if (nome.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nome, campo obrigatório");
			return false;
		}
		if (cpf.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o CPF, campo obrigatório");
			return false;
		}
		if (rg.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o RG, campo obrigatório");
			return false;
		}
		if (sexo.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o sexo, campo obrigatório");
			return false;
		}
		if (dataNascimento.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe a data de nascimento, campo obrigatório");
			return false;
		}
		if (telefone.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o sexo, campo obrigatório");
			return false;
		}
		if (celular.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o sexo, campo obrigatório");
			return false;
		}
		if (email.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o sexo, campo obrigatório");
			return false;
		}
		if (estado.equals("")) {
			JSFUtil.addInfoMessage("Informe o estado, campo obrigatório");
			return false;
		}
		if (cidade.equals("")) {
			JSFUtil.addInfoMessage("Informe a cidade, campo obrigatório");
			return false;
		}
		if (cep.equals("")) {
			JSFUtil.addInfoMessage("Informe o CEP, campo obrigatório");
			return false;
		}
		if (bairro.equals("")) {
			JSFUtil.addInfoMessage("Informe o bairro, campo obrigatório");
			return false;
		}
		if (logradouro.equals("")) {
			JSFUtil.addInfoMessage("Informe o logradouro, campo obrigatório");
			return false;
		}
		if (numero == 0) {
			JSFUtil.addInfoMessage("Informe o numero, campo obrigatório");
			return false;
		}
		if (salario == 0) {
			JSFUtil.addInfoMessage("Informe o salário, campo obrigatório");
			return false;
		}
		
		return true;
	}

	// CRUD
	public String salvar() {
		Funcionario funcionario = new Funcionario();
		if (validaSalvar()) {
			funcionario.setNome(nome);
			funcionario.setRg(rg);
			funcionario.setCpf(cpf);
			funcionario.setSexo(sexo.charAt(0));
			funcionario.setDataNascimento(dataNascimento);
			funcionario.setTelefone(telefone);
			funcionario.setCelular(celular);
			funcionario.setEmail(email);
			funcionario.setEstado(estado);
			funcionario.setCidade(cidade);
			funcionario.setCep(cep);
			funcionario.setBairro(bairro);
			funcionario.setLogradouro(logradouro);
			funcionario.setNumero(numero);
			funcionario.setComplemento(complemento);
			funcionario.setSalario(salario);

			FuncionarioController controller = new FuncionarioController();
			try {
				controller.salvar(funcionario);
				JSFUtil.addInfoMessage("Funcionario salvo");
			} catch (Exception ex) {
				JSFUtil.addInfoMessage("Erro ao salvar o Funcionario");
			}
		}
		limparCampos();
		return "";
	}

	public String carregarFuncionarios() {
		this.scrollerPage = 1;
		try {
			this.listaFuncionarios = new FuncionarioDAO().buscarTodos();

		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar os clientes");
		}
		return "";
	}

	public String alterar() {
		funcionarioSelecionado.setNome(nome);
		funcionarioSelecionado.setRg(rg);
		funcionarioSelecionado.setCpf(cpf);
		funcionarioSelecionado.setSexo(sexo.charAt(0));
		funcionarioSelecionado.setDataNascimento(dataNascimento);
		funcionarioSelecionado.setTelefone(telefone);
		funcionarioSelecionado.setCelular(celular);
		funcionarioSelecionado.setEmail(email);
		funcionarioSelecionado.setEstado(estado);
		funcionarioSelecionado.setCidade(cidade);
		funcionarioSelecionado.setCep(cep);
		funcionarioSelecionado.setBairro(bairro);
		funcionarioSelecionado.setLogradouro(logradouro);
		funcionarioSelecionado.setNumero(numero);
		funcionarioSelecionado.setComplemento(complemento);
		funcionarioSelecionado.setSalario(salario);

		FuncionarioController controller = new FuncionarioController();
		try {
			controller.salvar(funcionarioSelecionado);
			JSFUtil.addInfoMessage("Funcionario alterado");
		} catch (Exception ex) {
			JSFUtil.addInfoMessage("Erro ao alterar o Funcionario");
		}
		return "";
	}

	public String excluir() {
		FuncionarioDAO dao = new FuncionarioDAO();
		try {
			dao.excluir(funcionarioSelecionado);
			JSFUtil.addInfoMessage("Funcionário excluído com sucesso!");
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao excluir funcionário");
		}
		carregarFuncionarios();
		return "";
	}
	
	public String geraExcel() {
		Funcionario funcionario = new Funcionario();
		GeraExcel.geraExcel("NOME", "TELEFONE", "DATA NASCIMENTO", funcionario);
		JSFUtil.addInfoMessage("Relatório gerado com sucesso!");
		return "";
	}
}
