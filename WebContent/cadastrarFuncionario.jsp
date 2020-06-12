<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="js/mascara.js" ></script>
	<title>Cadastro de funcionário</title>
</head>
<body>

	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form>
			<center>
				<h1 class="h1">Cadastro de Funcionário</h1>

				<h:panelGrid columns="1" styleClass="informacao">
					<h:messages />
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Nome: " styleClass="labelNome"/>
					<h:inputText value="#{funcionarioBacking.nome}" maxlength="45" styleClass="textFields"/>
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="CPF: " styleClass="labelCpf"/>
					<h:inputText value="#{funcionarioBacking.cpf}" maxlength="45" styleClass="textFields" onkeyup="masc_cpf(this)"/>
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="RG: " styleClass="labelRg"/>
					<h:inputText value="#{funcionarioBacking.rg}" maxlength="45" styleClass="textFields" onkeyup="masc_rg(this)"/>
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Sexo:" styleClass="labelSexo"/>
					<h:selectOneRadio value="#{funcionarioBacking.sexo}" styleClass="textRadios">
						<f:selectItem itemValue="F" itemLabel="Feminino" />
						<f:selectItem itemValue="M" itemLabel="Masculino" />
					</h:selectOneRadio>
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Data nascimento:" styleClass="labelDataNascimento"/>
					<h:inputText value="#{funcionarioBacking.dataNascimento}" maxlength="45" styleClass="textFields" onkeyup="masc_data(this)" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Telefone:" styleClass="labelTelefone"/>
					<h:inputText value="#{funcionarioBacking.telefone}" maxlength="45" styleClass="textFields" onkeyup="masc_telefone(this)" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Celular:" styleClass="labelCelular"/>
					<h:inputText value="#{funcionarioBacking.celular}" maxlength="45" styleClass="textFields" onkeyup="masc_celular(this)" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="E-mail: " styleClass="labelEmail"/>
					<h:inputText value="#{funcionarioBacking.email}" maxlength="45" styleClass="textFields"/>
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Estado:" styleClass="labelEstado"/>
					<h:inputText value="#{funcionarioBacking.estado}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Cidade:" styleClass="labelCidade"/>
					<h:inputText value="#{funcionarioBacking.cidade}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Cep:" styleClass="labelCep"/>
					<h:inputText value="#{funcionarioBacking.cep}" maxlength="45" styleClass="textFields" onkeyup="masc_cep(this)" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Bairro:" styleClass="labelBairro"/>
					<h:inputText value="#{funcionarioBacking.bairro}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Logradouro:" styleClass="labelLogradouro"/>
					<h:inputText value="#{funcionarioBacking.logradouro}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Número:" styleClass="labelNumero"/>
					<h:inputText value="#{funcionarioBacking.numero}" maxlength="45" styleClass="textFields" onkeyup="masc_numero(this)" />
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Complemento:" styleClass="labelComplemento"/>
					<h:inputText value="#{funcionarioBacking.complemento}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>
				
				<h:panelGrid columns="2">
					<h:outputText value="Salário:" styleClass="labelSalario"/>
					<h:inputText value="#{funcionarioBacking.salario}" maxlength="45" styleClass="textFields" />
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:commandButton value="Salvar" action="#{funcionarioBacking.salvar}" />
					<h:commandButton value="Cancelar"
						action="#{funcionarioBacking.voltaMenu}" />
				</h:panelGrid>
			</center>
		</h:form>
	</f:view>

</body>
</html>