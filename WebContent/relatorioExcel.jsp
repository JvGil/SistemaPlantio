<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="js/mascara.js" ></script>
	<title>Relatório Excel</title>
</head>
<body>

	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form>
			<center>

				<h:panelGrid columns="1" styleClass="informacao">
					<h1 class="h1">RELATÓRIO GERADO COM SUCESSO!</h1>
					<p class="h1"> Confira sua pasta C:/Teste </p>
				</h:panelGrid>
				
				<h:panelGrid columns="1">
					<h:commandButton value="Voltar para o Menu" action="#{fazendaBacking.voltaMenu}" />
				</h:panelGrid>
			</center>
		</h:form>
	</f:view>

</body>
</html>