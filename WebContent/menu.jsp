<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div>

		<f:subview id="view">
			
			<h:form id="menu">

				<rich:toolBar styleClass="topbar">
					<rich:dropDownMenu value="Cadastrar" itemClass="row">
						<rich:menuItem id="menu1" value="Fazenda" action="#{fazendaBacking.cadastraFazenda}"></rich:menuItem>
						<rich:menuItem id="menu2" value="Funcionario" action="#{funcionarioBacking.cadastraFuncionario}"></rich:menuItem>
						<rich:menuItem id="menu3" value="Insumos" action="#{insumoBacking.cadastraInsumo}"></rich:menuItem>
						<rich:menuItem id="menu4" value="Plantio" action="#{plantioBacking.cadastraPlantio}"></rich:menuItem>
					</rich:dropDownMenu>
					<rich:dropDownMenu value="Consultar">
						<rich:menuItem id="menu5" value="Fazenda" action="#{fazendaBacking.consultaFazenda}"></rich:menuItem>
						<rich:menuItem id="menu6" value="Funcionario" action="#{funcionarioBacking.consultaFuncionario}"></rich:menuItem>
						<rich:menuItem id="menu7" value="Insumo" action="#{insumoBacking.consultaInsumo}"></rich:menuItem>
					</rich:dropDownMenu>
					<rich:dropDownMenu value="Relatórios">
						<rich:menuItem id="menu9" value="Relatório de fazendas" action="#{relatorioBacking.relatorioFazenda}"></rich:menuItem>
						<rich:menuItem id="menu10" value="Relatório de fazendas (EXCEL)" action="#{fazendaBacking.geraExcel}"></rich:menuItem>
						<rich:menuItem id="menu11" value="Relatório de funcionarios" action="#{relatorioBacking.relatorioFuncionario}"></rich:menuItem>
						<rich:menuItem id="menu12" value="Relatório de Funcionários (EXCEL)" action="#{funcionarioBacking.geraExcel}"></rich:menuItem>
						<rich:menuItem id="menu13" value="Relatório de Insumos" action="#{relatorioBacking.relatorioInsumo}"></rich:menuItem>
						<rich:menuItem id="menu14" value="Relatório de Insumos (EXCEL)" action="#{insumoBacking.geraExcel}"></rich:menuItem>
					</rich:dropDownMenu>
					<rich:dropDownMenu value="Calculadoras">
						<rich:menuItem id="menu15" value="Lucro" action="#{calculadoraBacking.novoCalculo}"></rich:menuItem>
					
					</rich:dropDownMenu>
				</rich:toolBar>
			</h:form>
		</f:subview>
	</div>
</body>
</html>