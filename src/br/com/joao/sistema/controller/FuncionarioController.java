package br.com.joao.sistema.controller;

import java.util.ArrayList;

import br.com.joao.sistema.bean.Funcionario;
import br.com.joao.sistema.dao.FuncionarioDAO;
import br.com.joao.sistema.vo.FuncionarioVO;

public class FuncionarioController {
	public void salvar(Funcionario funcionario) throws Exception{
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.salvar(funcionario);
	}
	
	public ArrayList<FuncionarioVO> retornaFuncionarios() {
		ArrayList<FuncionarioVO> listaVO = new ArrayList<FuncionarioVO>();
		try {
			ArrayList<Funcionario> listaFuncionarios = new FuncionarioDAO().buscarTodos();
			for (Funcionario funcionario : listaFuncionarios) {
				FuncionarioVO vo = new FuncionarioVO();
				vo.setNome(funcionario.getNome());
				vo.setTelefone(funcionario.getTelefone());
				vo.setDataNascimento(funcionario.getDataNascimento());
				listaVO.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaVO;
	}
}
