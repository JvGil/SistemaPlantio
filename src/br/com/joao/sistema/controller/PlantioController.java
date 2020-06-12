package br.com.joao.sistema.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;

import br.com.joao.sistema.bean.Plantio;
import br.com.joao.sistema.dao.PlantioDAO;

public class PlantioController {
	public void salvar(Plantio plantio) throws Exception {
		PlantioDAO dao = new PlantioDAO();
		dao.salvar(plantio);
	}
	
	public void excluir(Plantio plantio) throws Exception {
		PlantioDAO dao = new PlantioDAO();
		dao.excluir(plantio);
	}
	
	public ArrayList<Plantio> buscarTodos() throws Exception {
		ArrayList<Plantio> lista = new ArrayList<Plantio>();
		lista = new PlantioDAO().buscarTodos();
		return lista;
	}
	
	public ArrayList<Plantio> buscarNome(String nome) {
		 ArrayList<Plantio> listaRetorno = new ArrayList<Plantio>();
		 PlantioDAO dao = new PlantioDAO();
		 try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return listaRetorno;
	 }
}
