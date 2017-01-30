<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<style>
		   body {
			    margin: 0;
			    padding: 0;
			    text-align: center; /* !!! */
			}
			.centered {
			    margin: 0 auto;
			    text-align: center;
			    width: 700px;
			}
	        .login{
		        width: 250px;
	        }
	        .error {
			  	color: red;
			}
			.info {
			  	color: #18ab29;
			}
	</style>
</head>
<body >
	<div class="centered">
		<h2>Login</h2>

		<form action="/amway-1.4.0.RELEASE/login" method="post">
			<div >
				<c:if test="${param.error ne null}">
					<div class="error">Invalid username and password.</div>
				</c:if>
				<c:if test="${param.logout ne null}">
					<div class="info">You have been logged out.</div>
				</c:if>
				<br>
				<div>
					<input class="login" type="text"  name="username" placeholder="User Name" />
				</div>
				<br>
				<div>
					<input class="login" type="password" name="password" placeholder="Password" />
				</div>
				<br>
				<div>
					<input type="submit" value="Sign In"/>
				</div>
				
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>
