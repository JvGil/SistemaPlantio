package br.com.joao.sistema.backingbean;

import java.util.ArrayList;

import br.com.joao.sistema.bean.Fazenda;
import br.com.joao.sistema.controller.FazendaController;
import br.com.joao.sistema.util.GeraExcel;
import br.com.joao.sistema.util.JSFUtil;

public class FazendaBacking {
	private int codigo;
	private String nome;
	private String estado;
	private String cidade;
	private String cep;
	private String bairro;
	private String logradouro;
	private int numero;
	private String complemento;
	private double areaTotal;

	private ArrayList<Fazenda> listaFazendas;
	private Fazenda fazendaSelecionada = new Fazenda();

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

	public double getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(double areaTotal) {
		this.areaTotal = areaTotal;
	}

	public Fazenda getFazendaSelecionada() {
		return fazendaSelecionada;
	}

	public void setFazendaSelecionada(Fazenda fazendaSelecionada) {
		this.fazendaSelecionada = fazendaSelecionada;
	}

	public ArrayList<Fazenda> getListaFazendas() {
		return listaFazendas;
	}

	public void setListaFazendas(ArrayList<Fazenda> listaFazendas) {
		this.listaFazendas = listaFazendas;
	}

	// ========================================================= MÉTODOS PARA ACESSAR PÁGINAS =========================================================
	public String cadastraFazenda() {
		return "";
	}

	public String voltaMenu() {
		limparCampos();
		return "";
	}

	public String consultaFazenda() {
		carregarFazendas();
		return "";
	}

	// ===================================================== FIM DOS MÉTODOS PARA ACESSAR PÁGINAS =====================================================

	// MÉTODOS PARA VALIDAÇÕES / LIMPAR CAMPOS / CARREGAR ITENS
	public void limparCampos() {
		codigo = 0;
		nome = null;
		estado = null;
		cidade = null;
		cep = null;
		bairro = null;
		logradouro = null;
		numero = 0;
		complemento = null;
		areaTotal = 0;
	}

	public String alteraFazenda() {
		codigo = fazendaSelecionada.getIdFazenda();
		nome = fazendaSelecionada.getNome();
		estado = fazendaSelecionada.getEstado();
		cidade = fazendaSelecionada.getCidade();
		cep = fazendaSelecionada.getCep();
		bairro = fazendaSelecionada.getBairro();
		logradouro = fazendaSelecionada.getLogradouro();
		numero = fazendaSelecionada.getNumero();
		complemento = fazendaSelecionada.getComplemento();
		areaTotal = fazendaSelecionada.getAreaTotal();
		return "alterar";
	}
	
	public boolean validaSalvar() {
		if (nome.equals("")) {
			JSFUtil.addInfoMessage("Informe o nome, campo obrigatório");
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
		if (areaTotal == 0) {
			JSFUtil.addInfoMessage("Informe a área total, campo obrigatório");
			return false;
		}
		return true;
	}

	// CRUD
	public String salvar() {
		Fazenda fazenda = new Fazenda();
		if (validaSalvar()) {
			fazenda.setNome(nome);
			fazenda.setEstado(estado);
			fazenda.setCidade(cidade);
			fazenda.setCep(cep);
			fazenda.setBairro(bairro);
			fazenda.setLogradouro(logradouro);
			fazenda.setNumero(numero);
			fazenda.setComplemento(complemento);
			fazenda.setAreaTotal(areaTotal);

			FazendaController controller = new FazendaController();
			try {
				controller.salvar(fazenda);
				JSFUtil.addInfoMessage("Fazenda salva");
			} catch (Exception ex) {
				JSFUtil.addInfoMessage("Erro ao salvar a Fazenda");
			}
		}
		limparCampos();
		return "";
	}

	public String alterar() {
		fazendaSelecionada.setNome(nome);
		fazendaSelecionada.setEstado(estado);
		fazendaSelecionada.setCidade(cidade);
		fazendaSelecionada.setCep(cep);
		fazendaSelecionada.setBairro(bairro);
		fazendaSelecionada.setLogradouro(logradouro);
		fazendaSelecionada.setNumero(numero);
		fazendaSelecionada.setComplemento(complemento);
		fazendaSelecionada.setAreaTotal(areaTotal);

		FazendaController controller = new FazendaController();
		try {
			controller.salvar(fazendaSelecionada);
			JSFUtil.addInfoMessage("Fazenda alterado");
		} catch (Exception ex) {
			JSFUtil.addInfoMessage("Erro ao alterar o Fazenda");
		}
		limparCampos();
		return "";
	}

	public String excluir() {
		FazendaController controller = new FazendaController();
		try {
			controller.excluir(fazendaSelecionada);
		} catch (Exception e) {
			e.printStackTrace();
		}
		carregarFazendas();
		return "";
	}
	
	public String carregarFazendas() {
		this.scrollerPage = 1;
		this.listaFazendas = new ArrayList<Fazenda>();
		try {
			this.listaFazendas = new FazendaController().buscarTodos();
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar as fazendas");
		}
		return "";
	}
	
	public String geraExcel() {
		Fazenda fazenda = new Fazenda();
		GeraExcel.geraExcel("NOME", "AREA TOTAL", "CIDADE", fazenda);
		return "";
	}
}
