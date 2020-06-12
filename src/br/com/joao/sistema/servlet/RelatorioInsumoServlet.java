package br.com.joao.sistema.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.joao.sistema.controller.InsumoController;
import br.com.joao.sistema.vo.InsumoVO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioInsumoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RelatorioInsumoServlet() {
		super();
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<InsumoVO> insumos = new InsumoController().retornaInsumos();

		try {

			String acao = request.getParameter("acao") == null ? "" : request.getParameter("acao");

			String caminhoJasper = getServletContext().getRealPath("/WEB-INF/classes/br/com/joao/sistema/relatorio/") + "/";
			String caminho = getServletContext().getRealPath("/");

			JRBeanCollectionDataSource jrDT = new JRBeanCollectionDataSource(insumos);
			Map parametros = new HashMap();
			parametros.put("titulo", "Relatorios de Insumos");
			parametros.put(insumos, jrDT);
			parametros.put("total", "Total de Insumos: " + insumos.size());
			JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoJasper + "insumo.jasper", parametros, jrDT);

			if ("visualizar".equals(acao)) {
				JasperViewer.viewReport(jasperPrint, false);
			} else if ("pdf".equals(acao)) {
				JasperExportManager.exportReportToPdfFile(jasperPrint, caminho + "/RelatorioInsumo.pdf");
				response.sendRedirect("RelatorioInsumo.pdf");
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
