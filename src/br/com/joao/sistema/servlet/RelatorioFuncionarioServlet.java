package br.com.joao.sistema.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.joao.sistema.controller.FuncionarioController;
import br.com.joao.sistema.vo.FuncionarioVO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RelatorioFuncionarioServlet() {
		super();
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<FuncionarioVO> funcionarios = new FuncionarioController().retornaFuncionarios();

		try {

			String acao = request.getParameter("acao") == null ? "" : request.getParameter("acao");

			String caminhoJasper = getServletContext().getRealPath("/WEB-INF/classes/br/com/joao/sistema/relatorio/") + "/";
			String caminho = getServletContext().getRealPath("/");

			JRBeanCollectionDataSource jrDT = new JRBeanCollectionDataSource(funcionarios);
			Map parametros = new HashMap();
			parametros.put("titulo", "Relatorios de Funcionarios");
			parametros.put(funcionarios, jrDT);
			parametros.put("total", "Total de Funcionarios: " + funcionarios.size());
			JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoJasper + "funcionario.jasper", parametros, jrDT);

			if ("visualizar".equals(acao)) {
				JasperViewer.viewReport(jasperPrint, false);
			} else if ("pdf".equals(acao)) {
				JasperExportManager.exportReportToPdfFile(jasperPrint, caminho + "/RelatorioFuncionario.pdf");
				response.sendRedirect("RelatorioFuncionario.pdf");
			} else {
				response.sendRedirect("index.jsp");
			}

		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}

}
