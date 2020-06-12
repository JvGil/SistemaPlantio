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
					<h:outputText value="Data do plantio: " styleClass="labelPlantio"/>
					<h:inputText value="#{plantioBacking.dataInicio}" maxlength="45" styleClass="textFields" onkeyup="masc_data(this)" />
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Data da colheita:" styleClass="labelColheita"/>
					<h:inputText value="#{plantioBacking.dataColheita}" maxlength="45" styleClass="textFields" onkeyup="masc_data(this)" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:commandButton value="Salvar" action="#{plantioBacking.salvar}" />
					<h:commandButton value="Cancelar" action="#{plantioBacking.voltaMenu}" />
				</h:panelGrid>
			</center>
		</h:form>
	</f:view>

</body>
</html>