<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="sample.Beans.MenuBeans"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<meta charset="UTF-8">
		<title>業務メニュー</title>
		<link rel="stylesheet" href="./CSS/menu.css" type="text/css">
		<script type="text/javascript" src="./JS/menu.js"></script>

		<c:set var="title">業務メニュー</c:set>

	</head>
	<body>
		<tr>
			<th class="login_name">利用者：</th>
			<td class="login_name">${username}</td>
		</tr>
		<h1 align="center">${title}</h1>
		<hr>
	
	
		<table border="0">
		
			<tr>
				<th>業務名</th>
				<th>説明</th>
			</tr>	
		
			<c:forEach var="menu" items="${menulist}">
				<tr>
					<td>${menu.menunn}</td>
					<td>${menu.menumm}</td>
				</tr>
			</c:forEach>
		
		</table>
	</body>
</html>





