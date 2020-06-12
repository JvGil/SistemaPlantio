package br.com.joao.sistema.backingbean;

import java.util.ArrayList;

import br.com.joao.sistema.bean.Insumo;
import br.com.joao.sistema.controller.InsumoController;
import br.com.joao.sistema.util.GeraExcel;
import br.com.joao.sistema.util.JSFUtil;

public class InsumoBacking {
	private int codigo;
	private String tipo;
	private String nome;
	private int quantidade;
	private double valor;

	private ArrayList<Insumo> listaInsumos;
	private Insumo insumoSelecionado = new Insumo();

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public ArrayList<Insumo> getListaInsumos() {
		return listaInsumos;
	}

	public void setListaInsumos(ArrayList<Insumo> listaInsumos) {
		this.listaInsumos = listaInsumos;
	}

	public Insumo getInsumoSelecionado() {
		return insumoSelecionado;
	}

	public void setInsumoSelecionado(Insumo insumoSelecionado) {
		this.insumoSelecionado = insumoSelecionado;
	}

	// ========================================================= MÉTODOS PARA ACESSAR PÁGINAS =========================================================
	public String cadastraInsumo() {
		return "";
	}

	public String voltaMenu() {
		limparCampos();
		return "";
	}

	public String consultaInsumo() {
		carregarInsumos();
		return "";
	}

	// ===================================================== FIM DOS MÉTODOS PARA ACESSAR PÁGINAS =====================================================

	// MÉTODOS PARA VALIDAÇÕES / LIMPAR CAMPOS / CARREGAR ITENS
	public void limparCampos() {
		codigo = 0;
		nome = null;
		tipo = null;
		quantidade = 0;
		valor = 0;
	}

	public String alteraInsumo() {
		codigo = insumoSelecionado.getIdInsumo();
		tipo = insumoSelecionado.getTipo();
		nome = insumoSelecionado.getNome();
		quantidade = insumoSelecionado.getQuantidade();
		valor = insumoSelecionado.getValor();
		return "alterar";
	}
	
	public boolean validaSalvar() {
		if (tipo.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o tipo, campo obrigatório");
			return false;
		}
		if (nome.equals("")) {
			JSFUtil.addInfoMessage("Informe o nome, campo obrigatório");
			return false;
		}
		if (quantidade == 0) {
			JSFUtil.addInfoMessage("Informe a quantidade, campo obrigatório");
			return false;
		}
		if (valor <= 0) {
			JSFUtil.addInfoMessage("Informe o valor, campo obrigatório");
			return false;
		}
		
		return true;
	}

	// CRUD
	public String salvar() {
		Insumo insumo = new Insumo();
		if (validaSalvar()) {
			insumo.setTipo(tipo);
			insumo.setNome(nome);
			insumo.setQuantidade(quantidade);
			insumo.setValor(valor);

			InsumoController controller = new InsumoController();
			try {
				controller.salvar(insumo);
				JSFUtil.addInfoMessage("Insumo salvo");
			} catch (Exception ex) {
				JSFUtil.addInfoMessage("Erro ao salvar o Insumo");
			}
		}
		limparCampos();
		return "";
	}

	public String alterar() {
		insumoSelecionado.setTipo(tipo);
		insumoSelecionado.setNome(nome);
		insumoSelecionado.setQuantidade(quantidade);
		insumoSelecionado.setValor(valor);

		InsumoController controller = new InsumoController();
		try {
			controller.salvar(insumoSelecionado);
			JSFUtil.addInfoMessage("Insumo alterado");
		} catch (Exception ex) {
			JSFUtil.addInfoMessage("Erro ao alterar o Insumo");
		}
		limparCampos();
		return "";
	}

	public String excluir() {
		InsumoController controller = new InsumoController();
		try {
			controller.excluir(insumoSelecionado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		carregarInsumos();
		return "";
	}
	
	public String carregarInsumos() {
		this.scrollerPage = 1;
		this.listaInsumos = new ArrayList<Insumo>();
		try {
			this.listaInsumos = new InsumoController().buscarTodos();
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro ao listar as fazendas");
		}
		return "";
	}
	
	public String geraExcel() {
		Insumo insumo = new Insumo();
		GeraExcel.geraExcel("TIPO", "NOME", "VALOR", insumo);
		return "";
	}
}
