<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="js/mascara.js" ></script>
	<title>Alteração de fazenda</title>
</head>
<body>

	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form>
			<center>
				<h1 class="h1">Ateração de Fazenda</h1>

				<h:panelGrid columns="1" styleClass="informacao">
					<h:messages />
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Nome: " styleClass="labelNome"/>
					<h:inputText value="#{fazendaBacking.nome}" maxlength="45" styleClass="textFields" readonly="true"/>
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Estado:" styleClass="labelEstado"/>
					<h:inputText value="#{fazendaBacking.estado}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Cidade:" styleClass="labelCidade"/>
					<h:inputText value="#{fazendaBacking.cidade}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Cep:" styleClass="labelCep"/>
					<h:inputText value="#{fazendaBacking.cep}" maxlength="45" styleClass="textFields" onkeyup="masc_cep(this)" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Bairro:" styleClass="labelBairro"/>
					<h:inputText value="#{fazendaBacking.bairro}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Logradouro:" styleClass="labelLogradouro"/>
					<h:inputText value="#{fazendaBacking.logradouro}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Número:" styleClass="labelNumero"/>
					<h:inputText value="#{fazendaBacking.numero}" maxlength="45" styleClass="textFields" onkeyup="masc_numero(this)" />
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Complemento:" styleClass="labelComplemento"/>
					<h:inputText value="#{fazendaBacking.complemento}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:outputText value="Area total (m²):" styleClass="labelAreaTotal"/>
					<h:inputText value="#{fazendaBacking.areaTotal}" maxlength="45" styleClass="textFields" readonly="true"/>
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:commandButton value="Salvar" action="#{fazendaBacking.alterar}" />
					<h:commandButton value="Cancelar" action="#{fazendaBacking.voltaMenu}" />
				</h:panelGrid>
			</center>
		</h:form>
	</f:view>

</body>
</html>