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
<title>Lista de Reservas</title>
</head>
<body>

	<c:import url="cabecalho.jsp" />
	<h3>Lista de Reservas</h3>
	<br>
	<table>
	<tr>
		<%
			List<Reserva> reservas = Reserva.getReservas() ;
			for ( Reserva reserva : reservas ) {%>
			<td>
				<%=reserva.get("hotel_id")%>
				<%=reserva.get("reserva_id")%>
				<%=reserva.get("quarto_id")%>
				<%=reserva.get("check_in")%>
				<%=reserva.get("check_out")%>
				<%=reserva.get("cafe")%>
			</td>
		<%}%>
	</tr>
	</table>
	<c:import url="rodape.jsp" />
</body>
</html>