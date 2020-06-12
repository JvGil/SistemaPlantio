package br.com.joao.sistema.controller;

import java.util.ArrayList;

import br.com.joao.sistema.bean.Fazenda;
import br.com.joao.sistema.dao.FazendaDAO;
import br.com.joao.sistema.vo.FazendaVO;

public class FazendaController {
	public void salvar(Fazenda fazenda) throws Exception {
		FazendaDAO dao = new FazendaDAO();
		dao.salvar(fazenda);
	}
	
	public void excluir(Fazenda fazenda) throws Exception {
		FazendaDAO dao = new FazendaDAO();
		dao.excluir(fazenda);
	}

	public ArrayList<FazendaVO> retornaFazendas() {
		ArrayList<FazendaVO> listaVO = new ArrayList<FazendaVO>();
		try {
			ArrayList<Fazenda> listaFazendas = new FazendaDAO().buscarTodos();
			for (Fazenda fazenda : listaFazendas) {
				FazendaVO vo = new FazendaVO();
				vo.setNome(fazenda.getNome());
				vo.setAreaTotal(fazenda.getAreaTotal() + "");
				vo.setCidade(fazenda.getCidade());
				listaVO.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaVO;
	}
	
	public ArrayList<Fazenda> buscarTodos() throws Exception {
		ArrayList<Fazenda> lista = new ArrayList<Fazenda>();
		lista = new FazendaDAO().buscarTodos();
		return lista;
	}
	
	public ArrayList<Fazenda> buscarNome(String nome) {
		 ArrayList<Fazenda> listaRetorno = new ArrayList<Fazenda>();
		 FazendaDAO dao = new FazendaDAO();
		 try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return listaRetorno;
	 }
}
