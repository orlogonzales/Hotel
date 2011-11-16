<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.*, br.edu.mackenzie.model.*" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Hotel Mackenzie</title>
		<link type="text/css" href="common.css" rel="stylesheet">
		<link type="text/css" href="jquery-ui-1.8.16.custom.css" rel="stylesheet">
		<script src="/Hotel/js/jquery.js" type="text/javascript"></script>
		<script src="/Hotel/js/jquery-ui.js" type="text/javascript"></script>
		<script src="/Hotel/js/common.js" type="text/javascript"></script>
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		<article class="article_content">
		<p class="message">Preencha os campos abaixo para fazer uma reserva:</p>
		<form method="post" action="/Hotel/controller" id="formReserva">  <%-- Nome da classe controladora na action (nunca muda) --%>
			<h2>Dados Pessoais</h2>
			<p><label for="nome">Nome:</label><input type="text" name="nome" id="nome" size="50"></p>
			<p><label for="endereco">Endereço:</label><input type="text" name="endereco" id="endereco" size="50"></p>
			<p><label for="telefone">Telefone:</label><input type="text" name="telefone" id="telefone" size="15"></p>
			<p><label for="cidade">Cidade:</label><input type="text" name="cidade" id="cidade" size="10"></p>
			<p><label for="cep">Cep:</label><input type="text" name="cep" id="cep" size="10"></p>
			<p><label for="estado">Estado:</label><input type="text" name="estado" id="estado" size="10"></p>
			<p><label for="pais">País:</label><input type="text" name="pais" id="pais" size="10"></p>
			<p><label for="email">E-mail:</label><input type="text" name="email" id="email" size="30"></p>
			<h2>Reserva</h2>
 			
			<p><label for="hotel">Hotel:</label><select name="hotel">
			<option value="" selected="selected"></option>
			<c:forEach var="nome" items="${nomes}">
			<option value="${nome}">${nome}</option>
			</c:forEach>
			</select></p>
			<p><label for="tipo_quarto">Tipo do quarto:</label><select name="tipo_quarto" id="tipo_quarto">
  					<option value=""></option>
  					<option value="master">Suíte Master</option>
  					<option value="comum">Suíte Comum</option>
  					<option value="presidencial">Suíte presidencial</option>
  					<option value="alone">Alone</option>
				</select></p>
			<p><label for="check_in">Data de Entrada:</label><input type="text" class="use_datepicker" name="check_in" id="check_in"></p>
			<p><label for="check_out">Data de Saida:</label><input type="text" class="use_datepicker" name="check_out" id="check_out"></p>
			<p><label>Cafe da manhã:</label><label class="normal"><input type="radio" name="cafe" value="sim" checked="checked">Sim</label> <label class="normal"><input type="radio" name="cafe" value="nao">Não</label></p>
			<h2>Pagamento</h2>
			<p><label for="tipo_cartao">Tipo do Cartão: </label><select id="tipo_cartao" name="tipo_cartao">
				<option value=""></option>
				<option value="master">MasterCard</option>
				<option value="visa">Visa</option>
				<option value="dinners">Dinners Club</option>
			</select></p>
			<p><label for="numero_cartao">Número do Cartão:</label><input type="text" name="numero_cartao" id="numero_cartao" size="40"></p>
			<p><input type="submit" value="Fazer Reserva"></p>
			<input type="hidden" name="action" value="FazerReserva" id="logica"> <%-- Nome da classe action (input necessário com id sempre o mesmo : logica) --%>
		</form>
		</article>
		<c:import url="rodape.jsp"/>
	</body>
</html>
