package br.com.joao.sistema.backingbean;

import java.util.ArrayList;

import br.com.joao.sistema.bean.Plantio;
import br.com.joao.sistema.controller.PlantioController;
import br.com.joao.sistema.util.JSFUtil;

public class PlantioBacking {
	private int codigo;
	private String dataInicio;
	private String dataColheita;

	private ArrayList<Plantio> listaPlantios;
	private Plantio plantioSelecionado = new Plantio();

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

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataColheita() {
		return dataColheita;
	}

	public void setDataColheita(String dataColheita) {
		this.dataColheita = dataColheita;
	}

	public ArrayList<Plantio> getListaInsumos() {
		return listaPlantios;
	}

	public void setListaPlantios(ArrayList<Plantio> listaPlantios) {
		this.listaPlantios = listaPlantios;
	}

	public Plantio getPlantioSelecionado() {
		return plantioSelecionado;
	}

	public void setPlantioSelecionado(Plantio plantioSelecionado) {
		this.plantioSelecionado = plantioSelecionado;
	}

	// ========================================================= MÉTODOS PARA ACESSAR PÁGINAS =========================================================
	public String cadastraPlantio() {
		return "";
	}

	public String voltaMenu() {
		limparCampos();
		return "";
	}

//	public String consultaInsumo() {
//		carregarPlantios();
//		return "";
//	}

	// ===================================================== FIM DOS MÉTODOS PARA ACESSAR PÁGINAS =====================================================

	// MÉTODOS PARA VALIDAÇÕES / LIMPAR CAMPOS / CARREGAR ITENS
	public void limparCampos() {
		codigo = 0;
		dataColheita = null;
		dataInicio = null;
	}

	public String alteraInsumo() {
		codigo = plantioSelecionado.getIdPlantio();
		dataInicio = plantioSelecionado.getDataInicio();
		dataColheita = plantioSelecionado.getDataColheita();
		return "alterar";
	}
	
	public boolean validaSalvar() {
		if (dataInicio.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe a data de início da plantação, campo obrigatório");
			return false;
		}
		
		return true;
	}

	// CRUD
	public String salvar() {
		Plantio plantio = new Plantio();
		if (validaSalvar()) {
			plantio.setDataInicio(dataInicio);
			plantio.setDataColheita(dataColheita);

			PlantioController controller = new PlantioController();
			try {
				controller.salvar(plantio);
				JSFUtil.addInfoMessage("Plantio salvo");
			} catch (Exception ex) {
				JSFUtil.addInfoMessage("Erro ao salvar o Plantio");
			}
		}
		limparCampos();
		return "";
	}
	
//	public String alterar() {
//		plantioSelecionado.setDataInicio(dataInicio);
//		plantioSelecionado.setDataColheita(dataColheita);
//
//		PlantioController controller = new PlantioController();
//		try {
//			controller.salvar(plantioSelecionado);
//			JSFUtil.addInfoMessage("Plantio alterado");
//		} catch (Exception ex) {
//			JSFUtil.addInfoMessage("Erro ao alterar o Plantio");
//		}
//		limparCampos();
//		return "";
//	}
//
//	public String excluir() {
//		PlantioController controller = new PlantioController();
//		try {
//			controller.excluir(plantioSelecionado);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		carregarPlantios();
//		return "";
//	}
//	
//	public String carregarPlantios() {
//		this.scrollerPage = 1;
//		this.listaPlantios = new ArrayList<Plantio>();
//		try {
//			this.listaPlantios = new PlantioController().buscarTodos();
//		} catch (Exception e) {
//			JSFUtil.addInfoMessage("Erro ao listar os plantios");
//		}
//		return "";
//	}
}
