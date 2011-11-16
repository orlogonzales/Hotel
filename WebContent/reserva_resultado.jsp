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
		<c:if test="${success == 'yes'}">
			<p class="message success">Reserva feita com sucesso</p>
			<p><div class="reserva_num">Reserva NR: <span>${reserva_id}</span></div></p>
			<a href="/Hotel/">Início</a>
		</c:if>
		<c:if test="${success == 'no'}">
			<c:forEach var="message" items="${messages}">	
				<p class="message warning">${message}</p>
			</c:forEach>
			<a href="javascript: history.back();">Voltar</a>
		</c:if>
		</article>
		<c:import url="rodape.jsp"/>
	</body>
</html>
