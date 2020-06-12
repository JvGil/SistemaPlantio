<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="js/mascara.js" ></script>
	<title>Cadastro de insumos</title>
</head>
<body>

	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form>
			<center>
				<h1 class="h1">Cadastro de insumos</h1>

				<h:panelGrid columns="1" styleClass="informacao">
					<h:messages />
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Tipo: " styleClass="labelTipo"/>
					<h:inputText value="#{insumoBacking.tipo}" maxlength="45" styleClass="textFields"/>
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Nome:" styleClass="labelNome"/>
					<h:inputText value="#{insumoBacking.nome}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Quantidade:" styleClass="labelQuantidade"/>
					<h:inputText value="#{insumoBacking.quantidade}" maxlength="45" styleClass="textFields" onkeyup="masc_numero(this)"/>
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Valor:" styleClass="labelValor"/>
					<h:inputText value="#{insumoBacking.valor}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:commandButton value="Salvar" action="#{insumoBacking.salvar}" />
					<h:commandButton value="Cancelar" action="#{insumoBacking.voltaMenu}" />
				</h:panelGrid>
			</center>
		</h:form>
	</f:view>

</body>
</html>