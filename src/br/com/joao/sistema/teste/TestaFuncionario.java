package br.com.joao.sistema.teste;

import br.com.joao.sistema.bean.Funcionario;
import br.com.joao.sistema.dao.FuncionarioDAO;

public class TestaFuncionario {
	public void salvar() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("nome");
		funcionario.setRg("rg");
		funcionario.setCpf("cpf");
		funcionario.setSexo('M');
		funcionario.setDataNascimento("dataNascimento");
		funcionario.setTelefone("telefone");
		funcionario.setCelular("celular");
		funcionario.setEmail("email");
		funcionario.setEstado("estado");
		funcionario.setCidade("cidade");
		funcionario.setCep("cep");
		funcionario.setBairro("bairro");
		funcionario.setLogradouro("logradouro");
		funcionario.setNumero(10);
		funcionario.setComplemento("complemento");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		try {
			dao.salvar(funcionario);
        } catch (Exception ex) {
            System.out.println("Erro");
            ex.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		new TestaFuncionario().salvar();
	}
}
