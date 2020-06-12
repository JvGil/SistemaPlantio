package br.com.joao.sistema.backingbean;

import java.text.DecimalFormat;

public class CalculadoraBacking {
	private int totalDePlantas = 0; // a cada 4m²
	private int frutosPorPlanta = 0;
	private double valorFruto = 0;
	private double hectares = 0; // area em hectares que você deseja saber seu lucro
	private String lucro;
	
	
	/* COMO CALCULAR LUCRO
	 * Tenho 5 plantas em 4m² cada planta da 10 frutos, qual o meu lucro com 10 hectares sabendo que cada fruto vale 5 reais?
	 * 
	 * 10*5= 50 frutos a cada 4m²
	 * 4m² ----- 50 frutos
	 * 10 000 -- X frutos
	 * X = 10 000 * 50 / 4
	 * X = 125 000
	 * 
	 * 125K em 1 hectare
	 * 1 250 000 em 10 hectares
	 *  1 250 000 * 5
	 *  6 250 000
	 *  
	 */

	/**
	 * 
	 * @return total de plantas a cada 4m²
	 */
	public int getTotalDePlantas() {
		return totalDePlantas;
	}

	public void setTotalDePlantas(int totalDePlantas) {
		this.totalDePlantas = totalDePlantas;
	}

	public int getFrutosPorPlanta() {
		return frutosPorPlanta;
	}

	public void setFrutosPorPlanta(int frutosPorPlanta) {
		this.frutosPorPlanta = frutosPorPlanta;
	}

	public double getValorFruto() {
		return valorFruto;
	}

	public void setValorFruto(double valorFruto) {
		this.valorFruto = valorFruto;
	}

	public double getHectares() {
		return hectares;
	}

	public void setHectares(double hectares) {
		this.hectares = hectares;
	}
	
	public String getLucro() {
		return lucro;
	}

	public void setLucro(String lucro) {
		this.lucro = lucro;
	}

	public String voltaMenu() {
		limparCampos();
		return "";
	}
	
	public String novoCalculo() {
		limparCampos();
		return "";
	}
	
	public String fazCalculo() {
		retornaLucro();
		return "";
	}
	
	public void limparCampos() {
		totalDePlantas = 0;
		frutosPorPlanta = 0;
		valorFruto = 0;
		hectares = 0;
		lucro = null;
	}

	public void retornaLucro() {
		lucro = new DecimalFormat("R$#,##0.00").format((((frutosPorPlanta*totalDePlantas)*(hectares*10000)/4)*valorFruto));
	}

}
