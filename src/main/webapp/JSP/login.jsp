<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<title>ログイン</title>
		<link rel="stylesheet" href="./CSS/login.css" type="text/css">
		<script type="text/javascript" src="./JS/login.js"></script>
	</head>

	<body onload="fieldChanged();">
		<h1 align="center">ログイン</h1>
		<hr>
		<div align="center">
			<table border="0">
				<form method="post" action="/filtersys/LoginCheck" name="loginform">
					<input type="hidden" name="action" value="login_action">
						<tr>
							<th class="login_field">ユーザID</th>
							<td class="login_field">
								<input type="text" name="user_id" value="${user_id}" size="24" id="user_id"
								onkeyup="fieldChanged();"
								onchange="fieldChanged();">
							</td>
						</tr>
						<tr>
							<th class="login_field">パスワード</th>
							<td class="login_field">
								<input type="password" name="password" value="" size="24" id="password"
								onkeyup="fieldChanged();"
								onchange="fieldChanged();">
							</td>
						</tr>
						<tr>
							<td colspan="2" class="login_button">
								<input type="submit" value="ログイン" id="login">
							</td>
						</tr>
				</form>
			</table>
			<br>
			<br>
			<hr>
			<span class="messege">${message}</span>
		</div>
	</body>

</html>
