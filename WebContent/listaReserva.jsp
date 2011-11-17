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
	<h1>Digite o id da sua Reserva:</h1>
	<br>
	<form action="controller" name="listaReserva" method="post">
		<input type="text" name="idReserva">
		<input type="hidden" name="action" value="ListaReserva">
		<input type="submit" value="Buscar">
	</form>
<table>
<tr>
<td>ID</td>
<td>Cliente</td>
<td>Hotel</td>
<td>Quarto</td>
<td>Check-In</td>
<td>Check-Out</td>
<td>Café</td>
</tr>
</table>
	<c:import url="rodape.jsp" />
</body>
</html>