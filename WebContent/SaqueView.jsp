<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>..:: BANCO USJT ::.. - Saque</title>
  </head>

<body>
<h2 style="padding-bottom: 10px; border-bottom: 1px solid #eee;">SAQUE<br><br><span style="text-align: right;">Marcelo Barbosa<br>Ag 3129 C/C 07888-1</span></h2>

<table style="width: 100%">
	<thead>
		<tr>
			<td>Saldo Atual</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>R$ 1.200,00</td>
		</tr>
	</tbody>
</table>

<h4 style="padding-bottom: 10px; border-bottom: 1px solid #eee;">SAQUE</h4>

<form action="ManterCliente.do"method="post" target="">
	<input type="hidden" id="hdValorSaque" name="hdValorSaque" value="" />
	<input type="text" id="valorSaque" value="R$ 0,00" /><input type="button" onclick="limparSaque();" value="Limpar">

	<table style="width: 100%; margin-top: 20px;">
		<tr>
			<td><center><input type="button" value="R$ 10,00" onclick="setValor('10');" style="width: 150px; height: 150px;" /></center></td>
			<td><center><input type="button" value="R$ 20,00" onclick="setValor('20');" style="width: 150px; height: 150px;" /></center></td>
		</tr>
		<tr>
			<td><center><input type="button" value="R$ 50,00" onclick="setValor('50');" style="width: 150px; height: 150px;" /></center></td>
			<td><center><input type="button" value="R$ 100,00" onclick="setValor('100');" style="width: 150px; height: 150px;" /></center></td>
		</tr>
	</table>
	
	<center>
		<input type="button" value="EFETUAR SAQUE" style="height: 100px; width: 200px;" onclick="verificaSaque();" />
	</center>
</form>

<h3 style="margin-top: 100px;border-bottom: 1px solid #eee;"><center>Banco USJT</center></h2>

<script type="text/javascript">
	var valor = 0;
	
	function limparSaque()
	{
		valor = 0;
		document.getElementById("valorSaque").value = "R$ 0,00";
		document.getElementById("hdValorSaque").value = valor;
	}
	
	function setValor(v)
	{
		valor = valor + parseInt(v);
		document.getElementById("valorSaque").value = "R$ "+ valor +",00";
		document.getElementById("hdValorSaque").value = valor;
	}
	
	function verificaSaque()
	{
		if(valor == 0)
		{
			alert('Informe um valor para sacar!')
		}
		else
		{
			document.getElementById("frmSaque").submit();
		}
	}
</script>

</body>