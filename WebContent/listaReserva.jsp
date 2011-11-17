<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.*, br.edu.mackenzie.model.*"%>
<html>
<head>
<link type="text/css" href="common.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Reservas</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<article class="article_content">
		<h1>Digite o id da sua Reserva:</h1>
		<br>
		<form action="controller" name="listaReserva" method="post">
			<input type="text" name="idReserva"> <input type="hidden"
				name="action" value="ListaReserva"> <input type="submit"
				value="Buscar">
		</form>
		<c:if test="${sucesso}">
			<p class="message success">Reserva ocupada com sucesso!</p>
		</c:if>
		<c:if test="${existe ==false}">
			<p class="message warning">Reserva não encontrada!</p>
		</c:if>
		<c:if test="${existe}">
			<form action="controller">
				<input type="hidden" name="action" value="OcupaReserva"> <input
					type="hidden" name="idReserva" value="${id}">
				<table>
					<tr>
						<th>ID</th>
						<th>Cliente</th>
						<th>Hotel</th>
						<th>Quarto</th>
						<th>Check-In</th>
						<th>Check-Out</th>
						<th>Café</th>
						<th>&nbsp;</th>
					</tr>
					<tr>
						<td>${id}</td>
						<td>${cliente}</td>
						<td>${hotel}</td>
						<td>${quarto}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${check_in}" />
						</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${check_out}" />
						</td>
						<td>${cafe }</td>
						<td><input type="submit" name="botaoOcupa" value="Ocupar">
						</td>
					</tr>
				</table>
			</form>
		</c:if>
	</article>
	<c:import url="rodape.jsp" />
</body>
</html>