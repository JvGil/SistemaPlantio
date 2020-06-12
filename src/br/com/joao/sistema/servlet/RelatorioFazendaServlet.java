package br.com.joao.sistema.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.joao.sistema.controller.FazendaController;
import br.com.joao.sistema.vo.FazendaVO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioFazendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RelatorioFazendaServlet() {
		super();
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<FazendaVO> fazendas = new FazendaController().retornaFazendas();

		try {

			String acao = request.getParameter("acao") == null ? "" : request.getParameter("acao");

			String caminhoJasper = getServletContext().getRealPath("/WEB-INF/classes/br/com/joao/sistema/relatorio/") + "/";
			String caminho = getServletContext().getRealPath("/");

			JRBeanCollectionDataSource jrDT = new JRBeanCollectionDataSource(fazendas);
			Map parametros = new HashMap();
			parametros.put("titulo", "Relatorios de Fazendas");
			parametros.put(fazendas, jrDT);
			parametros.put("total", "Total de Fazendas: " + fazendas.size());
			JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoJasper + "fazenda.jasper", parametros, jrDT);

			if ("visualizar".equals(acao)) {
				JasperViewer.viewReport(jasperPrint, false);
			} else if ("pdf".equals(acao)) {
				JasperExportManager.exportReportToPdfFile(jasperPrint, caminho + "/RelatorioFazenda.pdf");
				response.sendRedirect("RelatorioFazenda.pdf");
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
