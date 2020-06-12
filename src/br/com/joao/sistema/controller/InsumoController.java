package br.com.joao.sistema.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;

import br.com.joao.sistema.bean.Insumo;
import br.com.joao.sistema.dao.InsumoDAO;
import br.com.joao.sistema.vo.InsumoVO;

public class InsumoController {
	public void salvar(Insumo insumo) throws Exception {
		InsumoDAO dao = new InsumoDAO();
		dao.salvar(insumo);
	}
	
	public void excluir(Insumo insumo) throws Exception {
		InsumoDAO dao = new InsumoDAO();
		dao.excluir(insumo);
	}

	public ArrayList<InsumoVO> retornaInsumos() {
		ArrayList<InsumoVO> listaVO = new ArrayList<InsumoVO>();
		try {
			ArrayList<Insumo> listaInsumos = new InsumoDAO().buscarTodos();
			for (Insumo insumo : listaInsumos) {
				InsumoVO vo = new InsumoVO();
				vo.setTipo(insumo.getTipo());
				vo.setNome(insumo.getNome());
				String aux = new DecimalFormat("R$#,##0.00").format(insumo.getValor());
				vo.setValor(aux);
				listaVO.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaVO;
	}
	
	public ArrayList<Insumo> buscarTodos() throws Exception {
		ArrayList<Insumo> lista = new ArrayList<Insumo>();
		lista = new InsumoDAO().buscarTodos();
		return lista;
	}
	
	public ArrayList<Insumo> buscarNome(String nome) {
		 ArrayList<Insumo> listaRetorno = new ArrayList<Insumo>();
		 InsumoDAO dao = new InsumoDAO();
		 try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return listaRetorno;
	 }
}
