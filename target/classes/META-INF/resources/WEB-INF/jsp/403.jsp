<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>403</title>
<link rel="stylesheet" href="/css/app.css" type="text/css">
</head>
<body >
	<div class="centered">
	<h2>ERROR</h2>
		
	</div>
	<div>		
		<div>
			<h2 class="error">You do not have permission to access this page!</h2>	
		</div>
		<form action="/logout" method="post">
			<input type="submit" value="Sign in as different user" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>		
	</div>	
</body>
</html>
