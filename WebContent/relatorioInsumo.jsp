<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Relatório de Insumos</title>
<link href="css/style.css" rel="stylesheet">
<script type="text/javascript">
	function visualizarRelatorio() {
		enviar("visualizar");
	}

	function gerarRelatorioPDF() {
		enviar("pdf");
	}

	function enviar(acao) {
		document.forms[0].acao.value = acao;
		document.forms[0].target = "_blank";
		document.forms[0].action = "./RelatorioInsumoServlet";
		document.forms[0].submit();
	}

	function voltar() {
		document.forms[0].action = "index.jsp";
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<h1 class="h1">Relatório de Insumos</h1>

	<form action="./RelatorioServlet" method="post"
		onsubmit="return false;">
		<input type="hidden" name="acao" /> <input type="submit"
			value="Visualizar Relatorio"
			onclick="javascript:visualizarRelatorio();"> <input
			type="submit" value="Gerar Relatório PDF"
			onclick="javascript:gerarRelatorioPDF();"> <input
			type="submit" value="Voltar" onclick="javascript:voltar();">
	</form>
</body>
</html>