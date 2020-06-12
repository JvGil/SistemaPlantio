<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Funcionário</title>
</head>
<body>
	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>

		<h:form id="formConsulta">
			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>

			<center>
				<a4j:keepAlive beanName="funcionarioBacking" ajaxOnly="true" />
				<rich:spacer height="30" />
				<rich:dataTable width="490" id="listaFuncionarios" rows="10"
					columnClasses="col" value="#{funcionarioBacking.listaFuncionarios}"
					var="funcionario">
					<f:facet name="header">
						<rich:columnGroup>
							<rich:column>
								<h:outputText value="Nome" />
							</rich:column>
							<rich:column>
								<h:outputText value="Telefone" />
							</rich:column>
							<rich:column>
								<h:outputText value="Data de Nascimento" />
							</rich:column>
							<rich:column colspan="2">
								<h:outputText value="Ações" />
							</rich:column>
						</rich:columnGroup>
					</f:facet>

					<rich:column>
						<h:outputText value="#{funcionario.nome}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{funcionario.telefone}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{funcionario.dataNascimento}" />
					</rich:column>
					<rich:column>
						<h:commandLink value="Alterar"
							action="#{funcionarioBacking.alteraFuncionario}">
							<f:setPropertyActionListener value="#{funcionario}"
								target="#{funcionarioBacking.funcionarioSelecionado}" />
						</h:commandLink>
					</rich:column>
					<rich:column>
						<h:commandLink value="Excluir" action="#{funcionarioBacking.excluir}">
							<f:setPropertyActionListener value="#{funcionario}"
								target="#{funcionarioBacking.funcionarioSelecionado}" />
						</h:commandLink>
					</rich:column>
				</rich:dataTable>
			</center>
			<rich:datascroller align="center" for="listaFuncionarios" maxPages="20" page="#{funcionarioBacking.scrollerPage}" id="sc2" reRender="listaFuncionarios" />

			<h:panelGrid columns="1">
				<h:commandButton value="Cancelar" action="#{funcionarioBacking.voltaMenu}" />
			</h:panelGrid>
		</h:form>
	</f:view>
</body>
</html>