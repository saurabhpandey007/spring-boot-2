<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>Edit</title>
	<link rel="stylesheet" href="/css/edit.css" type="text/css">
	<link rel="stylesheet" href="/css/button.css" type="text/css">
</head>
<body class="centered">
	<h1>Welcome <b><c:out value="${pageContext.request.remoteUser}"></c:out></b></h1>
		<div class="centered">
			<h2>Edit</h2>
			
			<form:form action="edit" method="post" modelAttribute="syncJobDetail">
				<div>
				
					<table>
							<tr>
								<td>JOB ID</td>
								<td>
									<form:input path="jobId" readonly="true"/>
								</td>
							</tr>
							<tr>
								<td>JOB TYPE</td> 
								<td>
									<form:input path="jobType"/>
									<form:errors path="jobType" cssClass="error"/>
								</td>
							</tr>
							<tr>
								<td>DESCRIPTION</td> 
								<td>
									<form:input path="description"/>
									<form:errors path="description" cssClass="error"/>
								</td>
							</tr>
							<tr>
								<td>FREQUENCY</td> 
								<td>
									<form:input path="frequency" type="number"/>
									<form:errors path="frequency" cssClass="error"/>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									<input class="myButtonY" type="submit" value="EDIT">
								</td>
							</tr>
					</table>
					
					
				</div>
			</form:form>
			<br>
			<a href="/home">BACK</a>
			<br><br>
			<form action="/logout" method="post">
				<input class="myButtonB" type="submit" value="LOGOUT" /> 
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>	
		</div>
	</body>
</html>
