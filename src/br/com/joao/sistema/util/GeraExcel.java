package br.com.joao.sistema.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import br.com.joao.sistema.bean.Fazenda;
import br.com.joao.sistema.bean.Funcionario;
import br.com.joao.sistema.bean.Insumo;
import br.com.joao.sistema.controller.FazendaController;
import br.com.joao.sistema.controller.InsumoController;
import br.com.joao.sistema.dao.FuncionarioDAO;

/**
 *
 * @author jgil
 */
public class GeraExcel {

    private static final String funcionarios = "C:/Teste/Relatatório de funcionários.xls";
    private static final String fazendas = "C:/Teste/Relatatório de fazendas.xls";
    private static final String insumos = "C:/Teste/Relatatório de insumos.xls";

    public static void geraExcel(String col1, String col2, String col3, Object object) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Relatório");

        int rownum = 0;
        Row row = sheet.createRow(rownum++);

        int cellnum = 0;

        Cell cellCol1 = row.createCell(cellnum++);
        cellCol1.setCellValue(col1);

        Cell cellCol2 = row.createCell(cellnum++);
        cellCol2.setCellValue(col2);

        Cell cellCol3 = row.createCell(cellnum++);
        cellCol3.setCellValue(col3);
        
        row = sheet.createRow(rownum++);
        cellnum = 0;

        if (object instanceof Funcionario) {
            GeraExcel aux = new GeraExcel();
            aux.geraExcelFuncionarios(row, cellnum, rownum, sheet, workbook);
        }
        if (object instanceof Fazenda) {
        	GeraExcel aux = new GeraExcel();
        	aux.geraExcelFazendas(row, cellnum, rownum, sheet, workbook);
        }
        if (object instanceof Insumo) {
        	GeraExcel aux = new GeraExcel();
        	aux.geraExcelInsumos(row, cellnum, rownum, sheet, workbook);
        }
    }

    private void geraExcelFuncionarios(Row row, int cellnum, int rownum, HSSFSheet sheetFuncionario, HSSFWorkbook workbook) {
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
        try {
            listaFuncionarios = dao.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(GeraExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < listaFuncionarios.size(); i++) {
            Cell cellDescricao = row.createCell(cellnum++);
            cellDescricao.setCellValue(listaFuncionarios.get(i).getNome());

            Cell cellRazaoSocial = row.createCell(cellnum++);
            cellRazaoSocial.setCellValue(listaFuncionarios.get(i).getDataNascimento());

            Cell cellQtdeEstoque = row.createCell(cellnum++);
            cellQtdeEstoque.setCellValue(listaFuncionarios.get(i).getCidade());
            
            row = sheetFuncionario.createRow(rownum++);
            cellnum = 0;
        }

        try {
            FileOutputStream out = new FileOutputStream(new File(funcionarios));
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            // Arquivo nÃ£o encontrado
            e.printStackTrace();
        } catch (IOException e) {
            // Erro na criaÃ§Ã£o do arquivo
            e.printStackTrace();
        }
    }

    private void geraExcelFazendas(Row row, int cellnum, int rownum, HSSFSheet sheetFazenda, HSSFWorkbook workbook) {
    	FazendaController controller = new FazendaController();
    	List<Fazenda> listaFazendas = new ArrayList<Fazenda>();
    	try {
    		listaFazendas = controller.buscarTodos();
    	} catch (Exception ex) {
    		Logger.getLogger(GeraExcel.class.getName()).log(Level.SEVERE, null, ex);
    	}
    	
    	for (int i = 0; i < listaFazendas.size(); i++) {
    		Cell cellDescricao = row.createCell(cellnum++);
    		cellDescricao.setCellValue(listaFazendas.get(i).getNome());
    		
    		Cell cellRazaoSocial = row.createCell(cellnum++);
    		cellRazaoSocial.setCellValue(listaFazendas.get(i).getAreaTotal());
    		
    		Cell cellQtdeEstoque = row.createCell(cellnum++);
    		cellQtdeEstoque.setCellValue(listaFazendas.get(i).getCidade());
    		
    		row = sheetFazenda.createRow(rownum++);
    		cellnum = 0;
    	}
    	
    	try {
    		FileOutputStream out = new FileOutputStream(new File(fazendas));
    		workbook.write(out);
    		out.close();
    	} catch (FileNotFoundException e) {
    		// Arquivo nÃ£o encontrado
    		e.printStackTrace();
    	} catch (IOException e) {
    		// Erro na criaÃ§Ã£o do arquivo
    		e.printStackTrace();
    	}
    }
    
    private void geraExcelInsumos(Row row, int cellnum, int rownum, HSSFSheet sheetInsumo, HSSFWorkbook workbook) {
    	InsumoController controller = new InsumoController();
    	List<Insumo> listaInsumos = new ArrayList<Insumo>();
    	try {
    		listaInsumos = controller.buscarTodos();
    	} catch (Exception ex) {
    		Logger.getLogger(GeraExcel.class.getName()).log(Level.SEVERE, null, ex);
    	}
    	
    	for (int i = 0; i < listaInsumos.size(); i++) {
    		Cell cellDescricao = row.createCell(cellnum++);
    		cellDescricao.setCellValue(listaInsumos.get(i).getTipo());
    		
    		Cell cellRazaoSocial = row.createCell(cellnum++);
    		cellRazaoSocial.setCellValue(listaInsumos.get(i).getNome());
    		
    		Cell cellQtdeEstoque = row.createCell(cellnum++);
    		cellQtdeEstoque.setCellValue(listaInsumos.get(i).getValor());
    		
			row = sheetInsumo.createRow(rownum++);
			cellnum = 0;
    	}
    	
    	try {
    		FileOutputStream out = new FileOutputStream(new File(insumos));
    		workbook.write(out);
    		out.close();
    	} catch (FileNotFoundException e) {
    		// Arquivo nÃ£o encontrado
    		e.printStackTrace();
    	} catch (IOException e) {
    		// Erro na criaÃ§Ã£o do arquivo
    		e.printStackTrace();
    	}
    }
}
