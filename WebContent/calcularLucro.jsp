<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculadora de lucro</title>
</head>
<body>
	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form>
			<center>
				<h1 class="h1">Calculadora de Lucro em plantação</h1>

				<h:panelGrid columns="1" styleClass="informacao">
					<h:messages />
				</h:panelGrid>

				<p class="explicacao">Obs.: Para calcular o lucro em uma plantação necessitamos de alguns dados como o número de plantas a cada 4m², 
				   quantos frutos cada planta nos dá, em quantos hectares você deseja fazer o cálculo e qual o valor por 
				   fruto daquela planta </p>
				
				<h:panelGrid columns="2">
					<h:outputText value="Quantidade de plantas (4m²): " styleClass="labelQtdePlantas" />
					<h:inputText value="#{calculadoraBacking.totalDePlantas}" maxlength="45" styleClass="textFields" onkeyup="masc_numero(this)" />
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Frutos por planta: " styleClass="labelFrutos" />
					<h:inputText value="#{calculadoraBacking.frutosPorPlanta}" maxlength="45" styleClass="textFields" onkeyup="masc_numero(this)" />
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Valor por fruto: " styleClass="labelValorFrutos" />
					<h:inputText value="#{calculadoraBacking.valorFruto}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Hectares de plantação: " styleClass="labelHectares" />
					<h:inputText value="#{calculadoraBacking.hectares}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>
				
				<h:panelGrid columns="1">
					<h:commandButton value="Calcular" action="#{calculadoraBacking.fazCalculo}" styleClass="botaoCancelar"/>
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Lucro na colheita: " styleClass="labelLucro" />
					<h:inputText value="#{calculadoraBacking.lucro}" maxlength="45" styleClass="textFields" readonly="true"/>
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:commandButton value="Novo Cálculo" action="#{calculadoraBacking.novoCalculo}" styleClass="botaoGeral" />
					<h:commandButton value="Cancelar" action="#{calculadoraBacking.voltaMenu}" styleClass="botaoGeral" />
				</h:panelGrid>
			</center>
		</h:form>
	</f:view>
</body>
</html>