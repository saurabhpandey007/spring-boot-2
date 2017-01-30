<%@page import="com.controller.AmwayController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="/css/app.css" type="text/css">
	<link rel="stylesheet" href="/css/button.css" type="text/css">
	<script type="text/javascript" src="/js/popup.js"></script>
</head>
<body>
	<h1>Welcome <b><c:out value="${pageContext.request.remoteUser}"></c:out></b></h1>
	<div class="centered">
		<h2>JOBS STATUS</h2>
		<div>
			<table border="1">
					<tr>
					    <th>JOB ID</th>
					    <th>JOB TYPE</th>
					    <th>DESCRIPTION</th> 
					    <th>FREQUENCY</th>
					    <c:if test="${user.status == 1}">
					    	<th>ACTION</th>
					    </c:if>
		  			</tr>
				<c:forEach items="${requestScope.SyncJobDetails}" var="SyncJob">
				
					<%-- <tr>
							<td>
								<a onclick="popupCenter('detail?jobId=${SyncJob.jobId}', 'Details',850,350);" href="javascript:void(0);">${SyncJob.jobId}</a>
							</td>
							<td>
								${SyncJob.jobType}
							</td>
							<td>
								${SyncJob.description}
							</td>
							<td>
								${SyncJob.frequency}
							</td>
							<c:if test="${user.status == 1}">
								<td>
								    <a onclick="popupCenter('show?id=${SyncJob.jobId}&type=${SyncJob.jobType}&frequency=${SyncJob.frequency}&description=${SyncJob.description}', 'Details',850,350);" href="javascript:void(0);">Edit</a>
								</td>
							 </c:if>
					</tr> --%>
					
					<tr>
						<form:form action="show" method="post" modelAttribute="syncJobDetail">
							<td>
								<form:hidden path="jobId" value="${SyncJob.jobId}" />
								<a onclick="popupCenter('detail?jobId=${SyncJob.jobId}', 'Details',850,350);" href="javascript:void(0);">${SyncJob.jobId}</a>
							</td>
							<td>
							    <form:hidden path="jobType" value="${SyncJob.jobType}" />
								${SyncJob.jobType}
							</td>
							<td>
								<form:hidden path="description" value="${SyncJob.description}" />
								${SyncJob.description}
							</td>
							<td>
								<form:hidden path="frequency" value="${SyncJob.frequency}" />
								${SyncJob.frequency}
							</td>
							<c:if test="${user.status == 1}">
								<td>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								    <input type="submit" value="EDIT">
								</td>
							 </c:if>
						 </form:form>
					</tr>
					
				</c:forEach>
			</table>
		</div>
		<br>
		<a class="myButtonG" href="start">START</a>
		<a class="myButtonY" href="rescedule">RESCEDULE</a>
		<a class="myButtonY" href="restart">RESTART</a>
		<a class="myButtonR" href="stop">STOP</a>
		<br><br>
			
		<form action="/logout" method="post">
			<input class="myButtonB"  type="submit" value="LOGOUT" /> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>	
		
	</div>
</body>
</html>
